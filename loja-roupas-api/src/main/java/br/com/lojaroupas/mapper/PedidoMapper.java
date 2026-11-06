package br.com.lojaroupas.mapper;

import br.com.lojaroupas.dominio.Pedido;
import br.com.lojaroupas.dto.ItemPedidoResponseDTO;
import br.com.lojaroupas.dto.PedidoResponseDTO;
import java.util.List;

public final class PedidoMapper {
    private PedidoMapper() {
    }

    public static PedidoResponseDTO paraDTO(Pedido p) {
        List<ItemPedidoResponseDTO> itens = p.getItens().stream()
                .map(i -> new ItemPedidoResponseDTO(
                        i.getProdutoId(),
                        i.getNomeProduto(),
                        i.getQuantidade(),
                        i.getPrecoUnitario()))
                .toList();
        return new PedidoResponseDTO(
                p.getId(),
                p.getClienteId(),
                itens,
                p.getSubtotal(),
                p.getDesconto(),
                p.getFrete(),
                p.getFreteDescricao(),
                p.getTotal(),
                p.getStatus());
    }
}