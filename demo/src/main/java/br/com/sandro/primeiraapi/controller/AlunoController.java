package br.com.sandro.primeiraapi.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.primeiraapi.model.Aluno;
import br.com.sandro.primeiraapi.services.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	private AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping
	public Iterable<Aluno> getAllAlunos() {
		return alunoService.findAll();
	}

	@PostMapping
	public @ResponseBody Aluno saveAluno(@Valid Aluno aluno) {
		alunoService.save(aluno);
		return aluno;
	}

	@PutMapping
	public @ResponseBody Aluno updateAluno(@Valid Aluno aluno) {
		alunoService.save(aluno);
		return aluno;
	}

	@DeleteMapping(path = "/alunos/{id}")
	public @ResponseBody Object deleteAluno(@PathVariable(name = "id") UUID id) {
		Optional<Aluno> alunoOp = alunoService.findById(id);
		if(alunoOp == null) {
			return HttpStatusCode.valueOf(400);
		} else {
			alunoService.delete(alunoOp.get());
			return alunoOp;
		}
	}
}
