package com.ads.projetoa3.app;

import com.ads.projetoa3.app.enums.EnumTipoUsuario;

public class Professor extends Usuario {
   public Professor(String nome, String email) {
       super(nome, email, EnumTipoUsuario.PROFESSOR);
   }
}
