package com.ads.projetoa3.app.repositories;

import com.ads.projetoa3.app.models.Aluno;
import java.util.ArrayList;

public class AlunoRepository {

    protected static ArrayList<Aluno> alunos = new ArrayList<>();

    public static void saveAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public static ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}

