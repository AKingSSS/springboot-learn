package com.aking.interceptor;

import com.aking.annotations.LoginRequired;
import com.aking.constant.ResponseCode;
import com.aking.constant.SessionConstant;
import com.aking.util.CookieUtil;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName LoginInterceptor
 * @Description
 * @Author yk
 * @Date 2020/5/28 17:00
 * @Version 1.0
 **/
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("当前请求的 url = [{}], 进入拦截器", request.getRequestURL());
        //通过注解判断是否需要登录验证
        if(handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod)handler;
            if(h.getMethod().getDeclaringClass().getDeclaredAnnotation(LoginRequired.class) != null
                    && !h.getMethod().getDeclaredAnnotation(LoginRequired.class).loginRequired()) {
                log.info("=========注解未被拦截===================" + true);
                return true;
            }else if(h.getMethodAnnotation(LoginRequired.class) != null
                    && !h.getMethodAnnotation(LoginRequired.class).loginRequired()){
                log.info("=========注解未被拦截===================" + true);
                return true;
            }
        }
        String sessionId = getValue(request, SessionConstant.SessionToken);
        if (StringUtil.isEmpty(sessionId)) {
            log.info("=========已被拦截===================" + false);
            // 测试跳转链接
            response.sendRedirect("https://item.jd.com/11620454466.html");
            ResponseJsonWrapper.writeResponse(response,
                    ResponseJsonWrapper.newErrorReturnJson(ResponseCode.NO_SESSION, "登录失败(code:1)"));
            return false;
        }
        log.info("=========未被拦截===================" + true);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, @Nullable Exception ex) throws Exception {
    }


    private String getString(HttpServletRequest request, String name, String defaultValue) throws Exception {
        if (StringUtil.isEmpty(name)) {
            return null;
        }
        // 要查询的对象
        String value = request.getParameter(name);
        if (null == value) {
            return defaultValue;
        }
        return value.trim();
    }

    private String getValue(HttpServletRequest request, String name) throws Exception {
        String value = request.getHeader(name);
        if (StringUtil.isEmpty(value)) {
            value = CookieUtil.getStringFromCookie(request, name, null);
        }
        if (StringUtil.isEmpty(value)) {
            value = getString(request, name, null);
        }
        return value;
    }
}
