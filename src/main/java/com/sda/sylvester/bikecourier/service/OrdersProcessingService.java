package com.sda.sylvester.bikecourier.service;

import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.view.CourierView;

import java.util.ArrayList;
import java.util.List;

public class OrdersProcessingService {

    public static List<Order> orders = new ArrayList<>();

    public static void refreshCourierOrderList(){
        CourierView.ordersTableView.refresh();
    }

}