package com.wagnerquadros.bffagendador.business.service;

import com.wagnerquadros.bffagendador.business.dto.out.TarefasResponseDTO;
import com.wagnerquadros.bffagendador.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasResponseDTO dto) {
        emailClient.enviarEmail(dto);
    }
}
