package com.remcal.service;

import com.remcal.bean.Order;
import com.remcal.utils.BusinessException;

import java.util.List;

public interface OrderService {

    public void buyProduct(Order o)throws BusinessException;
    public List<Order> list()throws BusinessException;
    public Order findById(int orderId)throws BusinessException;
}
