package com.avaliacao.steam.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.steam.dto.JogoDto;
import com.avaliacao.steam.model.Jogo;
import com.avaliacao.steam.repository.JogoRepository;

@Service
public class JogoServiceImpl implements JogoService {
    
    ModelMapper mapper = new ModelMapper();

    @Autowired
    JogoRepository repository;

    @Override
    public List<JogoDto> obterTodosJogos() {

        List<Jogo> jogos = repository.findAll();

        return jogos.stream()
        .map(j-> mapper.map(j,JogoDto.class ))
        .collect(Collectors.toList());
    }

    @Override
    public JogoDto obterPorId(String id) {
        Optional<Jogo> jogo = repository.findById(id);

        if(jogo.isPresent()){
            return mapper.map(jogo.get(), JogoDto.class);
        }
        return null;
    }

    @Override
    public List<JogoDto> obterPorEstiloJogo(String estiloJogo) {
       List<Jogo> jogoPorEstilo = repository.findByEstiloJogo(estiloJogo);

        if(jogoPorEstilo.isEmpty()){
            return null;
        }

        return jogoPorEstilo.stream()
        .map(j-> mapper.map(j, JogoDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public JogoDto cadastarJogo(JogoDto jogo) {
       Jogo adiconarJogo = mapper.map(jogo, Jogo.class);

       repository.save(adiconarJogo);

       return mapper.map(adiconarJogo, JogoDto.class);
    }

    @Override
    public void excluirJogo(String id) {
       repository.deleteById(id);
        
    }
   
}
