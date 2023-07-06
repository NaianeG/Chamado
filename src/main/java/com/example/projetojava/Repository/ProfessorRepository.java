package com.example.projetojava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetojava.Model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    Professor findByNome(String nome);

}