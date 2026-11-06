package br.com.lojaroupas.dao;
import br.com.lojaroupas.dominio.Entidade;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
public abstract class DAOMemoria<T extends Entidade> implements DAO<T> {
 private final Map<Long, T> banco = new ConcurrentHashMap<>();
 private final AtomicLong sequencia = new AtomicLong(1);
 @Override
 public T salvar(T entidade) {
 if (entidade.getId() == null) {
 entidade.setId(sequencia.getAndIncrement());
 }
 banco.put(entidade.getId(), entidade);
 return entidade;
 }
 @Override
 public Optional<T> buscarPorId(Long id) {
 return Optional.ofNullable(banco.get(id));
 }
 @Override
 public List<T> listarTodos() {
 return banco.values().stream()
 .sorted(Comparator.comparing(Entidade::getId))
 .toList();
 }
 @Override
 public void remover(Long id) {
    banco.remove(id);
 }
}
