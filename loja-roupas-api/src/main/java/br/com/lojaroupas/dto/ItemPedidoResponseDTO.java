package br.com.lojaroupas.dto;

import java.math.BigDecimal;

public record ItemPedidoResponseDTO(
        Long produtoId,
        String nomeProduto,
        int quantidade,
        BigDecimal precoUnitario) {
}
