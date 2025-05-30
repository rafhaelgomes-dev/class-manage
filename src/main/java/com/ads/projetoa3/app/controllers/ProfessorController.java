package com.ads.projetoa3.app.controllers;

import com.ads.projetoa3.app.models.Professor;
import com.ads.projetoa3.app.repositories.ProfessorRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class ProfessorController {
    @FXML
    private TextField professorNome;
    @FXML
    private TextField professorEmail;
    @FXML
    private TextField senha;
    @FXML
    private TextField disciplina;

    private ArrayList<Professor> professorSelecionado = new ArrayList<>();

    @FXML
    protected void salveProfessor(){
        String getNome = this.professorNome.getText();
        String getEmail = this.professorEmail.getText();
        String getSenha = this.senha.getText();
        String getDisciplina = this.disciplina.getText();

        if(getNome.isEmpty() || getEmail.isEmpty() || getSenha.isEmpty() || getDisciplina.isEmpty()){
            mostrarAlertaErroProfessor("Preencha todos os campos!");
            return;
        }

        Professor professor = new Professor(getNome, getEmail, getDisciplina);
        ProfessorRepository.saveProfessor(professor, getSenha);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação Bem-Sucedida");
        alert.setHeaderText(null);
        alert.setContentText("Professor salvo com sucesso!");
        alert.showAndWait();

        this.professorNome.setText("");
        this.professorEmail.setText("");
        this.senha.setText("");
        this.disciplina.setText("");
    }

    @FXML
    protected void getProfessor(){
        ArrayList<Professor> todosProfessores = ProfessorRepository.getProfessores();

        if (todosProfessores.isEmpty()) {
            mostrarAlertaErroProfessor("Nenhum Professor Encontrado");
            return;
        }
    }

    private void mostrarAlertaErroProfessor(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
