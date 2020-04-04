package com.aking.token.annotations;

import java.lang.annotation.*;

/**
 * Title: C端登陆注解
 * @Documented：注解信息会被添加到 Java 文档中
 * @Retention：注解的生命周期，表示注解会被保留到什么阶段，可以选择编译阶段、类加载阶段，或运行阶段
 * @Target：注解作用的位置，ElementType.METHOD 表示该注解仅能作用于方法上
 * type：Class, interface (including annotation type), or enum declaration
 * @author Y10003453
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CAuth {
    /**
     * 是否必须登录 默认是
     */
    boolean requireLogin() default true;
}
