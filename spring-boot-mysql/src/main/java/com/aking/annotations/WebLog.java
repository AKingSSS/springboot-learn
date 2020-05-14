package com.aking.annotations;

import java.lang.annotation.*;

/**
 * @author yk
        * @Retention 什么时候使用该注解，我们定义为运行时
        * @Target 注解用于什么地方，我们定义为作用于方法上；
        * @Documented 注解是否将包含在 JavaDoc 中
        */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface WebLog {
    /**
     * 是否必须打印返回参数，默认是
     */
    boolean resultRequired() default true;

    /**
     * 描述
     */
    String description() default "";
}
