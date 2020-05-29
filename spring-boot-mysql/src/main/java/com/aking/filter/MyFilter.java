package com.aking.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description
 * @Author yk
 * @Date 2020/5/29 15:08
 * @Version 1.0
 **/
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器：[{}]", filterConfig.getFilterName());

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.info("start to doFilter");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        log.info("the request of [{}] consumes [{}] ms", getUrlFrom(servletRequest), (end - start));
        log.info("end to doFilter");
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }

    private String getUrlFrom(ServletRequest servletRequest) {
        if (servletRequest instanceof HttpServletRequest) {
            return ((HttpServletRequest) servletRequest).getRequestURI().toString();
        }
        return "";
    }

}
