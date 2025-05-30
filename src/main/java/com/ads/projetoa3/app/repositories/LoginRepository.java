package com.ads.projetoa3.app.repositories;

import com.ads.projetoa3.app.models.Professor;

public class LoginRepository {
    public static Professor login(String email, String senha) {
        Professor usuario = getUsuario(email, senha);
        if (usuario.getEmail().isEmpty()) {
            return usuario;
        }
        return null;
    }

    private static Professor getUsuario(String email, String senha) {
        String senhaProfessor = "brenoAmaLapa";
        String emailProfessor = "hanielgay@gmail.com";

        if (email == emailProfessor && senha == senhaProfessor) {
            return new Professor("Haniel Gay", "hanielgay@gmail.com");
        }

        return new Professor("", "");
    }
}
