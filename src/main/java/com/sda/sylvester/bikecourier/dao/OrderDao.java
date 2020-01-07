package com.sda.sylvester.bikecourier.dao;

import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDao {

    public Order get(int idOrder) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Order o = session.get(Order.class, idOrder);
        session.close();

        return o;
    }

    public Order save(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(order);
        transaction.commit();
        session.close();

        return order;
    }

    public Order delete(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(order);
        transaction.commit();
        session.close();

        return order;
    }

    public List<Order> getAllOrders(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Order"); //"where status == Status.AWAITING_RESPONSE" if orders to be taken
        List<Order> orderList = query.list();

        session.close();
        return orderList;
    }

    public void deleteAllOrders(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Order"); //"where status == Status.AWAITING_RESPONSE" if orders to be taken
        query.executeUpdate();
        transaction.commit();

        session.close();
    }

}