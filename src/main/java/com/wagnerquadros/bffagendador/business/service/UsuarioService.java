package com.wagnerquadros.bffagendador.business.service;


import com.wagnerquadros.bffagendador.business.dto.in.EnderecoRequestDTO;
import com.wagnerquadros.bffagendador.business.dto.in.LoginRequestDTO;
import com.wagnerquadros.bffagendador.business.dto.in.TelefoneRequestDTO;
import com.wagnerquadros.bffagendador.business.dto.in.UsuarioRequestDTO;
import com.wagnerquadros.bffagendador.business.dto.out.EnderecoResponseDTO;
import com.wagnerquadros.bffagendador.business.dto.out.TelefoneResponseDTO;
import com.wagnerquadros.bffagendador.business.dto.out.UsuarioResponseDTO;
import com.wagnerquadros.bffagendador.business.dto.out.ViaCepDTOResponse;
import com.wagnerquadros.bffagendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioResponseDTO salvaUsuario(UsuarioRequestDTO usuarioDTO){
        return client.salvarUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO loginDTO){
        return client.login(loginDTO);
    }

    public UsuarioResponseDTO buscarUsuarioPorEmail(String email, String token) {
        return client.buscarUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaPorEmail(email, token);
    }

    public UsuarioResponseDTO atualizaDadosUsuario(String token, UsuarioRequestDTO dto){
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoResponseDTO atualizaEndereco(EnderecoRequestDTO enderecoDTO, Long idEndereco, String token){
                return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneResponseDTO atualizaTelefone(Long idTelefone, TelefoneRequestDTO telefoneDTO, String token){
        return client.atualizaTelegone(telefoneDTO, idTelefone, token);
    }

    public EnderecoResponseDTO cadastraEndereco(String token, EnderecoRequestDTO enderecoDTO){
        return client.cadastraEndereco(enderecoDTO, token);
    }

    public TelefoneResponseDTO cadastraTelefone(String token, TelefoneRequestDTO telefoneDTO){
        return client.cadastraTelefone(telefoneDTO, token);
    }

    public ViaCepDTOResponse buscarEnderecoPorCep(String cep){
        return client.buscarDadosCep(cep);
    }

}
