package com.example.projetojava.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.projetojava.Model.Aula;
import com.example.projetojava.Model.Estudante;
import com.example.projetojava.Model.Professor;
import com.example.projetojava.Repository.AulaRepository;
import com.example.projetojava.Repository.EstudanteRepository;
import com.example.projetojava.Repository.ProfessorRepository;

@Controller
public class EstudanteController {

    @Autowired
    EstudanteRepository eRepository;

    @Autowired
    AulaRepository aRepository;

    @Autowired
    ProfessorRepository pRepository;

    @GetMapping("/cadastroEstudante")
    public ModelAndView cadastroEstudante() {
        ModelAndView mv = new ModelAndView("cadastroEstudante");
        ArrayList<Aula> aulas = (ArrayList<Aula>) aRepository.findAll();
        ArrayList<Professor> professores = (ArrayList<Professor>) pRepository.findAll();
        if (professores != null || aulas != null) {
            mv.addObject("aulas", aulas);
            mv.addObject("professores", professores);
        }
        return mv;
    }

    @PostMapping("/cadastroEstudante")
    public String salvarEstudante(Estudante estudante,
            @RequestParam(value = "professores", required = false) List<Integer> professorId,
            @RequestParam(value = "aulas", required = false) List<Integer> aulaId) {
        if (professorId != null && aulaId != null) {
            ArrayList<Professor> professores = new ArrayList<>();
            for (Integer id : professorId) {
                professores.add(pRepository.findById(id).get());
            }
            ArrayList<Aula> aulas = new ArrayList<>();
            for (Integer id : aulaId) {
                aulas.add(aRepository.findById(id).get());

            }

            estudante.setAulas(aulas);
            estudante.setProfessores(professores);
        }
        eRepository.save(estudante);
        return "redirect:/list" ;
    }

    @GetMapping("/list")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("list");
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes = (ArrayList<Estudante>) eRepository.findAll();
        mv.addObject("estudantes", estudantes);
        return mv;
    }

}
