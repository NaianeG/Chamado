package com.example.projetojava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projetojava.Model.Professor;
import com.example.projetojava.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository pRepository;

    @GetMapping("/cadastroProfessor")
    public String cadastroProfessor() {
        return "cadastroProfessor";
    }

    @PostMapping("/cadastroProfessor")
    public String salvarProfessor(Professor professor) {
        pRepository.save(professor);
        return "redirect:/cadastroProfessor";
    }

}
