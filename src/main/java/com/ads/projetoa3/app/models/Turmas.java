package com.ads.projetoa3.app.models;

import javafx.scene.control.ChoiceBox;

public class Turmas {
    private String nomeTurmas;
    private String periodoTurmas;
    private ChoiceBox disciplinaTurmas;

    public Turmas (String nomeTurmas, String idTurmas, String periodoTurmas, ChoiceBox disciplinaTurmas) {
        this.nomeTurmas = nomeTurmas;
        this.periodoTurmas = periodoTurmas;
        this.disciplinaTurmas = disciplinaTurmas;
    }


}
