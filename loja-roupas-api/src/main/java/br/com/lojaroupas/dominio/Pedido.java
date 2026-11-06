package br.com.lojaroupas.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Entidade {
    private Long clienteId;
    private List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status = StatusPedido.AGUARDANDO_PAGAMENTO;
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal desconto = BigDecimal.ZERO;
    private BigDecimal frete = BigDecimal.ZERO;
    private String freteDescricao;
    private BigDecimal total = BigDecimal.ZERO;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public String getFreteDescricao() {
        return freteDescricao;
    }

    public void setFreteDescricao(String freteDescricao) {
        this.freteDescricao = freteDescricao;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
