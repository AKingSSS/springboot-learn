package com.aking.interceptor;

import com.aking.constant.ResponseCode;
import com.aking.constant.SessionConstant;
import com.aking.util.CookieUtil;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description
 * @Author yk
 * @Date 2020/5/28 17:00
 * @Version 1.0
 **/
@Component
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String sessionId = getValue(request, SessionConstant.SessionToken);
        if (StringUtil.isEmpty(sessionId)) {
            ResponseJsonWrapper.writeResponse(response,
                    ResponseJsonWrapper.newErrorReturnJson(ResponseCode.NO_SESSION, "登录失败(code:1)"));
            return false;
        }

        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, @Nullable Exception ex) throws Exception {
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request,
                                               HttpServletResponse response, Object handler) throws Exception {
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
