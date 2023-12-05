package org.lanqiao.service;

import org.lanqiao.pojo.Orders;

import java.util.List;

public interface OrdersService {
    int findAllCount(String username);

    List<Orders> findAll(String username, int startNum);
}
