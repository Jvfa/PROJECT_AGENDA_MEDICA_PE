package br.com.clinica.agenda_medica.service;

import br.com.clinica.agenda_medica.model.Exame;
import br.com.clinica.agenda_medica.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExameService {
    @Autowired
    private ExameRepository repository;

    public List<Exame> findAll() {
        return repository.findAll();
    }

    public Exame save(Exame exame) {
        return repository.save(exame);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Exame findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}