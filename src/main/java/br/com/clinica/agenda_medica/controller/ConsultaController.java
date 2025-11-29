package br.com.clinica.agenda_medica.controller;

import br.com.clinica.agenda_medica.model.Consulta;
import br.com.clinica.agenda_medica.service.ConsultaService;
import br.com.clinica.agenda_medica.service.ExameService; // Importar
import br.com.clinica.agenda_medica.service.MedicoService;
import br.com.clinica.agenda_medica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired private ConsultaService consultaService;
    @Autowired private MedicoService medicoService;
    @Autowired private PacienteService pacienteService;
    @Autowired private ExameService exameService; // Injetar ExameService

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("medicos", medicoService.findAll());
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("listaExames", exameService.findAll()); // Enviar exames para a tela
        return "consulta/formularioConsulta";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Consulta consulta) {
        consultaService.save(consulta);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("consultas", consultaService.findAll());
        return "consulta/listaConsulta";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        consultaService.deleteById(id);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        model.addAttribute("consulta", consultaService.findById(id));
        model.addAttribute("medicos", medicoService.findAll());
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("listaExames", exameService.findAll()); // Enviar exames na edição também
        return "consulta/formularioConsulta";
    }
}