package com.aking.unit.pojo;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Employee
 * @Description
 * @Author yk
 * @Date 2020/6/4 13:49
 * @Version 1.0
 **/
@Slf4j
public class Employee {

    private int mType;
    static final int SALARY = 5000;
    static final int COMMISSION = 3000;
    static final int BONUS = 10000;

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    public Employee(int type) {
        this.mType = type;
    }

    int payAmount() {
        switch (mType) {
            case ENGINEER:
                return SALARY;
            case SALESMAN:
                return SALARY + COMMISSION;
            case MANAGER:
                return SALARY + BONUS;
            default:
                throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        Employee engineer = new Employee(Employee.ENGINEER);
        log.info("engineer工资为: [{}] RMB", engineer.payAmount());
        Employee manager = new Employee(Employee.MANAGER);
        log.info("manager工资为: [{}] RMB", manager.payAmount());
        Employee salesman = new Employee(Employee.SALESMAN);
        log.info("salesman工资为: [{}] RMB", salesman.payAmount());
    }
}
