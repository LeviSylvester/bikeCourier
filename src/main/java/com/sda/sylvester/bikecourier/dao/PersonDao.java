package com.sda.sylvester.bikecourier.dao;

import com.sda.sylvester.bikecourier.model.Person;
import com.sda.sylvester.bikecourier.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDao {

    public Person get(int idPerson) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Person p = session.get(Person.class, idPerson);
        session.close();

        return p;
    }

    public Person save(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(person);
        transaction.commit();
        session.close();

        return person;
    }

    public Person delete(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(person);
        transaction.commit();
        session.close();

        return person;
    }

    public List<Person> getAllPersons(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Person"); //"where type == TypeEnum.SENDER" if sender
        List<Person> personList = query.list();

        session.close();
        return personList;
    }

    public void deleteAllPersons(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Person"); //"where type == TypeEnum.SENDER" if sender
        query.executeUpdate();
        transaction.commit();

        session.close();
    }

    public List<Person> getPersonsFromCity(String city, String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<Person> query = session.createQuery("from Person where address = ?1 and firstName = ?2");
        query.setParameter(1, city);
        query.setParameter(2, name);
        transaction.commit();

        return query.list();
    }
}
