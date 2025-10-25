package com.caio.futebol.service;

import com.caio.futebol.dto.CriarTimeRequest;
import com.caio.futebol.entity.Time;
import com.caio.futebol.repository.TimeRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository){
        this.timeRepository = timeRepository;
    }

    // pegar tudo
    public List<Time> findAll(){
        return timeRepository.findAll();
    }

    // deletar tudo (PERIGOSO)
    public void deleteAll(){
        timeRepository.deleteAll();
    }

    // criar o time
    public Time criar(CriarTimeRequest request){

        StringBuilder builder = new StringBuilder();

        // aqui vou validar se ta algum campo vazio, e vai concatenando, caso tenha algum nois vai lançar exceção
        if(Strings.isBlank(request.nome())){
            builder.append("Favor informar o nome!");
        }
        if(Strings.isBlank(request.cidade())){
            builder.append("Favor informar a cidade!");
        }
        if(Strings.isBlank(request.estado())){
            builder.append("Favor informar o estado!");
        }
        if(Strings.isBlank(request.pais())){
            builder.append("Favor informar o país!");
        }
        if(request.anoFundacao() == 0){
            builder.append("Favor informar o ano de fundação!");
        }
        if(Strings.isBlank(request.estadio())){
            builder.append("Favor informar o estádio!");
        }
        if(Strings.isBlank(request.liga())){
            builder.append("Favor informar a liga atual!");
        }

        if (!builder.isEmpty()){
            throw new RuntimeException(builder.toString());
        }

        var time = new Time();
        time.setNome(request.nome());
        time.setCidade(request.cidade());
        time.setEstado(request.estado());
        time.setPais(request.pais());
        time.setEstadio(request.estadio());
        time.setAnoFundacao(request.anoFundacao());
        time.setLiga(request.liga());

        return timeRepository.save(time);

    }



}
