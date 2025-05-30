package com.ads.projetoa3.app.repositories;

import com.ads.projetoa3.app.models.Professor;

public class LoginRepository {
    public static Professor login(String email, String senha) {
        Professor usuario = getUsuario(email, senha);
        if (usuario != null) {
            return usuario;
        }
        return null;
    }

    private static Professor getUsuario(String email, String senha) {
        String senhaProfessor = "123456";
        String emailProfessor = "rafhael@gmai.com";

        if (email.equals(emailProfessor)  && senha.equals(senhaProfessor)) {
            return new Professor("Rafhael", "rafhael@gmail.com", "Java");
        }

        return null;
    }
}
