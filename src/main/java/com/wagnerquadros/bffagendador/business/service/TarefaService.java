package com.wagnerquadros.bffagendador.business.service;


import com.wagnerquadros.bffagendador.business.dto.in.TarefasResquestDTO;
import com.wagnerquadros.bffagendador.business.dto.out.TarefasResponseDTO;
import com.wagnerquadros.bffagendador.business.enums.StatusNotificacaoEnum;
import com.wagnerquadros.bffagendador.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasClient tarefasClient;

    public TarefasResponseDTO gravarTarefa(String token, TarefasResquestDTO dto){
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasResponseDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal,
                                                                    String token){
        return tarefasClient.buscarListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasResponseDTO> buscarTarefasPorEmail(String token){
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token){
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasResponseDTO alteraStatus(StatusNotificacaoEnum status, String id, String token){
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasResponseDTO updateTarefas(TarefasResquestDTO dto, String id, String token){
        return  tarefasClient.updateTaredfas(dto, id, token);
    }
}
