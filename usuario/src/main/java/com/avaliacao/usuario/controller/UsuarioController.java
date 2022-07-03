package com.avaliacao.usuario.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.usuario.dto.UsuarioDto;
import com.avaliacao.usuario.dto.UsuarioDtoComJogo;
import com.avaliacao.usuario.model.Usuario;
import com.avaliacao.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping

    public ResponseEntity<UsuarioDto> adicionarUsuario (@RequestBody @Valid UsuarioDto usuario){

        return new ResponseEntity<>(service.cadastarUsuario(usuario),HttpStatus.CREATED);    
    }
    
    @GetMapping

    public List<UsuarioDto>obterTodosUsuarios(){

       return service.obterTodosUsuarios();
    }

    @GetMapping("{id}")
    public UsuarioDtoComJogo obterPorId(@PathVariable String id) {

        return service.obterPorId(id);

    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerPessoas(@PathVariable String id) {
        service.excluirUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
    
    @PutMapping(value="/{id}")
    public ResponseEntity<UsuarioDto> atualizarPessoa(@PathVariable String id,
        @Valid @RequestBody Usuario usuario) {
        ModelMapper mapper = new ModelMapper();
        UsuarioDto dto = mapper.map(usuario, UsuarioDto.class);
        dto = service.atualizarPessoa(id, dto);

        return new ResponseEntity<>(mapper.map(dto, UsuarioDto.class), HttpStatus.OK);
    }

}
