package com.sda.sylvester.bikecourier.dao;

import com.sda.sylvester.bikecourier.model.Delivery;
import com.sda.sylvester.bikecourier.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DeliveryDao {

    public Delivery get(int idDelivery) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Delivery d = session.get(Delivery.class, idDelivery);
        session.close();

        return d;
    }

    public Delivery save(Delivery delivery) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(delivery);
        transaction.commit();
        session.close();

        return delivery;
    }

    public Delivery delete(Delivery delivery) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(delivery);
        transaction.commit();
        session.close();

        return delivery;
    }

    public void deleteAllDeliveries() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Delivery");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}