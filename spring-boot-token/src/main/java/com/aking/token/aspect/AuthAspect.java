package com.aking.token.aspect;

import cn.hutool.core.util.StrUtil;
import com.aking.token.annotations.Auth;
import com.aking.token.context.SessionContext;
import com.aking.token.dto.AuthSessionDTO;
import com.aking.token.exception.NoLoginException;
import com.aking.token.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Title: Auth 注解切面
 *
 * @author Y10003453
 */
@Aspect
@Component
@Slf4j
public class AuthAspect {
    /**
     * header 中 token 的名称
     */
    private final static String TOKEN = "token";

    /**
     * 以自定义切点 @Auth 注解为切点
     */
    @Pointcut("execution (* com.aking.token.controller..*.*(..)) && @annotation(com.aking.token.annotations.Auth)")
    public void auth() {
    }

    /**
     *
     * @param joinPoint
     */
    @Before("auth()")
    public void checkAuth(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = null;
        Auth auth = null;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if(method.isAnnotationPresent(Auth.class)){
            auth = method.getAnnotation(Auth.class);
        }
        try {
            // 获取 token
            token = getToken(request);
        } catch (Exception e) {
            log.error("request get token error:{}", e);
        }
        // 判断 token 是否为空
        if (StrUtil.isEmpty(token)) {
            if (auth.requireLogin()) {
                log.error("token is null");
                throw new NoLoginException();
            }
        } else {
            // 模拟开始： 根据 token 从 Redis 中获取数据
            AuthSessionDTO authSessionDTO = new AuthSessionDTO();
            authSessionDTO.setName("Python大星");
            authSessionDTO.setMobile("18800000001");
            // 模拟结束： 根据 token 从 Redis 中获取数据
            if (authSessionDTO != null) {
                // 将根据token获取的信息放到 ThreadLocal 中
                SessionContext.setCurrentSession(authSessionDTO);
            } else {
                // token 失效，需要重新登录
                log.error("authSessionDTO null");
                if (auth.requireLogin()) {
                    throw new NoLoginException();
                }
            }
        }
    }

    /**
     * 获取 token
     * @param request request
     * @return java.lang.String token
     * @Description 三种方式获取 token
     */
    private String getToken(HttpServletRequest request) throws Exception {
        String value = request.getHeader(AuthAspect.TOKEN);
        // 从 header 中获取 token
        if (StrUtil.isNotBlank(value)) {
            log.info("get token by header :{}", value);
        }
        if (StrUtil.isEmpty(value)) {
            value = CookieUtil.getStringFromCookie(request, AuthAspect.TOKEN, null);
            // 从 cookie 中获取 token
            if (StrUtil.isNotBlank(value)) {
                log.info("get token by cookie :{}", value);
            }
        }
        if (StrUtil.isEmpty(value)) {
            value = request.getParameter(AuthAspect.TOKEN);
            // 从 url 参数中获取token
            if (StrUtil.isNotBlank(value)) {
                log.info("get token by parameter :{}", value);
            }
        }
        return value;
    }
}
