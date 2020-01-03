package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.model.Order;
import com.sda.sylvester.bikecourier.service.Dispatch;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CourierView1 extends Application {

    private TableView<Order> ordersTableView = new TableView<Order>();

    final HBox courierHBox = new HBox();

    @Override
    public void start(Stage courierStage) {
        Scene courierScene = new Scene(new Group());
        courierStage.setTitle("BikeCourier");
        courierStage.setWidth(360);
        courierStage.setHeight(640);
        courierStage.setX(790);
        courierStage.setY(64);

        final Label ordersTableViewLabel = new Label("Orders");
        ordersTableViewLabel.setFont(new Font("Arial", 20));

        ordersTableView.setEditable(true);

        TableColumn fromColumn = new TableColumn("From");
        fromColumn.setMinWidth(100);
        fromColumn.setCellValueFactory(
                new PropertyValueFactory<Order, String>("from"));
        fromColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fromColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<Order, String>>() {
                    @Override
                    public void handle(CellEditEvent<Order, String> t) {
                        ((Order) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFrom(t.getNewValue());
                    }
                }
        );


        TableColumn toColumn = new TableColumn("To");
        toColumn.setMinWidth(100);
        toColumn.setCellValueFactory(
                new PropertyValueFactory<Order, String>("to"));
        toColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        toColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<Order, String>>() {
                    @Override
                    public void handle(CellEditEvent<Order, String> t) {
                        ((Order) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTo(t.getNewValue());
                    }
                }
        );

        TableColumn termColumn = new TableColumn("Term");
        termColumn.setMinWidth(100);
        termColumn.setCellValueFactory(
                new PropertyValueFactory<Order, String>("term"));
        termColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        termColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<Order, String>>() {
                    @Override
                    public void handle(CellEditEvent<Order, String> t) {
                        ((Order) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTerm(t.getNewValue());
                    }
                }
        );

        ordersTableView.setItems(Dispatch.ordersObservableList);
        ordersTableView.getColumns().addAll(fromColumn, toColumn, termColumn);

        final TextField addFrom = new TextField();
        addFrom.setPromptText("From");
        addFrom.setMaxWidth(fromColumn.getPrefWidth());
        final TextField addTo = new TextField();
        addTo.setMaxWidth(toColumn.getPrefWidth());
        addTo.setPromptText("To");
        final TextField addTerm = new TextField();
        addTerm.setMaxWidth(termColumn.getPrefWidth());
        addTerm.setPromptText("Term");

        final Button addOrderButton = new Button("Add Order");
        addOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Dispatch.ordersObservableList.add(new Order(
                        addFrom.getText(),
                        addTo.getText(),
                        addTerm.getText()));
                addFrom.clear();
                addTo.clear();
                addTerm.clear();
            }
        });

        courierHBox.getChildren().addAll(addFrom, addTo, addTerm, addOrderButton);
        courierHBox.setSpacing(3);

        final VBox courierVBox = new VBox();
        courierVBox.setSpacing(5);
        courierVBox.setPadding(new Insets(10, 0, 0, 10));
        courierVBox.getChildren().addAll(ordersTableViewLabel, ordersTableView, courierHBox);

        ((Group) courierScene.getRoot()).getChildren().addAll(courierVBox);

        courierStage.setScene(courierScene);
        courierStage.show();
    }

}