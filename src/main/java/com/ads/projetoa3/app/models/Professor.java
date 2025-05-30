package com.ads.projetoa3.app.models;

import com.ads.projetoa3.app.enums.EnumTipoUsuario;

public class Professor extends Usuario {
   public Professor(String nome, String email, String disciplina ) {
       super(nome, email, EnumTipoUsuario.PROFESSOR);
   }

   public void adicionarFaltaAluno(Aluno aluno, int qtde, String materia){
       aluno.adicionarFalta(qtde, materia);
   }

   public void adicionarNotaAluno(Aluno aluno, double nota, String materia) {
       aluno.adicionarNota(nota, materia);
   }
}
