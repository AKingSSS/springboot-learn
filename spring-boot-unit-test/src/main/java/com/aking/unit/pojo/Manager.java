package com.aking.unit.pojo;

/**
 * @ClassName Manager
 * @Description
 * @Author yk
 * @Date 2020/6/4 14:08
 * @Version 1.0
 **/
public class Manager extends EmployeeType {
    @Override
    int payAmount() {
        return Employee.SALARY + Employee.BONUS;
    }
}
