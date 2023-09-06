package br.com.sandro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.model.Aluno;
import br.com.sandro.services.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping
	public Iterable<Aluno> getAllAlunos() {
		return alunoService.findAll();
	}

	@PostMapping
	public @ResponseBody Aluno saveAluno(@Valid Aluno aluno) {
		alunoService.save(aluno);
		return aluno;
	}
}
