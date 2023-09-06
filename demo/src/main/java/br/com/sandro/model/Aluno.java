package br.com.sandro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario {

	private Turma turma;

	public Aluno(String nome, String cpf) {
		super(nome, cpf);
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
