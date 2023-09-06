package br.com.sandro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Usuario implements Serializable {

	private static final long serialVersionUID = 6857789213700600705L;

	List<Turma> turmas = new ArrayList<>();

	public Professor(String nome, String cpf) {
		super(nome, cpf);
	}

}
