package com.example.projetojava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetojava.Model.Aula;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
    Aula findByTitulo(String titulo);

}
