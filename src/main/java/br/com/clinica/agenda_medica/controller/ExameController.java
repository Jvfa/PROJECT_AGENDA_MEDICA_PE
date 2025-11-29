package br.com.clinica.agenda_medica.controller;

import br.com.clinica.agenda_medica.model.Exame;
import br.com.clinica.agenda_medica.service.ExameService;
import br.com.clinica.agenda_medica.service.MedicoService; // Importar
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exames")
public class ExameController {

    @Autowired private ExameService service;
    @Autowired private MedicoService medicoService; // Injetar

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("exames", service.findAll());
        return "exame/listaExame";
    }

    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("exame", new Exame());
        model.addAttribute("medicos", medicoService.findAll()); // Listar médicos
        return "exame/formularioExame";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Exame exame) {
        service.save(exame);
        return "redirect:/exames/listar";
    }
}