package br.com.clinica.agenda_medica.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clinica.agenda_medica.model.Medico;
import br.com.clinica.agenda_medica.service.MedicoService;


@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("medico", new Medico());
        return "medico/formularioMedico";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Medico medico) {
        medicoService.save(medico);
        return "redirect:/medicos/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Medico> medicos = medicoService.findAll();
        model.addAttribute("medicos", medicos);
        return "medico/listaMedico";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        medicoService.deleteById(id);
        return "redirect:/medicos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Medico medico = medicoService.findById(id);
        model.addAttribute("medico", medico);
        return "medico/formularioMedico";
    }

    @GetMapping("/agenda")
    public String agendaCompleta(Model model) {
        List<Medico> medicos = medicoService.findAll();
        model.addAttribute("medicos", medicos);
        return "agenda/agendaCompleta";
    }
}