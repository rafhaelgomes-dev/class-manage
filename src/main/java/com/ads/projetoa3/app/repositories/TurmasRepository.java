package com.ads.projetoa3.app.repositories;

import com.ads.projetoa3.app.models.Turmas;
import java.util.ArrayList;

public class TurmasRepository {
    protected static ArrayList<Turmas> turma = new ArrayList<>();

    public static void saveTurma(Turmas Turmas) {
        turma.add(Turmas);
    }

    public static ArrayList<Turmas> getTurmas() {
        return turma;
    }


}
