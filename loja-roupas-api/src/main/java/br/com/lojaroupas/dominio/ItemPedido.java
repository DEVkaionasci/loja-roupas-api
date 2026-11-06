package br.com.lojaroupas.dominio;

import java.math.BigDecimal;

public class ItemPedido {
    private final Long produtoId;
    private final String nomeProduto;
    private final int quantidade;
    private final BigDecimal precoUnitario;

    public ItemPedido(Long produtoId, String nomeProduto, int quantidade,
            BigDecimal precoUnitario) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
