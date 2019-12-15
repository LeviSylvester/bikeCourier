package com.sda.sylvester.bikecourier;

import com.sda.sylvester.bikecourier.dao.PersonDao;
import com.sda.sylvester.bikecourier.service.PersonCreateService;

public class Application {

    public static void main(String[] args) {
        initializeData();

        PersonDao personDao = new PersonDao();
        personDao.getPersonsFromCity("City", "Client");

        clearData();
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