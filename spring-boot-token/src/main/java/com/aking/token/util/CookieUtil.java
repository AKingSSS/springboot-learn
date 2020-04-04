package com.aking.token.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CookieUtil
 * @Description
 * @Author yangkang
 * @Date 2020/4/4 21:15
 * @Version 1.0
 **/
public class CookieUtil {
    public CookieUtil() {
    }

    public static Cookie newCookie(String name, String value, String domain) throws Exception {
        return newCookie(name, value, domain, (Integer) null);
    }

    public static Cookie newCookie(String name, String value, String domain, Integer maxAge) throws Exception {
        return newCookie(name, value, domain, maxAge, (String) null);
    }

    public static Cookie newCookie(String name, String value, String domain, Integer maxAge, String path) throws Exception {
        Cookie cookie = new Cookie(name, value);
        if (!StrUtil.isEmpty(domain)) {
            cookie.setDomain(domain);
        }

        if (null != maxAge) {
            cookie.setMaxAge(maxAge);
        }

        if (!StrUtil.isEmpty(path)) {
            cookie.setPath(path);
        }

        return cookie;
    }

    public static String getStringFromCookie(HttpServletRequest request, String name, String defaultValue) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0 && !StrUtil.isEmpty(name)) {
            Cookie[] var4 = cookies;
            int var5 = cookies.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                Cookie cookie = var4[var6];
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
            return null;
        } else {
            return null;
        }
    }
}
