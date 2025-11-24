package br.com.clinica.agenda_medica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinica.agenda_medica.model.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}