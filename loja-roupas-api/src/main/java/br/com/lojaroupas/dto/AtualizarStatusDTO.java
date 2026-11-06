package br.com.lojaroupas.dto;

import br.com.lojaroupas.dominio.StatusPedido;
import jakarta.validation.constraints.NotNull;

public record AtualizarStatusDTO(
        @NotNull StatusPedido status) {
}
