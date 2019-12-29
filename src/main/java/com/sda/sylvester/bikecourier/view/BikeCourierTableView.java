package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.model.Person;
import com.sda.sylvester.bikecourier.service.PersonDisplayService;
import com.sda.sylvester.bikecourier.validator.AddPersonValidator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class BikeCourierTableView extends Application {


    private TableView table = new TableView();

    @Override
    public void start(Stage bikeCourierStage) throws Exception {
        Scene scene = new Scene(new Group());

        bikeCourierStage.setTitle("BikeCourier");
        bikeCourierStage.setWidth(517);
        bikeCourierStage.setHeight(487);

        final Label label = new Label("Table View");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn id = new TableColumn("ID");
        TableColumn city = new TableColumn("City");
        TableColumn type = new TableColumn("type");
        TableColumn age = new TableColumn("age");

        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("firstName")
        );
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("lastName")
        );
        id.setCellValueFactory(
                new PropertyValueFactory<Person,Integer>("idPerson")
        );
        city.setCellValueFactory(
                new PropertyValueFactory<Person,String>("address")
        );
        type.setCellValueFactory(
                new PropertyValueFactory<Person,Enum>("type")
        );
        age.setCellValueFactory(
                new PropertyValueFactory<Person,Integer>("age")
        );

        table.getColumns().addAll(firstNameCol, lastNameCol, id, city, type, age);

        PersonDisplayService personDisplayService = new PersonDisplayService();
        List<Person> personsFromCity = personDisplayService.getPersonsFromCity("City");

        final ObservableList<Person> observableListData = FXCollections.observableArrayList(personsFromCity);

        table.setItems(observableListData);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        TextField textField = new TextField();

//        if(AddPersonValidator.isInputValid(Arrays.asList(textField.getText()))){
//            //save, service getUser();
//        } else {
//            System.out.println("Input not valid!");
//        }

        bikeCourierStage.setScene(scene);
        bikeCourierStage.show();
    }

}