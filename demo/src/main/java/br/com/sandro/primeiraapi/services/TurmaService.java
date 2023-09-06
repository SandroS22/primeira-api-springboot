package br.com.sandro.primeiraapi.services;

import java.util.List;

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
}
