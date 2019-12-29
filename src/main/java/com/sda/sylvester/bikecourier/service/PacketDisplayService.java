package com.sda.sylvester.bikecourier.service;

import com.sda.sylvester.bikecourier.dao.PersonDao;
import com.sda.sylvester.bikecourier.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PacketDisplayService {

    private PersonDao personDao = new PersonDao();

    public Person getPerson(int idPerson) {
        return personDao.get(idPerson);
    }

    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    public List<Person> getPersonsFromCity(String city) {
        List<Person> personFromCity = new ArrayList<>();
        for (Person person : personDao.getAllPersons()) {
            if (person.getAddress().equals("City")) {
                personFromCity.add(person);
            }
        }
        return personFromCity;
    }

    public double getAverageAgeForPersons() {
        int sumAges = 0;
        List<Person> allPersons = getAllPersons();
        for (Person person : allPersons) {
            sumAges += person.getAge();
        }

        return sumAges / allPersons.size();
    }

}