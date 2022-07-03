package com.avaliacao.usuario.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.usuario.client.JogoClient;
import com.avaliacao.usuario.client.JogoFeign;
import com.avaliacao.usuario.dto.UsuarioDto;
import com.avaliacao.usuario.dto.UsuarioDtoComJogo;
import com.avaliacao.usuario.model.Usuario;
import com.avaliacao.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    UsuarioRepository repository;

    @Autowired
    JogoFeign feignClient;

    @Override
    public List<UsuarioDto> obterTodosUsuarios() {

        List<Usuario> obterUsuarios = repository.findAll();
        
       return obterUsuarios.stream()
       .map(u->mapper.map(u, UsuarioDto.class))
       .collect(Collectors.toList());
    }

    @Override
    public UsuarioDtoComJogo obterPorId(String id) {

        Optional<Usuario> usuarioBusca = repository.findById(id);

        if(usuarioBusca.isPresent()){

           UsuarioDtoComJogo usuario = mapper.map(usuarioBusca.get(), UsuarioDtoComJogo.class);

           JogoClient jogo = feignClient.obterJogoPorId(usuarioBusca.get().getJogoId());


           usuario.setJogoComDetalhes(jogo);

           return usuario;

        }

        return null;
        
    }

    @Override
    public UsuarioDto cadastarUsuario(UsuarioDto usuario) {
        
        Usuario cadastarUsuario = mapper.map(usuario, Usuario.class);

        repository.save(cadastarUsuario);

       return mapper.map(cadastarUsuario, UsuarioDto.class);
    }

    @Override
    public void excluirUsuario(String id) {
     repository.deleteById(id);
     }

     @Override
     public UsuarioDto atualizarPessoa(String id, UsuarioDto usuario) {
         usuario.setId(id);
         return salvarUsuario(usuario);
     }
 
     private UsuarioDto salvarUsuario(UsuarioDto usuarioDto) {
         ModelMapper mapper = new ModelMapper();
         Usuario usuarioEntidade = mapper.map(usuarioDto, Usuario.class);
         usuarioEntidade = repository.save(usuarioEntidade);
 
         return mapper.map(usuarioEntidade, UsuarioDto.class);
     }
    
}
