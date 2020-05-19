package com.aking.token.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CAuthSessionDto
 * @Description
 * @Author yangkang
 * @Date 2020/4/4 22:02
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthSessionDTO implements Serializable {
    private static final long serialVersionUID = -4415234688476992412L;

    private String token;

    private Long userId;

    private String name;

    private String mobile;
}
