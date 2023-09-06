package br.com.sandro.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandro.model.Aluno;
import br.com.sandro.model.repositoy.AlunoRepository;
import br.com.sandro.services.AlunoService;

@RestController
public class AlunoController {

	@GetMapping
	public ResponseEntity<List<Aluno>> getAllAlunos() {
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(AlunoService.findAll());
	}
}
