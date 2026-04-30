package com.example.agendador_horarios.services;

import com.example.agendador_horarios.entity.Agendamento;
import com.example.agendador_horarios.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor /*injeção de dependencia, injetar tipo o repository*/
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    public Agendamento salvarAgendamento(Agendamento agendamento) {
        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);/*deixando claro que e de uma em uma hora, não permitindo tal horario*/

        Agendamento agendados  = agendamentoRepository.findByServicoAndDataHoraAgendamentoBeteween(agendamento.getServico(),
                horaAgendamento,horaFim);
        
        if(Objects.nonNull(agendados)){
            throw new RuntimeException("horario ja preenchido");
        }
        return agendamentoRepository.save(agendamento);
        
    }
    public void deletarAgendamento(String cliente, LocalDateTime horaAgendamento) {
        agendamentoRepository.deleteByClienteAndDataHoraAgendamento(cliente,horaAgendamento);

    }
    public Agendamento buscarAgendamentosDia(LocalDate data){
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime horaFinalDia = data.atTime(23, 59, 59);
        return agendamentoRepository.findByDataHoraAgendamento(primeiraHoraDia,horaFinalDia);
    }
    public Agendamento alterarAgendamento(Agendamento agendamento, String cliente, LocalDateTime dataHoraAgendamento) {
        Agendamento agenda = agendamentoRepository.findByClienteAndDataHoraAgendamento(cliente,dataHoraAgendamento);
        if(Objects.nonNull(agenda)){
            throw new RuntimeException("horario não está preenchido chefe");
        }
        agendamento.setId(agendamento.getId());
        return agendamentoRepository.save(agendamento);

    }
}
