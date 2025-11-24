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

import br.com.clinica.agenda_medica.model.Consulta;
import br.com.clinica.agenda_medica.model.Medico;
import br.com.clinica.agenda_medica.service.ConsultaService;
import br.com.clinica.agenda_medica.service.MedicoService;


@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("consulta", new Consulta());
        List<Medico> medicos = medicoService.findAll();
        model.addAttribute("medicos", medicos);
        return "consulta/formularioConsulta";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Consulta consulta) {
        consultaService.save(consulta);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Consulta> consultas = consultaService.findAll();
        model.addAttribute("consultas", consultas);
        return "consulta/listaConsulta";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        consultaService.deleteById(id);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Consulta consulta = consultaService.findById(id);
        model.addAttribute("consulta", consulta);
        List<Medico> medicos = medicoService.findAll();
        model.addAttribute("medicos", medicos);
        return "consulta/formularioConsulta";
    }
}