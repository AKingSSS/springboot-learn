package com.aking.token.exception;

/**
 * @ClassName NotLoginException
 * @Description 自定义异常
 * @Author yangkang
 * @Date 2020/4/4 21:22
 * @Version 1.0
 **/
public class NoLoginException extends RuntimeException {
    public NoLoginException(String message) {
        //这句话的意思是调用Exception的有参构造方法
        super(message);
    }

    public static void main(String[] args) {
        try {
            throw new NoLoginException("未登录");
        } catch (NoLoginException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
