package com.sda.sylvester.bikecourier.service;

import com.sda.sylvester.bikecourier.dao.OrderDao;
import com.sda.sylvester.bikecourier.model.Order;

import java.util.List;

public class OrderDisplayService {

    private OrderDao orderDao = new OrderDao();

    public Order getOrder(int idOrder) {
        return orderDao.get(idOrder);
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

}