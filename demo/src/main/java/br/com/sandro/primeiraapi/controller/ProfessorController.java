package br.com.sandro.primeiraapi.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.primeiraapi.model.Professor;
import br.com.sandro.primeiraapi.services.ProfessorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@GetMapping
	public Iterable<Professor> getAllProfessor() {
		return professorService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Object getProfessor(@PathVariable UUID id) {
		Optional<Professor> professor = professorService.findById(id);
		if (professor.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			return professor.get();
		}
	}

	@PostMapping
	public Professor createProfessor(@Valid Professor professor) {
		professorService.save(professor);
		return professor;
	}

}
