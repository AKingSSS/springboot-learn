package com.aking.manager;

import com.aking.domain.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName ActivityDao.xml
 * @Description
 * @Author yk
 * @Date 2020/5/8 19:43
 * @Version 1.0
 **/
@Mapper
public interface ActivityDao {
    /**
     * 查询用户列表
     * @return
     */
    List<Activity> findActivityList();
}
