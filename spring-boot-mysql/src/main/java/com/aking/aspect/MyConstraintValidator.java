package com.aking.aspect;

import com.aking.annotations.MyValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName MyConstraintValidator
 * @Description 需要实现ConstraintValidator<A extends Annotation, T>
 * A extends Annotation:需要设置为自定义注解类型
 * T:需要校验数据的类型
 * @Author yk
 * @Date 2020/5/14 17:15
 * @Version 1.0
 **/
public class MyConstraintValidator implements ConstraintValidator<MyValid, Object> {
    private int min;

    /**
     * 初始化验证器，可以初始化验证注解
     *
     * @param constraintAnnotation 验证注解的实例
     */
    @Override
    public void initialize(MyValid constraintAnnotation) {
        this.min = constraintAnnotation.min();
    }

    /**
     * 实现验证逻辑，判断长度是否大于min()中定义的长度
     *
     * @param o                          需要验证的对象
     * @param constraintValidatorContext 约束验证器的上下文
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o.toString().length() >= min) {
            return true;
        }
        return false;
    }
}
