package com.sda.sylvester.bikecourier;

import com.sda.sylvester.bikecourier.dao.DeliveryDao;
import com.sda.sylvester.bikecourier.dao.PersonDao;
import com.sda.sylvester.bikecourier.service.DeliveryCreateService;
import com.sda.sylvester.bikecourier.service.PersonCreateService;
import com.sda.sylvester.bikecourier.view.BikeCourierTableView;

public class TableViewApp extends BikeCourierTableView {

    public static void main(String[] args) {
        clearData();
        initializeData();

        BikeCourierTableView.launch();
    }

    private static void initializeData() {
        PersonCreateService personCreateService = new PersonCreateService();
        personCreateService.createPersons(20);
        DeliveryCreateService deliveryCreateService = new DeliveryCreateService();
        deliveryCreateService.createDeliveries(20);
    }

    private static void clearData() {
        PersonDao personDao = new PersonDao();
        personDao.deleteAllPersons();
        DeliveryDao deliveryDao = new DeliveryDao();
        deliveryDao.deleteAllDeliveries();
    }

}