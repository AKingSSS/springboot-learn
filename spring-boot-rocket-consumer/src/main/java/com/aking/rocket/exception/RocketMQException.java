package com.aking.rocket.exception;

/**
 * @ClassName RocketMQException
 * @Description
 * @Author yk
 * @Date 2020/7/10 11:28
 * @Version 1.0
 **/
public class RocketMQException extends Throwable {
    public RocketMQException() {
        super();
    }

    public RocketMQException(String message) {
        super(message);
    }
}
