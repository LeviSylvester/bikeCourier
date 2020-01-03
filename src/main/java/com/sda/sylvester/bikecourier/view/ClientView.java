package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.service.Dispatch;
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

public class ClientView extends Application {

    @Override
    public void start(Stage clientStage) throws Exception {
        clientStage.setTitle("BikeCourier");
        clientStage.setHeight(640);
        clientStage.setWidth(360);
        clientStage.setX(215);
        clientStage.setY(64);

        Label fromLabel = new Label("From: ");
        Label toLabel = new Label("To: ");
        Label termLabel = new Label("Term: ");


        Text welcomeTitle = new Text("Order a courier");
        welcomeTitle.setFont(Font.font("Veranda", 30));
        welcomeTitle.setFill(Paint.valueOf("#2455d1"));

        TextField fromTextField = new TextField();
        TextField toTextField = new TextField();
        TextField termTextField = new TextField();

        Button orderButton = new Button("Add order");
        orderButton.setOnMouseClicked(event -> {
            Order order = new Order();
            order.setFrom(fromTextField.getText());
            order.setTo(toTextField.getText());
            order.setTerm(termTextField.getText());
            fromTextField.clear();
            toTextField.clear();
            termTextField.clear();
            Dispatch.ordersObservableList.add(order);
        });

        HBox fromHBox = new HBox();
        fromHBox.getChildren().addAll(fromLabel, fromTextField);
        fromHBox.setAlignment(Pos.CENTER);

        HBox toHBox = new HBox();
        toHBox.getChildren().addAll(toLabel, toTextField);
        toHBox.setAlignment(Pos.CENTER);

        HBox termHBox = new HBox();
        termHBox.getChildren().addAll(termLabel, termTextField);
        termHBox.setAlignment(Pos.CENTER);

        VBox orderVBox = new VBox();
        orderVBox.setAlignment(Pos.CENTER);
        orderVBox.setSpacing(10);
        orderVBox.setPadding(new Insets(0, 0, 50, 30));
        orderVBox.getChildren().addAll(welcomeTitle, fromHBox, toHBox, termHBox, orderButton);

        Scene scene = new Scene(orderVBox);

        clientStage.setScene(scene);
        clientStage.show();
    }

}