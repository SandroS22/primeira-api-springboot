package br.com.sandro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 8709979822871602747L;

	@Id
	private UUID id;

	@Column
	private String nome;

	@Column
	private String periodo;

	List<Aluno> alunos = new ArrayList<Aluno>();

	List<Professor> professores = new ArrayList<Professor>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Turma(String nome, String periodo) {
		this.nome = nome;
		this.periodo = periodo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
