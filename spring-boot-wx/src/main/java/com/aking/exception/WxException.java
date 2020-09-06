package com.aking.exception;

/**
 * @ClassName WxException
 * @Description
 * @Author yk
 * @Date 2020/5/22 18:28
 * @Version 1.0
 **/
public class WxException extends RuntimeException {
    public WxException(String message) {
        super(message, (Throwable) null);
    }

    private String showText;

    public WxException setShowText(String showText) {
        this.showText = showText;
        return this;
    }
}
