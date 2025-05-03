package com.example.facturas.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentasController {

    @FXML
    private void abrirFacturasFisicas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/facturasfisicas.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage(); // crea una nueva ventana
            stage.setTitle("Facturas Físicas");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
