package com.aking.token.enums;

/**
 * @ClassName ResponseEnums
 * @Description
 * @Author yangkang
 * @Date 2020/5/19 14:44
 * @Version 1.0
 **/
public enum ResponseEnums {
    SUCCESS(200, "OK"),
    ERROR(400, "Bad Request"),
    NO_LOGIN(410, "未登录"),
    UNKNOWN(500, "Internal Server Error");

    public Integer code;
    public String desc;

    private ResponseEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
