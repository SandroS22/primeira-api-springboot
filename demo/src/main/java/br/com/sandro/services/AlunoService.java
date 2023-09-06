package br.com.sandro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sandro.model.Aluno;
import br.com.sandro.model.repositoy.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Transactional
	public Object save(@Valid Aluno aluno) {
		return alunoRepository.save(aluno);
	}
}
