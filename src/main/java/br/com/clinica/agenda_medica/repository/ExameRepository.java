package br.com.clinica.agenda_medica.repository;

import br.com.clinica.agenda_medica.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<Exame, Integer> {
}