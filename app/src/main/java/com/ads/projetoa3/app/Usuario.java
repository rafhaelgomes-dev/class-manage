package com.ads.projetoa3.app;

import com.ads.projetoa3.app.enums.EnumTipoUsuario;

public class Usuario {
    private String _nome;
    private String _email;

    private EnumTipoUsuario _tipoUsuario;

    public Usuario(String nome, String _email, EnumTipoUsuario tipoUsuario) {
        this._nome = nome;
        this._email = _email;
        this._tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return this._nome;
    }

    public EnumTipoUsuario getTipoUsuario() {
        return this._tipoUsuario;
    }

    public String registroAcademico() {
        return this._email;
    }
}