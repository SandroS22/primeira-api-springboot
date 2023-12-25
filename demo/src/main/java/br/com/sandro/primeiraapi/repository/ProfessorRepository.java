package br.com.sandro.primeiraapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sandro.primeiraapi.model.Professor;
import br.com.sandro.primeiraapi.model.Turma;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
	final String FIND_TURMA_BY_PROFESSOR = "SELECT p FROM professor WHERE p.id = ?1";

	@Query(value = FIND_TURMA_BY_PROFESSOR, nativeQuery = true)
	List<Turma> findTurmaByProfessor(UUID id);
}
