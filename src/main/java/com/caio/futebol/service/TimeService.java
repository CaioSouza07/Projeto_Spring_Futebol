package com.caio.futebol.service;

import com.caio.futebol.dto.CriarTimeRequest;
import com.caio.futebol.dto.EditarTimeRequest;
import com.caio.futebol.entity.Time;
import com.caio.futebol.repository.TimeRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // pego pelo id
    public Optional<Time> findById(Long id){
        return timeRepository.findById(id);
    }

    // deletar tudo (PERIGOSO)
    public void deleteAll(){
        timeRepository.deleteAll();
    }

    // deletar pelo id
    public void deleteById(Long id){
        timeRepository.deleteById(id);
    }

    // criar o time
    public Time criar(CriarTimeRequest request){

        StringBuilder builder = new StringBuilder();

        // aqui vou validar se ta algum campo vazio, e vai concatenando, caso tenha algum nois vai lançar exceção
        if(Strings.isBlank(request.nome())){
            builder.append("Favor informar o nome!").append("\n");
        }
        if(Strings.isBlank(request.cidade())){
            builder.append("Favor informar a cidade!").append("\n");
        }
        if(Strings.isBlank(request.estado())){
            builder.append("Favor informar o estado!").append("\n");
        }
        if(Strings.isBlank(request.pais())){
            builder.append("Favor informar o país!").append("\n");
        }
        if(request.anoFundacao() == 0){
            builder.append("Favor informar o ano de fundação!").append("\n");
        }
        if(Strings.isBlank(request.estadio())){
            builder.append("Favor informar o estádio!").append("\n");
        }
        if(Strings.isBlank(request.liga())){
            builder.append("Favor informar a liga atual!").append("\n");
        }
        if(Strings.isBlank(request.emblema())){
            builder.append("Favor informar o link do emblema!").append("\n");
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
        time.setEmblema(request.emblema());

        return timeRepository.save(time);

    }

    // editar o time
    public Time editar(EditarTimeRequest request){

        StringBuilder builder = new StringBuilder();

        // aqui vou validar se ta algum campo vazio, e vai concatenando, caso tenha algum nois vai lançar exceção
        if(Strings.isBlank(request.nome())){
            builder.append("Favor informar o nome!").append("\n");
        }
        if(Strings.isBlank(request.cidade())){
            builder.append("Favor informar a cidade!").append("\n");
        }
        if(Strings.isBlank(request.estado())){
            builder.append("Favor informar o estado!").append("\n");
        }
        if(Strings.isBlank(request.pais())){
            builder.append("Favor informar o país!").append("\n");
        }
        if(request.anoFundacao() == 0){
            builder.append("Favor informar o ano de fundação!").append("\n");
        }
        if(Strings.isBlank(request.estadio())){
            builder.append("Favor informar o estádio!").append("\n");
        }
        if(Strings.isBlank(request.liga())){
            builder.append("Favor informar a liga atual!").append("\n");
        }
        if(Strings.isBlank(request.emblema())){
            builder.append("Favor informar o link do emblema!").append("\n");
        }

        if (!builder.isEmpty()){
            throw new RuntimeException(builder.toString());
        }

        var time = findById(request.id()).orElseThrow();
        time.setNome(request.nome());
        time.setCidade(request.cidade());
        time.setEstado(request.estado());
        time.setPais(request.pais());
        time.setEstadio(request.estadio());
        time.setAnoFundacao(request.anoFundacao());
        time.setLiga(request.liga());
        time.setEmblema(request.emblema());

        return timeRepository.save(time);

    }



}
