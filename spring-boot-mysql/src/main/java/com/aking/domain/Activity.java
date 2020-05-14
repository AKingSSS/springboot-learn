package com.aking.domain;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Activity
 * @Description
 * @Author yk
 * @Date 2020/5/8 19:39
 * @Version 1.0
 **/
@Data
public class Activity extends AbstractDataDomain {
    /**
     * 活动标题（少于30字）
     *  final 修饰不会生成 setter 方法
     */
    private String title;
    /**
     * 热门标识
     * 0：非热门；1：热门
     */
    private Integer hot;
    /**
     * 主图地址
     */
    private String mainPicUrl;
    /**
     * 活动开始时间
     */
    private Date startTime;
    /**
     * 活动结束时间
     */
    private Date endTime;
    /**
     * 主持人
     */
    private String host;
    /**
     * 活动关联品牌
     */
    private String brands;
    /**
     * 长图地址
     */
    private String longPicUrl;
    /**
     * 发布状态
     */
    private Integer publishStatus;
    /**
     * 活动备注
     */
    private String remark;
    /**
     * 活动说明
     */
    private String instruction;

}
