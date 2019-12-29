package com.sda.sylvester.bikecourier.service;

import com.sda.sylvester.bikecourier.dao.DeliveryDao;
import com.sda.sylvester.bikecourier.model.Delivery;
import com.sda.sylvester.bikecourier.model.Packet;
import com.sda.sylvester.bikecourier.model.Person;
import com.sda.sylvester.bikecourier.model.TypeEnum;

import java.util.ArrayList;
import java.util.List;

public class PacketCreateService {

    private DeliveryDao deliveryDao;

    public void createDeliveries(int number) {
        deliveryDao = new DeliveryDao();
        for (int i = 1; i <= number; i++) {
            Delivery d = new Delivery();
            Person person = new Person(TypeEnum.RECEIVER, "City", "Client", String.valueOf(i));
            d.setPerson(person);
            Packet packet = new Packet();
            List<Packet> packets = new ArrayList<>();
            packets.add(packet);
            d.setPackets(packets);
            deliveryDao.save(d);
        }
    }

}