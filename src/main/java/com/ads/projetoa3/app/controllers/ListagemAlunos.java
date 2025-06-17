package com.ads.projetoa3.app.controllers;

import com.ads.projetoa3.app.models.Aluno;
import com.ads.projetoa3.app.repositories.AlunoRepository;
import com.ads.projetoa3.app.utils.MostrarAlerta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ListagemAlunos implements Initializable {

    @FXML
    private TableView<Aluno> tableViewAlunos;

    @FXML
    private TableColumn<Aluno, String> colunaNome;

    @FXML
    private TableColumn<Aluno, String> colunaMatricula;

    @FXML
    private TableColumn<Aluno, String> colunaCurso;

    @FXML
    private TableColumn<Aluno, String> colunaEmail;

    private ObservableList<Aluno> alunos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarAlunos();
    }

    private void carregarAlunos() {
        try {
            List<Aluno> alunosRepository = AlunoRepository.getAlunos();

            alunos.setAll(alunosRepository);

            tableViewAlunos.setItems(alunos);

            if (alunos.isEmpty()) {
                MostrarAlerta.mostrarAlertaInformacao("Nenhum aluno encontrado",
                        "Não há alunos cadastrados no sistema.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar alunos: " + e.getMessage());
            e.printStackTrace();
            MostrarAlerta.mostrarAlertaErro("Não foi possível carregar a lista de alunos: " + e.getMessage());
        }
    }

    @FXML
    private void atualizarLista() {
        carregarAlunos();
    }

}
