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
public class Aula { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;

    @ManyToMany(mappedBy = "aulas", fetch = FetchType.EAGER)
    List<Estudante> estudantes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "aula_professor", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
    List<Professor> professores;

    @ManyToMany(mappedBy = "aulas", fetch = FetchType.EAGER)
    List<Professor> professores1;

    public Aula() {

    }

    public Aula(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

}
