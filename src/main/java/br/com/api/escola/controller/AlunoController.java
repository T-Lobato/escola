package br.com.api.escola.controller;

import br.com.api.escola.model.Aluno;
import br.com.api.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvar(aluno);
    }



}