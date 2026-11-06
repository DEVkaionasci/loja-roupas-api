package br.com.lojaroupas.dto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        String tamanho,
        int estoque) {
}
