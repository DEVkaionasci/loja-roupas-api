package br.com.lojaroupas.servico;

import br.com.lojaroupas.dao.ProdutoDAO;
import br.com.lojaroupas.dominio.Produto;
import br.com.lojaroupas.dto.ProdutoRequestDTO;
import br.com.lojaroupas.dto.ProdutoResponseDTO;
import br.com.lojaroupas.excecao.RecursoNaoEncontradoException;
import br.com.lojaroupas.mapper.ProdutoMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoDAO produtoDAO;

    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        Produto salvo = produtoDAO.salvar(ProdutoMapper.paraEntidade(dto));
        return ProdutoMapper.paraDTO(salvo);
    }

    public List<ProdutoResponseDTO> listar() {
        return produtoDAO.listarTodos().stream()
                .map(ProdutoMapper::paraDTO)
                .toList();
    }

    public ProdutoResponseDTO buscar(Long id) {
        return ProdutoMapper.paraDTO(buscarEntidade(id));
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = buscarEntidade(id);
        ProdutoMapper.atualizar(produto, dto);
        return ProdutoMapper.paraDTO(produtoDAO.salvar(produto));
    }

    public void remover(Long id) {
        buscarEntidade(id);
        produtoDAO.remover(id);
    }

    private Produto buscarEntidade(Long id) {
        return produtoDAO.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Produto não encontrado: " + id));
    }
}