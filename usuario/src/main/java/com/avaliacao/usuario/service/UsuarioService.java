package com.avaliacao.usuario.service;
import java.util.List;
import com.avaliacao.usuario.dto.UsuarioDto;
import com.avaliacao.usuario.dto.UsuarioDtoComJogo;

public interface UsuarioService {
    
    List<UsuarioDto> obterTodosUsuarios();
    UsuarioDtoComJogo obterPorId(String id);
    UsuarioDto cadastarUsuario(UsuarioDto usuario);
    UsuarioDto atualizarPessoa(String id, UsuarioDto usuario);
    void excluirUsuario(String id);
}
