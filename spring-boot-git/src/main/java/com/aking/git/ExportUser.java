package com.aking.git;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class ExportUser {

    @Excel(name = "员工工号")
    private String id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "上级")
    private String superior;
    @Excel(name = "平级")
    private String equal;
    @Excel(name = "下级")
    private String subordinate;




}
