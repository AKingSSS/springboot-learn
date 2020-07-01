package com.aking.shiro.service.impl;

import com.aking.shiro.pojo.Permissions;
import com.aking.shiro.pojo.Role;
import com.aking.shiro.pojo.User;
import com.aking.shiro.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LoginServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/7/1 15:15
 * @Version 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {
    /**
     * 根据姓名获取用户信息
     *
     * @param getMapByName
     * @return
     */
    @Override
    public User getUserByName(String getMapByName) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getMapByName(getMapByName);
    }

    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
    private User getMapByName(String userName){

        Permissions permissions1 = new Permissions("1","query");
        Permissions permissions2 = new Permissions("2","add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);

        //Python大星 有query和add权限
        Role role = new Role("1","admin",permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User("1","Python大星","123456",roleSet);
        Map<String ,User> map = new HashMap<>(16);
        map.put(user.getUserName(), user);

        Permissions permissions3 = new Permissions("3","query");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);

        //Python大星 有query和add权限，Python小星 只有一个query权限
        Role role1 = new Role("2","user",permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User("2","Python小星","123456",roleSet1);
        map.put(user1.getUserName(), user1);
        return map.get(userName);
    }
}
