package com.sda.sylvester.bikecourier.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDelivery;
    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Person person;
    @OneToMany(mappedBy = "delivery")
    private List<Packet> packets = new ArrayList<>();

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Packet> getPackets() {
        return packets;
    }

    public void setPackets(List<Packet> packets) {
        this.packets = packets;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "idDelivery=" + idDelivery +
                ", person=" + person +
                ", packets=" + packets +
                '}';
    }
}