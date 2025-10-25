package com.caio.futebol.service;

import com.caio.futebol.entity.Time;
import com.caio.futebol.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository){
        this.timeRepository = timeRepository;
    }

    public List<Time> findAll(){
        return timeRepository.findAll();
    }

}
