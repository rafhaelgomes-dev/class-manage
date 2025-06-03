package com.ads.projetoa3.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class TelaInicial {
    @FXML
    private Button btnCadastrarAluno;

    @FXML
    private Button btnListarAluno;

    @FXML
    private Button btnCadastrarDisciplina;

    @FXML
    private Button btnCadastrarProfessor;

    @FXML
    private Button btnCadastrarTurmas;

    @FXML
    protected void cadastrarAluno() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ads/projetoa3/app/cadastro-aluno.fxml"));

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Alunos");
            novaJanela.setScene(new Scene(root));

            novaJanela.initOwner(btnCadastrarAluno.getScene().getWindow());

            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void listarAluno() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ads/projetoa3/app/listagem-alunos.fxml"));

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Listagem de Alunos");
            novaJanela.setScene(new Scene(root));

            novaJanela.initOwner(btnListarAluno.getScene().getWindow());

            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void cadastrarDisciplina() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ads/projetoa3/app/cadastro-disciplina.fxml"));

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Disciplinas");
            novaJanela.setScene(new Scene(root));

            novaJanela.initOwner(btnCadastrarDisciplina.getScene().getWindow());

            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void cadastrarProfessor() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ads/projetoa3/app/cadastro-professor.fxml"));

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Professor");
            novaJanela.setScene(new Scene(root));

            novaJanela.initOwner(btnCadastrarProfessor.getScene().getWindow());

            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void cadastrarTurmas() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ads/projetoa3/app/cadastro-turmas.fxml"));

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Turmas");
            novaJanela.setScene(new Scene(root));

            novaJanela.initOwner(btnCadastrarTurmas.getScene().getWindow());

            novaJanela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
