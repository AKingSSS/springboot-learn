package com.aking.swagger.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description
 * @Author yk
 * @Date 2020/6/9 16:03
 * @Version 1.0
 **/
@Data
@ApiModel
public class User implements Serializable    {
    private static final long serialVersionUID = 8850856799144781989L;
    private String name;
    private Integer age;
}
