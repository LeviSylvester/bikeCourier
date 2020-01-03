package com.sda.sylvester.bikecourier.service;

import com.sda.sylvester.bikecourier.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Dispatch {

    public static final ObservableList<Order> ordersObservableList =
            FXCollections.observableArrayList(
                    new Order("Sechel", "Dansorean", "2h"),
                    new Order("Calin", "Sechel", "1h"),
                    new Order("PremiereM", "Daisler", "2h"),
                    new Order("Dentline", "Faragau", "2,5h"),
                    new Order("Toni", "Titulescu6", "1h"));

}