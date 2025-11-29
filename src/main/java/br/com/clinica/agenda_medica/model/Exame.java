package br.com.clinica.agenda_medica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 500)
    private String descricao;

    // Médico responsável por este tipo de exame
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    // Lado inverso do relacionamento (opcional, mas bom para bidirecionalidade)
    @ManyToMany(mappedBy = "exames")
    private List<Paciente> pacientes;
}