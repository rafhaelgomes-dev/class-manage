package com.ads.projetoa3.app;

import com.ads.projetoa3.app.enums.EnumTipoUsuario;

public class Professor extends Usuario {
   public Professor(String nome, String email, String senha) {
       super(nome, email, senha, EnumTipoUsuario.PROFESSOR);
   }
}
