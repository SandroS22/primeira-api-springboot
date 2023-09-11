package br.com.sandro.primeiraapi.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(path = "/{id}")
	public Object getAluno(@PathVariable("id") UUID id) {
		Optional<Aluno> aluno = alunoService.findById(id);
		if (aluno.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			return aluno.get();
		}
	}

	@PostMapping
	public @ResponseBody Aluno createAluno(@Valid Aluno aluno) {
		alunoService.save(aluno);
		return aluno;
	}

	@PutMapping
	public @ResponseBody Object updateAluno(@RequestParam(name = "id") UUID id, @Valid Aluno aluno) {
		Optional<Aluno> alunoB = alunoService.findById(id);
		if (alunoB.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			Aluno al = alunoB.get();
			BeanUtils.copyProperties(aluno, al);
			alunoService.save(al);
			return al;
		}
	}

	@DeleteMapping
	public @ResponseBody Object deleteAluno(@RequestParam(name = "id") UUID id) {
		Optional<Aluno> alunoOp = alunoService.findById(id);
		if (alunoOp.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			alunoService.delete(alunoOp.get());
			return alunoOp;
		}
	}
}
