package com.sda.sylvester.bikecourier;

import com.sda.sylvester.bikecourier.dao.PersonDao;
import com.sda.sylvester.bikecourier.model.Person;
import com.sda.sylvester.bikecourier.service.PersonCreateService;
import com.sda.sylvester.bikecourier.view.BikeCourierMainView;

import java.awt.*;
import java.util.List;

public class Application extends BikeCourierMainView {

    public static void main(String[] args) {
//        clearData();
//        initializeData();

        BikeCourierMainView.launch();
    }

    private static void initializeData() {
        PersonCreateService personCreateService = new PersonCreateService();
        personCreateService.createPersons(20);
    }

    private static void clearData() {
        PersonDao personDao = new PersonDao();
        personDao.deleteAllPersons();
    }

}