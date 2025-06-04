package com.ads.projetoa3.app.controllers;

import com.ads.projetoa3.app.models.Professor;
import com.ads.projetoa3.app.repositories.LoginRepository;
import com.ads.projetoa3.app.utils.MostrarAlerta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {
    @FXML
    private TextField emailLogin;

    @FXML
    private TextField senhaLogin;

    @FXML
    public void login() {
        String email = this.emailLogin.getText();
        String senha = this.senhaLogin.getText();

        boolean validar = this.validate(email, senha);
        if (!validar) return;

        Professor professor = LoginRepository.login(email, senha);

        System.out.print(professor);

        if (professor == null) {
            MostrarAlerta.mostrarAlertaErro("Email ou senha inválido!");
            return;
        }
        this.telaIncial();
    }

    @FXML
    public void telaIncial() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ads/projetoa3/app/tela-inicial.fxml"));

            root.lookupAll(".button").forEach(node -> {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    btn.setMaxWidth(300);
                    btn.setStyle(btn.getStyle() +
                            " -fx-font-size: 14px; -fx-padding: 10 20; -fx-max-width: 300px;");
                }
            });

            Stage novaJanela = new Stage();
            novaJanela.setMaximized(true);
            novaJanela.setTitle("Inicio");
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            Stage janelaAtual = (Stage) emailLogin.getScene().getWindow();
            janelaAtual.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validate(String email, String senha) {
        if (email.isEmpty()) {
            MostrarAlerta.mostrarAlertaErro("Email é obrigatório");
            return false;
        }

        if (senha.isEmpty()) {
            MostrarAlerta.mostrarAlertaErro("Senha é obrigatório");
            return false;
        }

        if (senha.length() < 6) {
            MostrarAlerta.mostrarAlertaErro("Senha deve ser igual ou maior a 6 caracteres");
            return false;
        }

        if (!this.validarEmail(email)) {
            MostrarAlerta.mostrarAlertaErro("Email inválido");
            return false;
        }

        return true;
    }

    private boolean validarEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
