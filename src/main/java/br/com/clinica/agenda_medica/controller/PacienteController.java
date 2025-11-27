package br.com.clinica.agenda_medica.controller;

import br.com.clinica.agenda_medica.model.Paciente;
import br.com.clinica.agenda_medica.service.ExameService;
import br.com.clinica.agenda_medica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private ExameService exameService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteService.findAll());
        return "paciente/listaPaciente";
    }

    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("paciente", new Paciente());
        // Enviamos a lista de todos exames para o usuário selecionar (checkboxes)
        model.addAttribute("listaExames", exameService.findAll());
        return "paciente/formularioPaciente";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("paciente", pacienteService.findById(id));
        model.addAttribute("listaExames", exameService.findAll());
        return "paciente/formularioPaciente";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes/listar";
    }
}