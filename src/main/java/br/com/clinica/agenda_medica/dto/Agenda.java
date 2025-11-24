package br.com.clinica.agenda_medica.dto;

import java.util.List;

import br.com.clinica.agenda_medica.model.Consulta;

public class Agenda {
    private String nome;
    private String especialidade;
    private List<Consulta> consultas;


    public Agenda(String nome, String especialidade, List<Consulta> Consulta) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.consultas = consultas;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    
    public List<Consulta> getConsultas() {
        return consultas;
    }
}
