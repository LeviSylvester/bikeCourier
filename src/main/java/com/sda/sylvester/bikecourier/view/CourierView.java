package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.service.OrderDisplayService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CourierView extends Application {

    private final VBox courierVBox = new VBox();
    private OrderDisplayService orderDisplayService = new OrderDisplayService();
    private ObservableList<Order> ordersObservableList =
            FXCollections.observableArrayList(orderDisplayService.getAllOrders());
    private Label courierOrdersTableViewLabel = new Label("Orders");
    private Button refreshButton = new Button("Refresh");
    private TableView<Order> courierOrdersTableView = new TableView<>();
    private TableColumn fromColumn = new TableColumn("From");
    private TableColumn toColumn = new TableColumn("To");
    private TableColumn termColumn = new TableColumn("Term");
    private HBox courierAddOrderHBox = new HBox();

    @Override
    public void start(Stage courierStage) {
        courierStage.setTitle("BikeCourier");
        courierStage.setWidth(360);
        courierStage.setHeight(640);
        courierStage.setX(790);
        courierStage.setY(64);

        buildCourierOrdersTable(orderDisplayService, ordersObservableList, courierOrdersTableViewLabel, refreshButton, courierOrdersTableView, fromColumn, toColumn, termColumn);
        buildCourierAddOrderHBox(ordersObservableList, fromColumn, toColumn, termColumn, courierAddOrderHBox);
        buildCourierPhoneAppSimulation(courierVBox, courierOrdersTableViewLabel, refreshButton,  courierOrdersTableView, courierAddOrderHBox);

        Scene courierScene = new Scene(courierVBox);
        courierStage.setScene(courierScene);
        courierStage.show();
    }

    private static void buildCourierOrdersTable(OrderDisplayService orderDisplayService, ObservableList<Order> ordersObservableList, Label courierOrdersTableViewLabel, Button refreshButton, TableView<Order> courierOrdersTableView, TableColumn fromColumn, TableColumn toColumn, TableColumn termColumn) {
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

        courierOrdersTableView.setItems(ordersObservableList);
        courierOrdersTableView.getColumns().addAll(fromColumn, toColumn, termColumn);

        refreshButton.setOnMouseClicked(event -> {
            ordersObservableList.setAll(orderDisplayService.getAllOrders());
        });
    }

    private static void buildCourierAddOrderHBox(ObservableList<Order> ordersObservableList, TableColumn fromColumn, TableColumn toColumn, TableColumn termColumn, HBox courierAddOrderHBox) {
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
                ordersObservableList.add(new Order(
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

    private void buildCourierPhoneAppSimulation(VBox courierFaresVBox, Label courierOrdersTableViewLabel, Button refreshButton, TableView<Order> courierOrdersTableView, HBox courierAddOrderHBox) {
        courierFaresVBox.setSpacing(5);
        courierFaresVBox.setPadding(new Insets(10, 0, 0, 11));
        courierFaresVBox.getChildren().addAll(courierOrdersTableViewLabel, courierOrdersTableView, courierAddOrderHBox);
    }

}