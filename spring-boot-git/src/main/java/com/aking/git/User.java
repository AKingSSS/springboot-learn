package com.aking.git;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class User {

    @Excel(name = "员工工号")
    private String id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "评价关系")
    private String relation;

    @Excel(name = "姓名1")
    private String relationName;

    private String superior;
    private String equal;
    private String subordinate;




}
