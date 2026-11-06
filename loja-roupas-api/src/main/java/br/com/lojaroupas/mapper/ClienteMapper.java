package br.com.lojaroupas.mapper;

import br.com.lojaroupas.dominio.Cliente;
import br.com.lojaroupas.dto.ClienteRequestDTO;
import br.com.lojaroupas.dto.ClienteResponseDTO;

public final class ClienteMapper {
    private ClienteMapper() {
    }

    // A senha NAO e copiada aqui: quem faz o hash e o servico.
    public static Cliente paraEntidade(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        atualizar(cliente, dto);
        return cliente;
    }

    public static void atualizar(Cliente cliente, ClienteRequestDTO dto) {
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
    }

    public static ClienteResponseDTO paraDTO(Cliente c) {
        return new ClienteResponseDTO(c.getId(), c.getNome(), c.getEmail());
    }
}