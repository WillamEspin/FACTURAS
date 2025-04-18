package com.example.facturas.controller;

import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML private MFXTextField txtUsuario;
    @FXML private MFXPasswordField txtContrasena;

    @FXML
    private void handleLogin(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String clave = txtContrasena.getText();

        if (usuario.equals("admin") && clave.equals("admin")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) txtUsuario.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }
}