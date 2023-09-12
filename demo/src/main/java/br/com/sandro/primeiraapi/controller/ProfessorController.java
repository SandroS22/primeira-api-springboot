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
	public Object getProfessor(@PathVariable("id") UUID id) {
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

	@PutMapping(path = "/{id}")
	public Object updateProfessor(@PathVariable("id") UUID id, @Valid Professor prof) {
		Optional<Professor> professorT = professorService.findById(id);
		if (professorT.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			Professor professorP = professorT.get();
			BeanUtils.copyProperties(prof, professorP);
			professorService.save(professorP);
			return professorP;
		}
	}

	@DeleteMapping(path = "/{id}")
	public Object deleteProfessor(@PathVariable UUID id) {
		Optional<Professor> professor = professorService.findById(id);
		if (professor.isEmpty()) {
			return HttpStatusCode.valueOf(404);
		} else {
			return professorService.delete(professor.get());
		}
	}

}
