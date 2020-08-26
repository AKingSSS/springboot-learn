package com.aking.rocket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Order
 * @Description
 * @Author yk
 * @Date 2020/8/25 10:09
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    /**
     * 订单号
     */
    private Integer id;
    /**
     * 订单状态
     */
    private String statusDesc;

    public static List<Order> buildOders() {
        List<Order> orderList = new ArrayList<>();
        Order order = new Order(1001,"创建");
        orderList.add(order);
        order = new Order(1002,"创建");
        orderList.add(order);
        order = new Order(1001,"付款");
        orderList.add(order);
        order = new Order(1002,"付款");
        orderList.add(order);
        order = new Order(1001,"推送");
        orderList.add(order);
        order = new Order(1001,"完成");
        orderList.add(order);
        return orderList;
    }

}
