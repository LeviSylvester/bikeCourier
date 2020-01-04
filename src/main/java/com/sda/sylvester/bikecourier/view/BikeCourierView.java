package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.service.Dispatch;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BikeCourierView extends Application {

    private final VBox clientPlaceOrderVBox = new VBox();

    private Label courierOrdersTableViewLabel = new Label("Orders");
    private TableView<Order> courierOrdersTableView = new TableView<>();
    private TableColumn fromColumn = new TableColumn("From");
    private TableColumn toColumn = new TableColumn("To");
    private TableColumn termColumn = new TableColumn("Term");
    private HBox courierAddOrderHBox = new HBox();
    private final VBox courierFaresVBox = new VBox();

    @Override
    public void start(Stage bikeCourierStage) {

        bikeCourierStage.setTitle("BikeCourier");
        bikeCourierStage.setWidth(720);
        bikeCourierStage.setHeight(640);
        bikeCourierStage.setX(215);
        bikeCourierStage.setY(64);

        buildClientPhoneAppSimulation(clientPlaceOrderVBox);

        buildCourierOrdersTable(courierOrdersTableViewLabel, courierOrdersTableView, fromColumn, toColumn, termColumn);
        buildCourierAddOrderHBox(fromColumn, toColumn, termColumn, courierAddOrderHBox);
        buildCourierPhoneAppSimulation(courierFaresVBox, courierOrdersTableViewLabel, courierOrdersTableView, courierAddOrderHBox);

        HBox clientAndCourierPhoneAppHBox = new HBox();
        clientAndCourierPhoneAppHBox.getChildren().addAll(clientPlaceOrderVBox, courierFaresVBox);
        Scene bikeCourierScene = new Scene(clientAndCourierPhoneAppHBox);
        bikeCourierStage.setScene(bikeCourierScene);
        bikeCourierStage.show();
    }

    private void buildClientPhoneAppSimulation(VBox clientPlaceOrderVBox) {
        clientPlaceOrderVBox.setAlignment(Pos.CENTER);
        clientPlaceOrderVBox.setSpacing(10);
        clientPlaceOrderVBox.setPadding(new Insets(0, 0, 0, 75));

        Text clientWelcomeText = new Text("Order a courier");
        clientWelcomeText.setFont(Font.font("Veranda", 30));
        clientWelcomeText.setFill(Paint.valueOf("#2455d1"));

        Label fromLabel = new Label("From: ");
        TextField fromTextField = new TextField();

        Label toLabel = new Label("To: ");
        TextField toTextField = new TextField();

        Label termLabel = new Label("Term: ");
        TextField termTextField = new TextField();

        Button orderButton = new Button("Place order");
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

        clientPlaceOrderVBox.getChildren().addAll(clientWelcomeText, fromHBox, toHBox, termHBox, orderButton);
    }

    private static void buildCourierOrdersTable(Label courierOrdersTableViewLabel, TableView<Order> courierOrdersTableView, TableColumn fromColumn, TableColumn toColumn, TableColumn termColumn) {
        courierOrdersTableViewLabel.setFont(new Font("Arial", 20));

        courierOrdersTableView.setEditable(true);

        fromColumn.setMinWidth(100);
        fromColumn.setCellValueFactory(
                new PropertyValueFactory<Order, String>("from"));
        fromColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fromColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Order, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Order, String> t) {
                        ((Order) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFrom(t.getNewValue());
                    }
                }
        );


        toColumn.setMinWidth(100);
        toColumn.setCellValueFactory(
                new PropertyValueFactory<Order, String>("to"));
        toColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        toColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Order, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Order, String> t) {
                        ((Order) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTo(t.getNewValue());
                    }
                }
        );

        termColumn.setMinWidth(100);
        termColumn.setCellValueFactory(
                new PropertyValueFactory<Order, String>("term"));
        termColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        termColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Order, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Order, String> t) {
                        ((Order) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTerm(t.getNewValue());
                    }
                }
        );

        courierOrdersTableView.setItems(Dispatch.ordersObservableList);
        courierOrdersTableView.getColumns().addAll(fromColumn, toColumn, termColumn);
    }

    private static void buildCourierAddOrderHBox(TableColumn fromColumn, TableColumn toColumn, TableColumn termColumn, HBox courierAddOrderHBox) {
        final TextField fromTextField = new TextField();
        fromTextField.setPromptText("From");
        fromTextField.setMaxWidth(fromColumn.getPrefWidth());
        final TextField toTextField = new TextField();
        toTextField.setMaxWidth(toColumn.getPrefWidth());
        toTextField.setPromptText("To");
        final TextField termTextField = new TextField();
        termTextField.setMaxWidth(termColumn.getPrefWidth());
        termTextField.setPromptText("Term");

        final Button addOrderButton = new Button("Add Order");
        addOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Dispatch.ordersObservableList.add(new Order(
                        fromTextField.getText(),
                        toTextField.getText(),
                        termTextField.getText()));
                fromTextField.clear();
                toTextField.clear();
                termTextField.clear();
            }
        });

        courierAddOrderHBox.getChildren().addAll(fromTextField, toTextField, termTextField, addOrderButton);
        courierAddOrderHBox.setSpacing(3);
    }

    private void buildCourierPhoneAppSimulation(VBox courierFaresVBox, Label courierOrdersTableViewLabel, TableView<Order> courierOrdersTableView, HBox courierAddOrderHBox) {
        courierFaresVBox.setSpacing(5);
        courierFaresVBox.setPadding(new Insets(10, 0, 0, 95));
        courierFaresVBox.getChildren().addAll(courierOrdersTableViewLabel, courierOrdersTableView, courierAddOrderHBox);
    }

}