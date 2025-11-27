package br.com.clinica.agenda_medica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    // Relacionamento N:N
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "paciente_exames",
        joinColumns = @JoinColumn(name = "paciente_id"),
        inverseJoinColumns = @JoinColumn(name = "exame_id")
    )
    private List<Exame> exames;
}