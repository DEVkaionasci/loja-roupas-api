package br.com.lojaroupas.dao;

import br.com.lojaroupas.dominio.Pedido;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoDAOMemoria extends DAOMemoria<Pedido> implements PedidoDAO {
    @Override
    public List<Pedido> listarPorCliente(Long clienteId) {
        return listarTodos().stream()
                .filter(pedido -> pedido.getClienteId().equals(clienteId))
                .toList();
    }
}