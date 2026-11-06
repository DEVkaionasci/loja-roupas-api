package br.com.lojaroupas.servico;

import br.com.lojaroupas.dao.ClienteDAO;
import br.com.lojaroupas.dominio.Cliente;
import br.com.lojaroupas.dto.ClienteRequestDTO;
import br.com.lojaroupas.dto.ClienteResponseDTO;
import br.com.lojaroupas.excecao.RecursoNaoEncontradoException;
import br.com.lojaroupas.excecao.RegraDeNegocioException;
import br.com.lojaroupas.mapper.ClienteMapper;
import br.com.lojaroupas.util.SenhaUtil;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public ClienteResponseDTO criar(ClienteRequestDTO dto) {
        garantirEmailLivre(dto.email(), null);
        Cliente cliente = ClienteMapper.paraEntidade(dto);
        cliente.setSenhaHash(SenhaUtil.hash(dto.senha()));
        return ClienteMapper.paraDTO(clienteDAO.salvar(cliente));
    }

    public List<ClienteResponseDTO> listar() {
        return clienteDAO.listarTodos().stream()
                .map(ClienteMapper::paraDTO)
                .toList();
    }

    public ClienteResponseDTO buscar(Long id) {
        return ClienteMapper.paraDTO(buscarEntidade(id));
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        Cliente cliente = buscarEntidade(id);
        garantirEmailLivre(dto.email(), id);
        ClienteMapper.atualizar(cliente, dto);
        cliente.setSenhaHash(SenhaUtil.hash(dto.senha()));
        return ClienteMapper.paraDTO(clienteDAO.salvar(cliente));
    }

    public void remover(Long id) {
        buscarEntidade(id);
        clienteDAO.remover(id);
    }

    private void garantirEmailLivre(String email, Long idAtual) {
        clienteDAO.buscarPorEmail(email)
                .filter(c -> !c.getId().equals(idAtual))
                .ifPresent(c -> {
                    throw new RegraDeNegocioException("E-mail já cadastrado: " + email);
                });
    }

    private Cliente buscarEntidade(Long id) {
        return clienteDAO.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Cliente não encontrado: " + id));
    }
}