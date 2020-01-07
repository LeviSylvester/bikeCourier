package com.sda.sylvester.bikecourier.service;

import com.sda.sylvester.bikecourier.dao.PersonDao;
import com.sda.sylvester.bikecourier.model.Person;

public class PersonCreateService {

    private PersonDao personDao;

    public void createPersons(int number) {
        personDao = new PersonDao();
        for (int i = 1; i <= number; i++) {
            Person p = new Person();
            p.setFirstName("Client");
            p.setLastName("" + i);
            p.setAddress("City");
            personDao.save(p);
        }
    }

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person();
        person.setFirstName("levi");
        person.setLastName("sz");
        person.setAddress("cj");
        personDao.save(person);
    }

}