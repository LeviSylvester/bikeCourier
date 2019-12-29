package com.sda.sylvester.bikecourier.model;

import javax.persistence.*;

@Entity
public class Packet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPackage;
    private String sizeXYZ;
    private double weightKg;
    @ManyToOne
    @JoinColumn(name = "idDelivery")
    private Delivery delivery;

    public int getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(int idPackage) {
        this.idPackage = idPackage;
    }

    public String getSizeXYZ() {
        return sizeXYZ;
    }

    public void setSizeXYZ(String sizeXYZ) {
        this.sizeXYZ = sizeXYZ;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "idPackage=" + idPackage +
                ", sizeXYZ='" + sizeXYZ + '\'' +
                ", weightKg=" + weightKg +
                ", delivery=" + delivery +
                '}';
    }

}