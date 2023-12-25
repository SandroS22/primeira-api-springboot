package br.com.sandro.primeiraapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 8709979822871602747L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotBlank
	private String nome;

	@NotBlank
	private String periodo;

	@Transient
	List<Aluno> alunos = new ArrayList<Aluno>();

	@Transient
	List<Professor> professores = new ArrayList<Professor>();

	public UUID getId() {
		return id;
	}

	public Turma(String nome, String periodo) {
		this.nome = nome;
		this.periodo = periodo;
	}

	public Turma() {

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
