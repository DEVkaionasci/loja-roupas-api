package br.com.lojaroupas.dao;
import br.com.lojaroupas.dominio.Pedido;
import java.util.List;

public interface PedidoDAO extends DAO<Pedido> {
    List<Pedido> listarPorCliente(Long clienteId);
}
