package com.aking.token.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ResultSupport
 * @Description
 * @Author yk
 * @Date 2020/5/19 15:21
 * @Version 1.0
 **/
@Data
public class ResultSupport implements Serializable {

    private static final long serialVersionUID = -1715706726791697527L;

    private String message;
    private int code;
}
