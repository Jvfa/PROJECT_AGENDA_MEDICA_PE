package br.com.clinica.agenda_medica.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinica.agenda_medica.model.Medico;
import br.com.clinica.agenda_medica.repository.MedicoRepository;


@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public void deleteById(Integer id) {
        medicoRepository.deleteById(id);
    }

    public Medico findById(Integer id) {
        return medicoRepository.findById(id).orElse(null);
    }
}
