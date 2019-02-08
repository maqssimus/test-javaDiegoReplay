package br.com.blz.testjava.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blz.testjava.modelo.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

	Produto findBySku(int sku);
}
