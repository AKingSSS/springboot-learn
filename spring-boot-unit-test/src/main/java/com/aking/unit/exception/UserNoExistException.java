package com.aking.unit.exception;

/**
 * @ClassName UserNoExistException
 * @Description
 * @Author yk
 * @Date 2020/6/3 10:26
 * @Version 1.0
 **/
public class UserNoExistException extends RuntimeException {
    /**
     * 无参构造函数
     */
    public UserNoExistException(){
        super();
    }

    /**
     * 用详细信息指定一个异常
     * @param message
     */
    public UserNoExistException(String message){
        super(message);
    }

    /**
     * 用指定的详细信息和原因构造一个新的异常
     * @param message
     * @param cause
     */
    public UserNoExistException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * 用指定原因构造一个新的异常
     * @param cause
     */
    public UserNoExistException(Throwable cause) {
        super(cause);
    }
}
