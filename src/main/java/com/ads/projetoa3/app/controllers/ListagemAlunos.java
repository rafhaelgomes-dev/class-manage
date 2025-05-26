package com.ads.projetoa3.app.controllers;


import com.ads.projetoa3.app.repositories.AlunoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import com.ads.projetoa3.app.models.Aluno;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListagemAlunos implements Initializable {
    @FXML
    private TableView<Aluno> tableViewAlunos;

    private ObservableList<Aluno> alunos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Aluno> alunosRepository = AlunoRepository.getAlunos();
        alunos.addAll(alunosRepository);
        tableViewAlunos.setItems(alunos);
    }
}
