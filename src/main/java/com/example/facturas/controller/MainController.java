package com.example.facturas.controller;

import com.example.facturas.Main;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXRectangleToggleNode;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import io.github.palexdev.materialfx.dialogs.MFXStageDialog;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {

    @FXML private MFXRectangleToggleNode btnDashboard;
    @FXML private MFXRectangleToggleNode btnCompras;
    @FXML private MFXRectangleToggleNode btnVentas;
    @FXML private MFXRectangleToggleNode btnInventario;
    @FXML private MFXRectangleToggleNode btnSri;
    @FXML private MFXRectangleToggleNode btnCCobrar;
    @FXML private MFXRectangleToggleNode btnCPagar;
    @FXML private MFXRectangleToggleNode btnReportes;
    @FXML private MFXRectangleToggleNode btnUsuario;
    @FXML private MFXRectangleToggleNode btnSalir;

    private final ToggleGroup toggleGroup = new ToggleGroup();

    @FXML

    public void initialize() {
        // Agrupar los botones
        btnDashboard.setToggleGroup(toggleGroup);
        btnCompras.setToggleGroup(toggleGroup);
        btnVentas.setToggleGroup(toggleGroup);
        btnInventario.setToggleGroup(toggleGroup);
        btnSri.setToggleGroup(toggleGroup);
        btnCCobrar.setToggleGroup(toggleGroup);
        btnCPagar.setToggleGroup(toggleGroup);
        btnReportes.setToggleGroup(toggleGroup);
        btnUsuario.setToggleGroup(toggleGroup);
        btnSalir.setToggleGroup(toggleGroup);


        // Evento de selección
        toggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle instanceof MFXRectangleToggleNode toggle) {
                if (toggle == btnSalir) {
                    mostrarDialogoSalir();
                } else {
                    Object data = toggle.getUserData();
                    if (data != null) {
                        cambiarContenido(data.toString());
                    }
                }
            }
        });
    }

    private void cambiarContenido(String nombreSeccion) {
        String rutaFXML = switch (nombreSeccion.toLowerCase()) {
            case "dashboard" -> "/view/dashboard.fxml";
            case "compras" -> "/view/compras.fxml";
            case "ventas" -> "/view/ventas.fxml";
            case "inventario" -> "/view/inventario.fxml";
            case "sri" -> "/view/sri.fxml";
            case "ccobrar" -> "/view/ccobrar.fxml";
            case "cpagar" -> "/view/cpagar.fxml";
            case "reportes" -> "/view/reportes.fxml";
            case "usuario" -> "/view/usuario.fxml";
            default -> null;
        };

        if (rutaFXML != null) {
            cargarVista(rutaFXML);
        } else {
            System.out.println("Sección no reconocida: " + nombreSeccion);
        }
    }



    @FXML
    private BorderPane contentArea;

    public void mostrarCompras() {
        cargarVista("/view/compras.fxml");
    }

    private void cargarVista(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
            javafx.scene.Node vista = loader.load();
            contentArea.setCenter(vista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarDialogoSalir() {
        Stage ownerStage = (Stage) btnSalir.getScene().getWindow();

        // Crear contenido del diálogo
        MFXGenericDialog dialogContent = new MFXGenericDialog();
        dialogContent.setHeaderText("¿Estás seguro que deseas salir?");
        dialogContent.setContentText("Se cerrará completamente la aplicación.");

        // Aplicar clase de estilo si deseas un estilo personalizado (opcional)
        dialogContent.getStyleClass().add("mfx-dialog");

        // Crear el contenedor del diálogo
        MFXStageDialog dialog = new MFXStageDialog(dialogContent);
        dialog.initOwner(ownerStage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setDraggable(true);
        dialog.setTitle("Confirmación");


        // Crear botones con estilo MaterialFX
        MFXButton btnCancelar = new MFXButton("Cancelar");
        btnCancelar.getStyleClass().add("mfx-button");
        btnCancelar.setPrefWidth(100);
        btnCancelar.setOnMouseClicked(event -> dialog.close());

        MFXButton btnSalirApp = new MFXButton("Salir");
        btnSalirApp.getStyleClass().add("mfx-button");
        btnSalirApp.setStyle("-fx-background-color: #d32f2f; -fx-text-fill: white;");
        btnSalirApp.setPrefWidth(100);
        btnSalirApp.setOnMouseClicked(event -> {
            dialog.close();
            ownerStage.close();
            System.exit(0);
        });

        // Agregar acciones al diálogo
        dialogContent.addActions(btnCancelar, btnSalirApp);

        // Mostrar el diálogo
        dialog.showAndWait();
    }

}
