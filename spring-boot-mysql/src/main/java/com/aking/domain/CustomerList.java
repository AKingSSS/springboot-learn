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
    @Valid
    private List<Customer> customers;
}
