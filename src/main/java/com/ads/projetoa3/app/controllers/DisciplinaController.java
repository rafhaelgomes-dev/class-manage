package com.ads.projetoa3.app.controllers;

import com.ads.projetoa3.app.models.Disciplina;
import com.ads.projetoa3.app.repositories.DisciplinaRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;
import static com.ads.projetoa3.app.utils.FormUtils.limparCampos;

public class DisciplinaController {
    @FXML
    private TextField nomeDisciplina;

    @FXML
    private TextField codigo;

    @FXML
    private TextField cargaHoraria;

    @FXML
    private TextField descricao;

    private ArrayList<Disciplina> diciplinasSelecionadas = new ArrayList<>();

    @FXML
    protected void salveDisciplina() {
        String getNameDisciplina = this.nomeDisciplina.getText();
        String getCodigo = this.codigo.getText();
        String getCargaHoaria = this.cargaHoraria.getText();
        String getDescricao = this.descricao.getText();

        if (getNameDisciplina.isEmpty() || getCodigo.isEmpty() || getCargaHoaria.isEmpty() || getDescricao.isEmpty()) {
            mostrarAlertaErro("Preencha todos os campos!");
            return;
        }

        Disciplina disciplina = new Disciplina(getNameDisciplina, getCodigo, getCargaHoaria, getCargaHoaria);
        DisciplinaRepository.saveDisciplina(disciplina);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação Bem-Sucedida");
        alert.setHeaderText(null);
        alert.setContentText("Disciplina salva com sucesso!");
        alert.showAndWait();

        this.nomeDisciplina.setText("");
        this.codigo.setText("");
        this.cargaHoraria.setText("");
        this.descricao.setText("");
    }
    @FXML
    private void cancelDisciplina() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Deseja cancelar?");
        alert.setContentText("Todos os dados não salvos serão perdidos.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            limparCampos(nomeDisciplina, codigo, cargaHoraria, descricao);
            Stage stage = (Stage) nomeDisciplina.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    protected void getDisciplina() {
        ArrayList<Disciplina> todasDisiciplinas = DisciplinaRepository.getDisciplinas();

        if (todasDisiciplinas.isEmpty()) {
            mostrarAlertaErro("Nenhuma disiplina encontrada.");
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
