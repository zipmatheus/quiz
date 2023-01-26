package org.senai.prjquiz.controller;

import java.util.Optional;

import org.senai.prjquiz.entity.Quiz;
import org.senai.prjquiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    QuizRepository qRepository;

    @PostMapping("/")
    public @ResponseBody Integer addQuiz(@RequestBody Quiz objQuiz) {
        qRepository.save(objQuiz);
        return objQuiz.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Quiz> buscarQuiz() {
        return qRepository.findAll();
    }

    @PutMapping("/")
    public @ResponseBody Quiz atualizarQuiz(@RequestBody Quiz objQuiz) {
        qRepository.save(objQuiz);
        return objQuiz;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id) {
        qRepository.deleteById(id);
        return "Apagado";
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Quiz> localizarQuiz(@PathVariable Integer id) {
        return qRepository.findById(id);
    }

    
}