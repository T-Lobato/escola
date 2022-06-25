package br.com.api.escola.repository;

import br.com.api.escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunoRepository extends JpaRepository<Aluno, Long> {
}
