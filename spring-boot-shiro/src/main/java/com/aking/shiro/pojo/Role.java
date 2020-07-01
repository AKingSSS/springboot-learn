package com.aking.shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @ClassName Role
 * @Description
 * @Author yk
 * @Date 2020/7/1 15:13
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;
}
