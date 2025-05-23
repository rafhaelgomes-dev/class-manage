package com.ads.projetoa3.app.models;

import com.ads.projetoa3.app.enums.EnumTipoUsuario;

public class Usuario {
    protected String _nome;
    protected String _email;

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

    public String getEmail() {
        return this._email;
    }
}