package com.aking.design.p16observe;

import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @ClassName OrderCreateEvent
 * @Description
 * @Author yk
 * @Date 2020/8/31 17:49
 * @Version 1.0
 **/
public class OrderCreateEvent extends ApplicationEvent {
    private String name;

    /**
     * 消息参数
     */
    private List<String> contentList;

    public OrderCreateEvent(Object source, String name, List<String> contentList) {
        super(source);
        this.name = name;
        this.contentList = contentList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getContentList() {
        return contentList;
    }
    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
    }
}
