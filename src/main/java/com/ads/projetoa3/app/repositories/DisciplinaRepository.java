package com.ads.projetoa3.app.repositories;

import com.ads.projetoa3.app.models.Disciplina;
import java.util.ArrayList;

public class DisciplinaRepository {
    protected static ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public static void saveDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public static ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
