package com.example.projetojava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetojava.Model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

}
