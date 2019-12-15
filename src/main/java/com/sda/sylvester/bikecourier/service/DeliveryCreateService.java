package com.sda.sylvester.bikecourier.service;

import com.sda.sylvester.bikecourier.dao.DeliveryDao;
import com.sda.sylvester.bikecourier.dao.PersonDao;
import com.sda.sylvester.bikecourier.model.Delivery;
import com.sda.sylvester.bikecourier.model.Person;

public class DeliveryCreateService {
    private DeliveryDao deliveryDao;

    public void createDeliveries(int number) {
        deliveryDao = new DeliveryDao();
        for (int i = 1; i <= number; i++) {
//            Delivery d = new Delivery();
//            d.setFirstName("Client");
//            d.setLastName("" + i);
//            d.setAddress("City");
//            deliveryDao.save(p);
        }
    }
}
