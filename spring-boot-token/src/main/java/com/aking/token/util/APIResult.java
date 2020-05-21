package com.aking.token.util;

import com.aking.token.enums.ResponseEnums;
import lombok.Data;

/**
 * @ClassName APIResult
 * @Description
 * @Author yk
 * @Date 2020/5/19 15:32
 * @Version 1.0
 **/
@Data
public class APIResult<T> extends ResultSupport {
    private T data;
    /**
     * 接口调用失败,有错误字符串码和描述,有返回对象
     * @param code
     * @param message
     * @param data
     * @param <U>
     * @return
     */
    public static <U> APIResult<U> newFailResult(int code, String message, U data) {
        APIResult<U> apiResult = new APIResult<U>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }

    /**
     * 接口调用失败,有错误字符串码和描述,没有返回对象
     * @param code
     * @param message
     * @param <U>
     * @return
     */
    public static <U> APIResult<U> newFailResult(int code, String message) {
        APIResult<U> apiResult = new APIResult<U>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }

    public static <U> APIResult<U> newSuccessResult(U data){
        APIResult<U> apiResult = new APIResult<U>();
        apiResult.setData(data);
        apiResult.setCode(ResponseEnums.SUCCESS.code);
        apiResult.setMessage(ResponseEnums.SUCCESS.desc);
        return apiResult;
    }

    public static <U> APIResult<U> badRequest(){
        APIResult<U> apiResult = new APIResult<U>();
        apiResult.setCode(ResponseEnums.UNKNOWN.code);
        apiResult.setMessage(ResponseEnums.UNKNOWN.desc);
        return apiResult;
    }
}
