package com.ads.projetoa3.app.utils;
import javafx.scene.control.Alert;

public class MostrarAlerta {
    public static void mostrarAlertaErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
