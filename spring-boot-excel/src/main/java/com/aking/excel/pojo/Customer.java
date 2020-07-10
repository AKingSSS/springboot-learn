package com.aking.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Customer
 * @Description
 * @Author yk
 * @Date 2020/7/8 15:20
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ColumnWidth(25)
public class Customer {
    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ExcelProperty(value = "手机号", index = 1)
    private String mobile;
}
