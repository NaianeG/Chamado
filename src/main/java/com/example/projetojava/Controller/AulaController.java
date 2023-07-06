package com.example.projetojava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.projetojava.Model.Aula;
import com.example.projetojava.Repository.AulaRepository;

@Controller
public class AulaController {

    @Autowired
    AulaRepository aRepository;

    @GetMapping("/cadastroAula")
    public String cadastroAula() {
        return "cadastroAula";
    }

    @PostMapping("/cadastroAula")
    public String salvarAula(Aula aula) {
        aRepository.save(aula);
        return "redirect:/cadastroAula";
    }

}
