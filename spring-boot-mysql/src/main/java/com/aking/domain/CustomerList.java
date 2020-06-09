package com.aking.domain;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName CustomerList
 * @Description
 * @Author yk
 * @Date 2020/5/14 16:41
 * @Version 1.0
 **/
@Data
public class CustomerList {
    private List<Customer> customers;

    public static void main(String[] args) {
        double d = 9.41;
        for (int i = 0; i < 4; i++) {
            d = d * 1.1;
            System.out.println(String.format("d%s = %.2f", i + 1, d));
        }
    }
}
