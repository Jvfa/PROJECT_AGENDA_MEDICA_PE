package br.com.clinica.agenda_medica.repository;

import br.com.clinica.agenda_medica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}