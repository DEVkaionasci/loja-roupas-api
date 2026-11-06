package br.com.lojaroupas.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ItemPedidoRequestDTO(
        @NotNull Long produtoId,
        @Min(1) int quantidade) {
}