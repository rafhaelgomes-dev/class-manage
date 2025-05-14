package org.app.classmanage;

import org.app.classmanage.enums.EnumTipoUsuario;

public class Usuario {
    private String _nome;
    private String _ra;
    private String _senha;
    private EnumTipoUsuario _tipoUsuario;

    public Usuario(String nome, String senha, String ra) {
        this._nome = nome;
        this._senha = senha;
        this._ra = ra;
    }

    public String getNome() {
        return this._nome;
    }

    public EnumTipoUsuario getTipoUsuario() {
        return this._tipoUsuario;
    }

    public String getRa() {
        return this._ra;
    }
}
