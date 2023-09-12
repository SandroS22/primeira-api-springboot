package br.com.sandro.primeiraapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sandro.primeiraapi.model.Turma;
import br.com.sandro.primeiraapi.repository.TurmaRepository;
import jakarta.validation.Valid;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public List<Turma> findAll() {
		return turmaRepository.findAll();

	}

	public Turma save(@Valid Turma turma) {
		return turmaRepository.save(turma);

	}

	public Optional<Turma> findById(UUID id) {
		return turmaRepository.findById(id);
	}

	public Turma delete(Turma turma) {
		turmaRepository.delete(turma);
		return turma;
	}
}
