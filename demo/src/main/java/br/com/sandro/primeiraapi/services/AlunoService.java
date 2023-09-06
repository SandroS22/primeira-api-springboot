package br.com.sandro.primeiraapi.services;

import java.util.List;

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
}
