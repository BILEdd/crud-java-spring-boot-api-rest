package com.example.agendador_horarios.controller;

import com.example.agendador_horarios.entity.Agendamento;
import com.example.agendador_horarios.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class agendamentoController {
    private final AgendamentoService agendamentoService;
    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){
        return ResponseEntity.ok().body(agendamentoService.salvarAgendamento(agendamento));
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam LocalDateTime dataHoraAgendamento,
                                                   @RequestParam String cliente){
        agendamentoService.deletarAgendamento(cliente, dataHoraAgendamento);
        return ResponseEntity.noContent().build();

    }
    @GetMapping
    public ResponseEntity<Agendamento> buscarAgendamentosDia(@RequestParam LocalDate dataHoraAgendamento){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(dataHoraAgendamento));

    }

    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamentos(@RequestBody Agendamento agendamento,@RequestParam LocalDateTime dataHoraAgendamento, @RequestParam String cliente) {

        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento,cliente,dataHoraAgendamento));
    }

}
