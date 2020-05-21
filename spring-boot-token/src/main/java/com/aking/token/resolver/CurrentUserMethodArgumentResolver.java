package com.aking.token.resolver;

import com.aking.token.annotations.CurrentUser;
import com.aking.token.dto.AuthSessionDTO;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @ClassName CurrentUserMethodArgumentResolver
 * @Description
 * @Author yk
 * @Date 2020/5/19 18:46
 * @Version 1.0
 **/
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        CurrentUser currentUserAnnotation = parameter.getParameterAnnotation(CurrentUser.class);
        //从Session 获取用户
        Object object = webRequest.getAttribute(currentUserAnnotation.value(), NativeWebRequest.SCOPE_SESSION);
        //从  accessToken获得用户信息
        if (object == null) {
            String token = webRequest.getHeader("token");
            if (token == null) {
                token = webRequest.getParameter("token");
            }
            //为了测试先写死用户名
            //TODO: 取真实用户
            return new AuthSessionDTO("e0915116432bf81c542bde0df2b4d323",
                    1L,"Python大星","18000000001");
        }
        return object;
    }
}
