package com.ads.projetoa3.app;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private ArrayList<Falta> faltas = new ArrayList<>();
    private ArrayList<Nota> notas = new ArrayLIst<>();

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //metodo que fizemos para poder adicionar notas e faltas
    public void adicionarFalta(int qtde, String materia) {
        faltas.add(new Falta(qtde, materia))
    }

    public void adicionarNota(double nota, String materia) {
        notas.add(new Nota(nota, materia));
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("\nFaltas:");
        for (Falta f : faltas) {
            System.out.println("- " + f.materia + ": " + f.qtde + " faltas");
        }

        System.out.println("\nNotas:");
        for (Nota n : notas) {
            System.out.println("- " + n.materia + ": " + n.notas);
        }

    // classe interna que fizemos para faltas
    private static class Falta {
        int qtde;
        String materia;

        public Falta(int qtde, String materia) {
            this.qtde = qtde;
            this.materia = materia;
        }

}

    //classe interna que fizemos para notas
    private static class Nota {
        double nota;
        String materia;

        public Nota(double nota, String materia) {
            this.nota = nota;
            this.materia = materia;
        }
    }
}