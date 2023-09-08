package br.com.sandro.primeiraapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.primeiraapi.model.Turma;
import br.com.sandro.primeiraapi.services.TurmaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@GetMapping
	public Iterable<Turma> getAllTurmas() {
		return turmaService.findAll();
	}

	@PostMapping
	public @ResponseBody Turma createTurma(@Valid Turma turma) {
		turmaService.save(turma);
		return turma;
	}

	@PutMapping
	public @ResponseBody Turma updateTurma(@Valid Turma turma) {
		turmaService.save(turma);
		return turma;
	}
}
