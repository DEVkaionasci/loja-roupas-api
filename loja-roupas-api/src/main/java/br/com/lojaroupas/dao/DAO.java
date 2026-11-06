package br.com.lojaroupas.dao;

import br.com.lojaroupas.dominio.Entidade;
import java.util.List;
import java.util.Optional;

public interface DAO<T extends Entidade> {
    T salvar(T entidade);

    Optional<T> buscarPorId(Long id);

    List<T> listarTodos();

    void remover(Long id);
}