package br.com.lojaroupas.mapper;

import br.com.lojaroupas.dominio.Produto;
import br.com.lojaroupas.dto.ProdutoRequestDTO;
import br.com.lojaroupas.dto.ProdutoResponseDTO;

public final class ProdutoMapper {
    private ProdutoMapper() {
    }

    public static Produto paraEntidade(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        atualizar(produto, dto);
        return produto;
    }

    public static void atualizar(Produto produto, ProdutoRequestDTO dto) {
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setTamanho(dto.tamanho());
        produto.setEstoque(dto.estoque());
    }

    public static ProdutoResponseDTO paraDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getTamanho(),
                produto.getEstoque());
    }
}