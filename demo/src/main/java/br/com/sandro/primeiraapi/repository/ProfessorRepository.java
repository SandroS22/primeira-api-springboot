package br.com.sandro.primeiraapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sandro.primeiraapi.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {

}
