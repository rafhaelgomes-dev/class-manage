package com.ads.projetoa3.app.models;

public class Disciplina {
    private String _nome;
    private String _codigo;
    private String _cargaHoraria;
    private String _descricao;

    public Disciplina(String _nome, String _codigo, String _cargaHoraria, String _descricao) {
        this._nome = _nome;
        this._codigo = _codigo;
        this._cargaHoraria = _cargaHoraria;
        this._descricao = _descricao;
    }

    public String get_nome() {
        return _nome;
    }

    public void set_nome(String _nome) {
        this._nome = _nome;
    }

    public String get_codigo() {
        return _codigo;
    }

    public void set_codigo(String _codigo) {
        this._codigo = _codigo;
    }

    public String get_cargaHoraria() {
        return _cargaHoraria;
    }

    public void set_cargaHoraria(String _cargaHoraria) {
        this._cargaHoraria = _cargaHoraria;
    }

    public String get_descricao() {
        return _descricao;
    }

    public void set_descricao(String _descricao) {
        this._descricao = _descricao;
    }
}

