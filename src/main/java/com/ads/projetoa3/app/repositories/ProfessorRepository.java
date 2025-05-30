package com.ads.projetoa3.app.repositories;

import com.ads.projetoa3.app.models.Professor;
import java.util.ArrayList;

public class ProfessorRepository {

    protected static ArrayList <Professor> professores = new ArrayList<>();

    public static void saveProfessor(Professor professor, String senha) {
        professores.add(professor);
        System.out.println(senha);
    }

    public static ArrayList<Professor> getProfessores() {
        return professores;
    }
 }
