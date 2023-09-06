package br.com.sandro.primeiraapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.primeiraapi.model.Aluno;
import br.com.sandro.primeiraapi.services.AlunoService;
import jakarta.validation.Valid;

@RestController
public class AlunoController {

	private AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping("/alunos")
	public Iterable<Aluno> getAllAlunos() {
		return alunoService.findAll();
	}

	@PostMapping
	public @ResponseBody Aluno saveAluno(@Valid Aluno aluno) {
		alunoService.save(aluno);
		return aluno;
	}
}
