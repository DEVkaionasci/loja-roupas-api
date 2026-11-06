package br.com.lojaroupas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record PedidoRequestDTO(
        @NotNull Long clienteId,
        @NotEmpty @Valid List<ItemPedidoRequestDTO> itens,
        String cupom,
        boolean freteExpresso,
        boolean seguro) {
}