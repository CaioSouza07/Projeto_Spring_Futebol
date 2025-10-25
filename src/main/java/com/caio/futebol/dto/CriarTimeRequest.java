package com.caio.futebol.dto;

public record CriarTimeRequest(String nome, String cidade, String estado, String pais, int anoFundacao, String estadio, String liga) {
}
