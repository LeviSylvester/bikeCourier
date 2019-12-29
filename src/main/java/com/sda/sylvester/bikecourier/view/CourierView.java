package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.service.OrdersProcessingService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CourierView extends Application {

    public static TableView ordersTableView = new TableView();

    @Override
    public void init() throws Exception {
        System.out.println("Starting BikeCourier for Couriers...");
    }

    @Override
    public void start(Stage courierStage) throws Exception {

        courierStage.setTitle("BikeCourier");
        courierStage.setHeight(640);
        courierStage.setWidth(360);
        courierStage.setX(790);
        courierStage.setY(64);

        Text welcomeTitle = new Text("Take an order");
        welcomeTitle.setFont(Font.font("Veranda", 30));
        welcomeTitle.setFill(Paint.valueOf("#2455d1"));

        Label ordersLabel = new Label("Active orders");
        ordersLabel.setFont(new Font("Arial", 20));

        ordersTableView.setEditable(true);

        TableColumn from = new TableColumn("From");
        TableColumn to = new TableColumn("To");
        TableColumn term = new TableColumn("Term");

        from.setCellValueFactory(
                new PropertyValueFactory<Order,String>("from")
        );
        to.setCellValueFactory(
                new PropertyValueFactory<Order,String>("to")
        );
        term.setCellValueFactory(
                new PropertyValueFactory<Order,String>("term")
        );

        ordersTableView.getColumns().addAll(from, to, term);

        ObservableList<Order> observableOrderList =
                FXCollections.observableArrayList(OrdersProcessingService.orders);

        ordersTableView.setItems(observableOrderList);

        VBox courierVBox = new VBox();
        courierVBox.setSpacing(5);
        courierVBox.setPadding(new Insets(10, 0, 0, 10));
        courierVBox.getChildren().addAll(ordersLabel, ordersTableView);

        Scene courierScene = new Scene(courierVBox);

//        TextField textField = new TextField();
//
//        if(AddPersonValidator.isInputValid(Arrays.asList(textField.getText()))){
//            //save, service getUser();
//        } else {
//            System.out.println("Input not valid!");
//        }

        courierStage.setScene(courierScene);
        courierStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopping BikeCourier App.");
    }

}