package com.aking.annotations;

import java.lang.annotation.*;

/**
 * @author yk
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Auth {
    /**
     * 是否必须登录，默认是
     */
    boolean requireLogin() default true;
}
