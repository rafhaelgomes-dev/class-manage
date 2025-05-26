package com.ads.projetoa3.app.controllers;


import com.ads.projetoa3.app.models.Aluno;
import com.ads.projetoa3.app.repositories.AlunoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.ArrayList;


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
