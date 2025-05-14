package org.app.classmanage;

public class Usuario {
    private String _nome;
    private String _ra;
    private String _senha;

    public Usuario(String nome, String senha, String ra) {
        this._nome = nome;
        this._senha = senha;
        this._ra = ra;
    }

    public String getNome() {
        return this._nome;
    }

    public boolean validarSenha(String senha) {
        return this._senha.equals(senha);
    }
}
