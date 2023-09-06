package br.com.sandro.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Usuario {

	List<Turma> turmas = new ArrayList<>();

	public Professor(String nome, String cpf) {
		super(nome, cpf);
	}

}
