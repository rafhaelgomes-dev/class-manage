package com.ads.projetoa3.app.controllers;
import javafx.scene.control.TextField;
public class FormUtils {
    public static void limparCampos(TextField... campos) {
        for (TextField campo : campos) {
            campo.clear();
        }
    }
}


