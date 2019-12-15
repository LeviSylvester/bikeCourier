package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.model.Person;
import com.sda.sylvester.bikecourier.service.PersonDisplayService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class BikeCourierMainView extends Application {

    //    public static final ObservableList persons =
//            FXCollections.observableArrayList();
//    public static final ObservableList data =
//            FXCollections.observableArrayList();
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

//        System.out.println(personsFromCity);

        final ObservableList<Person> observableListData = FXCollections.observableArrayList(personsFromCity);

        table.setItems(observableListData);


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        bikeCourierStage.setScene(scene);
        bikeCourierStage.show();

//        final ListView listView = new ListView(data);
//
//        List<Person> personsFromCity = personDisplayService.getPersonsFromCity("City");
//
//        bikeCourierStage.setTitle("BikeCourier");
//
//        listView.setPrefSize(1000, 700);
////        listView.setEditable(true);
//
//        persons.addAll(personsFromCity);
//
//        for (Person p : personsFromCity) {
////            data.add(String.format("%s %s", p.getFirstName(), p.getLastName()));
//            data.add(p.toString());
//        }
//
//        listView.setItems(data);
//        listView.setCellFactory(ComboBoxListCell.forListView(persons));
//
//        StackPane rootStackPane = new StackPane();
//        rootStackPane.getChildren().add(listView);
//        Scene bikeCourierScene = new Scene(rootStackPane, 200, 250);
//
//        bikeCourierStage.setScene(bikeCourierScene);
//        bikeCourierStage.show();
        //NU FOLOSIM DAO AICI (in view)
//
//
//        bikeCourierStage.setTitle("BikeCourier");
//        bikeCourierStage.setWidth(1024);
//        bikeCourierStage.setHeight(768);
//        bikeCourierStage.setX(100);
//        bikeCourierStage.setY(100);
//
//        Text welcomeTitle = new Text("Thanks for using BikeCourier Alpha0.1");
//        welcomeTitle.setFont(Font.font("Veranda", 10));
//        welcomeTitle.setFill(Paint.valueOf("#2455d1"));
//
////        TextField bikeCourierTextField = new TextField();
//
////        Button[] buttons = new Button[10];
////        for (int i = 0; i < 10; i++) {
////            Button button = new Button(String.format("  %s  ", i));
////            buttons[i] = button;
////        }
////        Button buttonClear = new Button("  C  ");
////        Button buttonBackspace = new Button(" Del");
////        Button buttonDot = new Button("   .  ");
////        Button buttonDivide = new Button("  ÷ ");
////        Button buttonMultiply = new Button("  x  ");
////        Button buttonSubtract = new Button("  -  ");
////        Button buttonAdd = new Button("  + ");
////        Button buttonEquals = new Button("  = ");
//
////        HBox hBox = new HBox();
////        hBox.getChildren().add(bikeCourierTextField);
////        hBox.setAlignment(Pos.TOP_LEFT);
//
//        GridPane gridPane = new GridPane();
//        personDisplayService.getAllPersons();
//
//        gridPane.setHgap(2);
//        gridPane.setVgap(2);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        VBox vBox = new VBox();
//        vBox.setAlignment(Pos.TOP_LEFT);
//        vBox.setSpacing(5);
//        vBox.setPadding(new Insets(5, 0, 0, 5));
//        vBox.getChildren().addAll(welcomeTitle, hBox, gridPane);
//
////        calculatorTextField.setOnKeyPressed(event -> {
////            System.out.print(event.getText());
////        });
////
////        for (int i = 0; i < 10; i++) {
////            final int j = i;
////            buttons[i].setOnMouseClicked(event -> {
////                System.out.print(j);
////                calculatorTextField.appendText(String.valueOf(j));
////            });
////        }
////
////        buttonClear.setOnMouseClicked(event -> {
////            calculatorTextField.clear();
////            System.out.println();
////        });
////
////        buttonBackspace.setOnMouseClicked(event -> {
////            int length = calculatorTextField.getText().length();
////            if (length > 0) calculatorTextField.deleteText(length - 1, length);
////        });
////
////        buttonDot.setOnMouseClicked(event -> {
////            calculatorTextField.appendText(".");
////            System.out.print(".");
////        });
////
////        buttonDivide.setOnMouseClicked(event -> {
////            calculatorTextField.appendText("/");
////            System.out.print("/");
////        });
////
////        buttonMultiply.setOnMouseClicked(event -> {
////            calculatorTextField.appendText("*");
////            System.out.print("*");
////        });
////
////        buttonSubtract.setOnMouseClicked(event -> {
////            calculatorTextField.appendText("-");
////            System.out.print("-");
////        });
////
////        buttonAdd.setOnMouseClicked(event -> {
////            calculatorTextField.appendText("+");
////            System.out.print("+");
////        });
////
////        EventHandler<ActionEvent> equalsEvent = event ->
////        {
////            String initialText = calculatorTextField.getText();
////            String[] operandStrings = initialText.split("[\\/\\*\\-\\+]");
////
////            try {
////
////                double[] operands = {Double.parseDouble(operandStrings[0]), Double.parseDouble(operandStrings[1])};
////                double calculated = 0;
////
////                //operates with TWO numbers so far
////                if (initialText.contains("/")) calculated = operands[0] / operands[1];
////                else if (initialText.contains("*")) calculated = operands[0] * operands[1];
////                else if (initialText.contains("-")) calculated = operands[0] - operands[1];
////                else if (initialText.contains("+")) calculated = operands[0] + operands[1];
////
////                DecimalFormat df4 = new DecimalFormat("#.####");
////                String result = String.valueOf(df4.format(calculated));
////                if (result.contains(".0")) result = result.substring(0, result.length() - 2);
////
////                calculatorTextField.setText(result);
////                calculatorTextField.positionCaret(calculatorTextField.getText().length());
////
////                System.out.println("\n" + calculatorTextField.getText());
////
////            } catch (NumberFormatException e) {
////                calculatorTextField.appendText("☻format!");
////                System.out.println("\nWrong number format or more than 1 operator!");
////            }
////        };
//
//        buttonEquals.setOnAction(equalsEvent);
//
//        Scene scene = new Scene(vBox);
//
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.ENTER) {
//                buttonEquals.fire();
//            }
//        });
//
//        calculatorStage.setScene(scene);
//        calculatorStage.show();
//

    }
}
