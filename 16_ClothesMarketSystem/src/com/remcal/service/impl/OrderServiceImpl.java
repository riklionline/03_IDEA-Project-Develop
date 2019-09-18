package com.remcal.service.impl;

import com.remcal.bean.Order;
import com.remcal.service.OrderService;
import com.remcal.utils.BusinessException;
import com.remcal.utils.OrderIO;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderIO orderIO = new OrderIO();

    @Override
    public void buyProduct(Order o) throws BusinessException {
        orderIO.add(o);
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIO.findByOrderId(orderId);
    }
}
