package br.com.api.escola.service;

import br.com.api.escola.model.Aluno;
import br.com.api.escola.repository.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private IAlunoRepository iAlunoRepository;

    public Aluno salvar(Aluno aluno){
        return iAlunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos(){
        return iAlunoRepository.findAll();
    }
    public Optional<Aluno> buscarPorId(Long id){
        return iAlunoRepository.findById(id);
    }

    public void removerAlunoPorId(Long id){
        iAlunoRepository.deleteById(id);
    }

}