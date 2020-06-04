package com.aking.unit.pojo;

/**
 * @ClassName Salesman
 * @Description
 * @Author yk
 * @Date 2020/6/4 14:08
 * @Version 1.0
 **/
public class Salesman extends EmployeeType {
    @Override
    int payAmount() {
        return Employee.SALARY + Employee.COMMISSION;
    }
}
