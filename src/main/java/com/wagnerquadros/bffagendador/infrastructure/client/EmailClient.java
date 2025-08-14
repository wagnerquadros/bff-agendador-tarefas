package com.wagnerquadros.bffagendador.infrastructure.client;

import com.wagnerquadros.bffagendador.business.dto.out.TarefasResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    Void enviarEmail(@RequestBody TarefasResponseDTO dto);
}
