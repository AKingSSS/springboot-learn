package com.aking.pojo;

import lombok.Data;

import java.util.Map;

/**
 * @ClassName Template
 * @Description 微信推送模板类
 * @Author yk
 * @Date 2020/5/22 18:26
 * @Version 1.0
 **/
@Data
public class Template {
    private String touser;
    private String template_id;
    private String url;
    private Map<String,Object> data;
}
