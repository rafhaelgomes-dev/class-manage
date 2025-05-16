package com.ads.projetoa3.app;

import com.ads.projetoa3.app.enums.EnumTipoUsuario;

public class Professor extends Usuario {
   public Professor(String nome, String email) {
       super(nome, email, EnumTipoUsuario.PROFESSOR);
   }

   public void darFalta(Aluno aluno, int qtde, String materia){
       aluno.adicionarFalta(qtde, materia);
   }

   public void darNota(Aluno aluno, double nota, String material) {
       aluno.adicionarNota.(nota, material);
   }
}
