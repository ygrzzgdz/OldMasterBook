package org.lanqiao.service.impl;

import org.lanqiao.dao.OrdersDao;
import org.lanqiao.dao.impl.OrdersDaoImpl;
import org.lanqiao.pojo.Orders;
import org.lanqiao.service.OrdersService;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {


    @Override
    public int findAllCount(String username) {
        OrdersDao ordersDao = new OrdersDaoImpl();
        return ordersDao.findAllCount(username);
    }
}
