package br.com.sandro.primeiraapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.sandro.primeiraapi.model.Aluno;
import br.com.sandro.primeiraapi.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class AlunoService {

	private AlunoRepository alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Transactional
	public Object save(@Valid Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Optional<Aluno> findById(UUID id) {
		return alunoRepository.findById(id);

	}
	
	public Aluno delete(Aluno aluno) {
		alunoRepository.delete(aluno);
		return aluno;
	}
}
