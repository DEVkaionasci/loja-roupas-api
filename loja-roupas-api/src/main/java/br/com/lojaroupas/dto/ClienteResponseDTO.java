package br.com.lojaroupas.dto;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String email) {
}