package com.aking.domain;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName AbstractDataDomain
 * @Description
 * @Author yk
 * @Date 2020/5/9 9:51
 * @Version 1.0
 **/
@Data
public abstract class AbstractDataDomain {
    private Long id;
    private Long creatorId;
    private Long lastModifierId;
    private Date createTime;
    private Date modifiedTime;
    private Long deleted;
}
