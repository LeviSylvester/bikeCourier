package com.sda.sylvester.bikecourier.dao;

import com.sda.sylvester.bikecourier.model.Packet;
import com.sda.sylvester.bikecourier.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PacketDao {

    public Packet get(int idPackage) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Packet p = session.get(Packet.class, idPackage);
        session.close();

        return p;
    }

    public Packet save(Packet packetObject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(packetObject);
        transaction.commit();
        session.close();

        return packetObject;
    }

    public Packet delete(Packet packetObject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(packetObject);
        transaction.commit();
        session.close();

        return packetObject;
    }

}