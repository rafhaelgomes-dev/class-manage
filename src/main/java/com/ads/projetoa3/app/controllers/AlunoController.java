package com.ads.projetoa3.app.controllers;


import com.ads.projetoa3.app.models.Aluno;
import com.ads.projetoa3.app.repositories.AlunoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.ads.projetoa3.app.controllers.FormUtils.limparCampos;


public class AlunoController {
    @FXML
    private TextField nome;

    @FXML
    private TextField email;

    @FXML
    private TextField matricula;

    @FXML
    private TextField curso;

    private ArrayList<Aluno> alunosSelecionados = new ArrayList<>();

    @FXML
    protected void salveAluno(){
        String getName = this.nome.getText();
        String getEmail = this.email.getText();
        String getMatricula = this.matricula.getText();
        String getCurso = this.curso.getText();

        if(getName.isEmpty() || getEmail.isEmpty() || getMatricula.isEmpty() || getCurso.isEmpty()) {
            mostrarAlertaErro("Preencha todos os campos!");
            return;
        }


        Aluno aluno = new Aluno(getName, getEmail, getMatricula, getCurso);
        AlunoRepository.saveAluno(aluno);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação Bem-Sucedida");
        alert.setHeaderText(null);
        alert.setContentText("Aluno salvo com sucesso!");
        alert.showAndWait();

        this.nome.setText("");
        this.email.setText("");
        this.matricula.setText("");
        this.curso.setText("");
    }

    @FXML
    private void cancelAluno() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Deseja cancelar?");
        alert.setContentText("Todos os dados não salvos serão perdidos.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            limparCampos(nome, matricula, email, curso);
            Stage stage = (Stage) nome.getScene().getWindow();
            stage.close();
        }
    }


    @FXML
    protected void getAluno() {
        ArrayList<Aluno> todosAlunos = AlunoRepository.getAlunos();

        if (todosAlunos.isEmpty()) {
            mostrarAlertaErro("Nenhum aluno encontrado.");
            return;
        }
    }

    private void mostrarAlertaErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}
