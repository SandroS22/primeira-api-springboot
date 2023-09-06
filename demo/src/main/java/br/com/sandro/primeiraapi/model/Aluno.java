package br.com.sandro.primeiraapi.model;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 4366806759458726133L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank
	private String nome;

	@NotBlank
	@UniqueElements
	private String cpf;

	private UUID turma;

	public Aluno(@Valid String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Aluno() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public UUID getTurma() {
		return turma;
	}

	public void setTurma(UUID turma) {
		this.turma = turma;
	}

	public UUID getId() {
		return id;
	}

}
