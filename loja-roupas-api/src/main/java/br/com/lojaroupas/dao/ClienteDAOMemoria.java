package br.com.lojaroupas.dao;

import br.com.lojaroupas.dominio.Cliente;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAOMemoria extends DAOMemoria<Cliente> implements ClienteDAO {
    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return listarTodos().stream()
                .filter(cliente -> cliente.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}