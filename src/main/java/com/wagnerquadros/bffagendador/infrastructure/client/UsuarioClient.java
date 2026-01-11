package com.wagnerquadros.bffagendador.infrastructure.client;


import com.wagnerquadros.bffagendador.business.dto.in.EnderecoRequestDTO;
import com.wagnerquadros.bffagendador.business.dto.in.LoginRequestDTO;
import com.wagnerquadros.bffagendador.business.dto.in.TelefoneRequestDTO;
import com.wagnerquadros.bffagendador.business.dto.in.UsuarioRequestDTO;
import com.wagnerquadros.bffagendador.business.dto.out.EnderecoResponseDTO;
import com.wagnerquadros.bffagendador.business.dto.out.TelefoneResponseDTO;
import com.wagnerquadros.bffagendador.business.dto.out.UsuarioResponseDTO;
import com.wagnerquadros.bffagendador.business.dto.out.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioResponseDTO buscarUsuarioPorEmail (@RequestParam("email") String email,
                                              @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioResponseDTO salvarUsuario(@RequestBody UsuarioRequestDTO usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);

    @DeleteMapping("/{email}")
    Void deletaPorEmail (@PathVariable String email,
                         @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioResponseDTO atualizaDadosUsuario(@RequestBody UsuarioRequestDTO dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoResponseDTO atualizaEndereco(@RequestBody EnderecoRequestDTO enderecoDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneResponseDTO atualizaTelegone(@RequestBody TelefoneRequestDTO telefoneDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoResponseDTO cadastraEndereco(@RequestBody EnderecoRequestDTO enderecoDTO,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneResponseDTO cadastraTelefone(@RequestBody TelefoneRequestDTO telefoneDTO,
                                         @RequestHeader("Authorization") String token);

    @GetMapping("/endereco/{cep}")
    ViaCepDTOResponse buscarDadosCep(@PathVariable("cep") String cep);
}
