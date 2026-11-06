package br.com.lojaroupas.dao;
import br.com.lojaroupas.dominio.Produto;
import org.springframework.stereotype.Repository;
@Repository
public class ProdutoDAOMemoria extends DAOMemoria<Produto> implements ProdutoDAO {
}