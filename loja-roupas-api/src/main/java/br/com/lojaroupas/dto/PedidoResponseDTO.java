package br.com.lojaroupas.dto;

import br.com.lojaroupas.dominio.StatusPedido;
import java.math.BigDecimal;
import java.util.List;

public record PedidoResponseDTO(
        Long id,
        Long clienteId,
        List<ItemPedidoResponseDTO> itens,
        BigDecimal subtotal,
        BigDecimal desconto,
        BigDecimal frete,
        String freteDescricao,
        BigDecimal total,
        StatusPedido status) {
}