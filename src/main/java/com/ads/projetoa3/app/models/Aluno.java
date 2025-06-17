package com.ads.projetoa3.app.models;

import com.ads.projetoa3.app.enums.EnumTipoUsuario;

import java.util.ArrayList;

public class Aluno extends Usuario {
    private String _matricula;
    private String _curso;
    private ArrayList<Falta> _faltas = new ArrayList<>();
    private ArrayList<Nota> _notas = new ArrayList<>();

    public Aluno(String nome, String email, String matricula, String curso) {
        super(nome, email, EnumTipoUsuario.ALUNO);
        this._matricula = matricula;
        this._curso = curso;
    }
    public Aluno() {
    }
    public String getNome() {
        return this._nome;
    }

    public String getEmail() {
        return this._email;
    }

    public String getCurso() {
        return this._curso;
    }

    public String getMatricula() {
        return this._matricula;
    }

    public void setCurso(String curso) {
        this._curso = curso;
    }

    public void setMatricula(String matricula) {
        this._matricula = matricula;
    }

    public void setNome(String nome) {
        this._nome = nome;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public void adicionarFalta(int qtde, String materia) {
        this._faltas.add(new Falta(qtde, materia));
    }

    public void adicionarNota(double nota, String materia) {
        this._notas.add(new Nota(nota, materia));
    }
}