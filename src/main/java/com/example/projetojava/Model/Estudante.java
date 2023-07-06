package com.example.projetojava.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String CPF;
    private String sobrenome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "estudante_professor", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
    List<Professor> professores;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "estudante_aula", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "aula_id"))
    List<Aula> aulas;

    public Estudante() {

    }

    public Estudante(int id, String nome, String CPF, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.sobrenome = sobrenome;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
}
