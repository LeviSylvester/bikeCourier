package com.sda.sylvester.bikecourier.service;

import com.sda.sylvester.bikecourier.dao.OrderDao;
import com.sda.sylvester.bikecourier.model.Order;

public class OrderCreateService {

    private OrderDao orderDao = new OrderDao();

    public void createOrder(Order order){
        orderDao.save(order);
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.setFrom("Sechel");
        order.setTo("Calin");
        order.setTerm("2h");
        OrderDao orderDao = new OrderDao();
        orderDao.save(order);
    }
}
