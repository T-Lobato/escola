package br.com.api.escola.controller;

import br.com.api.escola.model.Aluno;
import br.com.api.escola.service.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvar(aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarAlunos(){
        return alunoService.listarAlunos();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno buscarPorId(@PathVariable("id") Long id){
        return alunoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno(a) não encontrado(a)"));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerAluno(@PathVariable("id") Long id){
        alunoService.buscarPorId(id)
                .map(aluno -> {
                    alunoService.removerAlunoPorId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarAluno(@RequestBody Aluno alunoAlterado, @PathVariable("id") Long id){
        alunoService.buscarPorId(id)
                .map(alunoBase -> {
                    modelMapper.map(alunoAlterado, alunoBase);
                    alunoService.salvar(alunoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
    }
}