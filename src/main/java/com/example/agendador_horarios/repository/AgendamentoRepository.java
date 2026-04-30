package com.example.agendador_horarios.repository;

import com.example.agendador_horarios.entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    Agendamento findByServicoAndDataHoraAgendamentoBeteween(String Servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);
    @Transactional
    void deleteByClienteAndDataHoraAgendamento(String cliente, LocalDateTime dataHoraAgendamento);

    Agendamento findByDataHoraAgendamento(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);
    Agendamento findByClienteAndDataHoraAgendamento(String cliente, LocalDateTime dataHoraAgendamento);
}

