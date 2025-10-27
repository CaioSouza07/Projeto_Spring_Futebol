package com.caio.futebol.dto;

public record EditarTimeRequest(Long id, String nome, String cidade, String estado, String pais, Integer anoFundacao, String estadio, String liga, String emblema) {
}
