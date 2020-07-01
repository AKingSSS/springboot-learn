package com.aking.shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @ClassName User
 * @Description
 * @Author yk
 * @Date 2020/7/1 15:12
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String userName;
    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
}
