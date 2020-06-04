package com.aking.unit.pojo;

/**
 * @ClassName Engineer
 * @Description
 * @Author yk
 * @Date 2020/6/4 14:12
 * @Version 1.0
 **/
public class Engineer extends EmployeeType {
    @Override
    int payAmount() {
        return Employee.SALARY;
    }
}
