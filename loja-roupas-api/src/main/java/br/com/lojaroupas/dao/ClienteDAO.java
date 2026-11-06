package br.com.lojaroupas.dao;

import br.com.lojaroupas.dominio.Cliente;
import java.util.Optional;

public interface ClienteDAO extends DAO<Cliente> {
    Optional<Cliente> buscarPorEmail(String email);
}