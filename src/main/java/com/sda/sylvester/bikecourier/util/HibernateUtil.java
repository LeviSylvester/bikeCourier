package com.sda.sylvester.bikecourier.util;

import java.util.Properties;

import com.sda.sylvester.bikecourier.model.Delivery;
import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.model.Packet;
import com.sda.sylvester.bikecourier.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bikecourier?serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "admin");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Delivery.class);
                configuration.addAnnotatedClass(Packet.class);
                configuration.addAnnotatedClass(Order.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}