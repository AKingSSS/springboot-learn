package com.aking.token.aspect;

import cn.hutool.core.util.StrUtil;
import com.aking.token.dto.CAuthSessionDTO;
import com.aking.token.annotations.CAuth;
import com.aking.token.context.SessionContext;
import com.aking.token.exception.NoLoginException;
import com.aking.token.util.CookieUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Title: CAuth 注解切面
 *
 * @author Y10003453
 */
@Aspect
@Component
public class CAuthAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private final static String NULL = "null";
    /**
     * header 中 token 的名称
     */
    private final static String TOKEN = "token";

    /**
     * 校验登录的注解的 aspect 类上的注解实现
     * execution 定义切入点表达式
     * @param cAuth 注解
     */
    @Before("execution (* com.aking.token.controller..*.*(..)) && @within(cAuth)")
    public void checkBAuthOnClass(JoinPoint joinPoint, CAuth cAuth) {
        checkCAuth(joinPoint,cAuth);
    }

    /**
     * 校验登录的注解的aspect 方法上的注解实现
     *
     * @param cAuth 注解
     */
    @Before("execution (* com.aking.token.controller..*.*(..)) && @annotation(cAuth)")
    public void checkBAuthOnMethod(JoinPoint joinPoint,CAuth cAuth) {
        checkCAuth(joinPoint,cAuth);
    }

    private void checkCAuth(JoinPoint joinPoint, CAuth cAuth) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if(method.isAnnotationPresent(CAuth.class)){
            cAuth = method.getAnnotation(CAuth.class);
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = null;
        try {
            // 获取 token
            token = getToken(request);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("request get token error:{}",e);
        }
        if (StrUtil.isEmpty(token) || NULL.equals(token)) {
            if(cAuth.requireLogin()){
                logger.error("token is null");
                throw new NoLoginException("未登录");
            }
        } else {
            // 模拟开始： 根据 token 从 Redis 中获取数据
            CAuthSessionDTO cAuthSessionDTO = new CAuthSessionDTO();
            cAuthSessionDTO.setName("Python大星");
            cAuthSessionDTO.setMobile("18800000001");
            // 模拟结束： 根据 token 从 Redis 中获取数据
            if (cAuthSessionDTO != null) {
                SessionContext.setCurrentSession(cAuthSessionDTO);
            } else {
                logger.error("cAuthSessionDTO null");
                if(cAuth.requireLogin()) {
                    throw new NoLoginException("未登录");
                }
            }
        }
    }

    /**
     * @Description 三种方式获取 token
     * @param request	request
     * @return java.lang.String token
     */
    private String getToken(HttpServletRequest request) throws Exception {
        String value = request.getHeader(CAuthAspect.TOKEN);
        if(StrUtil.isNotBlank(value)){
            logger.info("get token by header :{}",value);
        }
        if (StrUtil.isEmpty(value)) {
            value = CookieUtil.getStringFromCookie(request, CAuthAspect.TOKEN, null);
            if(StrUtil.isNotBlank(value)){
                logger.info("get token by cookie :{}",value);
            }
        }
        if (StrUtil.isEmpty(value)) {
            value = request.getParameter(CAuthAspect.TOKEN);
            if(StrUtil.isNotBlank(value)){
                logger.info("get token by parameter :{}",value);
            }
        }
        return value;
    }
}
