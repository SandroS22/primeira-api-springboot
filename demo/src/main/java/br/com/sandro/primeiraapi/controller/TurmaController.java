package br.com.sandro.primeiraapi.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping(path = "/{id}")
	public Object getTurma(@PathVariable("id") UUID id) {
		Optional<Turma> turma = turmaService.findById(id);
		if (turma.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			return turma.get();
		}
	}

	@PostMapping
	public @ResponseBody Turma createTurma(@Valid Turma turma) {
		turmaService.save(turma);
		return turma;
	}

	@PutMapping
	public @ResponseBody Object updateTurma(@RequestParam(name = "id") UUID id, @Valid Turma turma) {
		Optional<Turma> turmaT = turmaService.findById(id);
		if (turmaT.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			Turma tur = turmaT.get();
			BeanUtils.copyProperties(turma, tur);
			turmaService.save(tur);
			return tur;
		}
	}

	@DeleteMapping
	public @ResponseBody Object deleteTurma(@RequestParam(name = "id") UUID id) {
		Optional<Turma> turma = turmaService.findById(id);
		if (turma.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			turmaService.delete(turma.get());
			return turma.get();
		}
	}
}
