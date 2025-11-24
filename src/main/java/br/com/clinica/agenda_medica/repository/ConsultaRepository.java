package br.com.clinica.agenda_medica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.clinica.agenda_medica.model.Consulta;


public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}