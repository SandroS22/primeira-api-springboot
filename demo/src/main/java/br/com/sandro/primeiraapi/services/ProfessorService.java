package br.com.sandro.primeiraapi.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sandro.primeiraapi.model.Professor;
import br.com.sandro.primeiraapi.repository.ProfessorRepository;
import jakarta.validation.Valid;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public Iterable<Professor> findAll() {
		return professorRepository.findAll();
	}

	public Optional<Professor> findById(UUID id) {
		return professorRepository.findById(id);
	}

	public Professor save(@Valid Professor professor) {
		return professorRepository.save(professor);

	}

	public Object delete(Professor professor) {
		professorRepository.delete(professor);
		return professor;
	}
}
