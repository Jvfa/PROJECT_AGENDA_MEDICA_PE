package br.com.clinica.agenda_medica.service;

import br.com.clinica.agenda_medica.model.Paciente;
import br.com.clinica.agenda_medica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public Paciente save(Paciente paciente) {
        return repository.save(paciente);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Paciente findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}