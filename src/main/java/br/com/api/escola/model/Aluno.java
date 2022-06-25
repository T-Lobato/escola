package br.com.api.escola.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;
    private char sexo;

    public Aluno(String nome, Integer idade, char sexo){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Aluno(){
    }

}