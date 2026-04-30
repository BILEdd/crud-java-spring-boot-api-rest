package com.example.agendador_horarios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/*anotações lombok*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String produto;

    private String servico;

    private String profissional;

    private LocalDateTime dataHoraAgendamento;

    private String telefoneCliente ;

    private String cliente;

    private LocalDateTime dataInsercao  = LocalDateTime.now();

}
