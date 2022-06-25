package br.com.api.escola.service;

import br.com.api.escola.model.Aluno;
import br.com.api.escola.repository.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private IAlunoRepository iAlunoRepository;

    public Aluno salvar(Aluno aluno){
        return iAlunoRepository.save(aluno);
    }


}