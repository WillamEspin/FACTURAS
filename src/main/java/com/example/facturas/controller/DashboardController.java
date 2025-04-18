package com.example.facturas.controller;

import io.github.palexdev.materialfx.controls.MFXRectangleToggleNode;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
public class DashboardController {

    @FXML private MFXRectangleToggleNode btnFacturacion;
    @FXML private MFXRectangleToggleNode btnCompras;
    @FXML private MFXRectangleToggleNode btnVentas;
    @FXML private MFXRectangleToggleNode btnInventario;
    @FXML private MFXRectangleToggleNode btSri;
    @FXML private MFXRectangleToggleNode btnReportes;
    @FXML private MFXRectangleToggleNode btnUsuario;
    @FXML private MFXRectangleToggleNode btnSalir;

    private final ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    public void initialize() {
        // Agrupar los botones
        btnFacturacion.setToggleGroup(toggleGroup);
        btnCompras.setToggleGroup(toggleGroup);
        btnVentas.setToggleGroup(toggleGroup);
        btnInventario.setToggleGroup(toggleGroup);
        btSri.setToggleGroup(toggleGroup);
        btnReportes.setToggleGroup(toggleGroup);
        btnUsuario.setToggleGroup(toggleGroup);
        btnSalir.setToggleGroup(toggleGroup);

        // Evento de selección
        toggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle instanceof MFXRectangleToggleNode toggle) {
                cambiarContenido(toggle.getText());
            }
        });
    }

    private void cambiarContenido(String nombreSeccion) {
        System.out.println("Sección seleccionada: " + nombreSeccion);
        // Aquí puedes cargar el contenido dinámicamente según la sección
    }
}