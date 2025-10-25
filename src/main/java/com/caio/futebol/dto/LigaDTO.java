package com.caio.futebol.dto;

import com.caio.futebol.entity.Time;

import java.util.List;

public record LigaDTO(String nome, List<Time> times) {
}
