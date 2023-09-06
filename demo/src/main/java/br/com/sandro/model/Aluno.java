package br.com.sandro.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario implements Serializable {

	private static final long serialVersionUID = 4366806759458726133L;

	@Column
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
