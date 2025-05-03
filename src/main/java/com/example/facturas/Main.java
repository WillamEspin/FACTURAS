package com.example.facturas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Sistema de Facturación");
        stage.show();
        //desactiva el poder modificar el tama;o de la pantalla
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}