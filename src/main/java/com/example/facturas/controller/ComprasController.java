package com.example.facturas.controller;

import com.example.facturas.services.ComprasService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ComprasController {

    private final ComprasService comprasService = new ComprasService();

    @FXML
    private void mostrarProeevedorC() {
        cargarVista("/fxml/ejemplo.fxml");
    }

    @FXML
    private void mostrarListadoC() {
        cargarVista("/fxml/listado_compras.fxml");
    }

    @FXML
    private void mostrarOrdenC() {
        cargarVista("/fxml/orden_compra.fxml");
    }

    @FXML
    private void mostrarComprasC() {
        cargarVista("/fxml/compras.fxml");
    }

    @FXML
    private void mostrarCategorias() {
        cargarVista("/fxml/categorias.fxml");
    }

    @FXML
    private void mostrarOpciones() {
        cargarVista("/fxml/opciones.fxml");
    }

    private void cargarVista(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
