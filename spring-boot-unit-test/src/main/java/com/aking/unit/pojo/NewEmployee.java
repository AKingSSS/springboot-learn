package com.aking.unit.pojo;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName NewEmployee
 * @Description
 * @Author yk
 * @Date 2020/6/4 14:07
 * @Version 1.0
 **/
@Slf4j
public class NewEmployee {
    static final int salary = 5000;
    static final int commission = 3000;
    static final int bonus = 10000;

    EmployeeType mEmployeeType;

    public void setType(EmployeeType employeeType) {
        this.mEmployeeType = employeeType;
    }

    int payAmount() {
        return mEmployeeType.payAmount();
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        Salesman salesman = new Salesman();
        Engineer engineer = new Engineer();

        NewEmployee employee = new NewEmployee();

        employee.setType(manager);
        log.info("manager工资为: [{}] RMB" , employee.payAmount());

        employee.setType(salesman);
        log.info("salesman工资为: [{}] RMB" , employee.payAmount());

        employee.setType(engineer);
        log.info("engineer工资为: [{}] RMB" , employee.payAmount());
    }
}
