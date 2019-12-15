package com.sda.sylvester.bikecourier.view;

import com.sda.sylvester.bikecourier.service.PersonDisplayService;
import javafx.application.Application;
import javafx.stage.Stage;

public class BikeCourierMainView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PersonDisplayService personDisplayService = new PersonDisplayService();

        //NU FOLOSIM DAO AICI (in view)


    }
}
