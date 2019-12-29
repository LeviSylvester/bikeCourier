package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.service.OrdersProcessingService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ClientView extends Application {


    @Override
    public void init() throws Exception {
        System.out.println("Starting BikeCourier Client...");
    }

    @Override
    public void start(Stage clientStage) throws Exception {
        clientStage.setTitle("BikeCourier");
        clientStage.setHeight(640);
        clientStage.setWidth(360);
        clientStage.setX(215);
        clientStage.setY(64);

        Label fromAddressLabel = new Label("From address: ");
        Label toAddressLabel = new Label("To address: ");

        Text welcomeTitle = new Text("Order a courier");
        welcomeTitle.setFont(Font.font("Veranda", 30));
        welcomeTitle.setFill(Paint.valueOf("#2455d1"));

        TextField fromAddressTextField = new TextField();
        TextField toAddressTextField = new TextField();

        Button orderButton = new Button("Place order");
        orderButton.setOnMouseClicked(event -> {
            Order order = new Order();
            order.setFrom(fromAddressTextField.getText());
            order.setTo(toAddressTextField.getText());
            fromAddressTextField.clear();
            toAddressTextField.clear();
            OrdersProcessingService.orders.add(order);
            OrdersProcessingService.refreshCourierOrderList();
        });

        HBox fromAddressHBox = new HBox();
        fromAddressHBox.getChildren().addAll(fromAddressLabel, fromAddressTextField);
        fromAddressHBox.setAlignment(Pos.CENTER);

        HBox toAddressHBox = new HBox();
        toAddressHBox.getChildren().addAll(toAddressLabel, toAddressTextField);
        toAddressHBox.setAlignment(Pos.CENTER);

        VBox orderVBox = new VBox();
        orderVBox.setAlignment(Pos.CENTER);
        orderVBox.setSpacing(10);
        orderVBox.setPadding(new Insets(0, 0, 50, 30));
        orderVBox.getChildren().addAll(welcomeTitle, fromAddressHBox, toAddressHBox, orderButton);

        Scene scene = new Scene(orderVBox);

        clientStage.setScene(scene);
        clientStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopping BikeCourier App.");
    }

}