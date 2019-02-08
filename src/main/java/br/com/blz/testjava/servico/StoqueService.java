package br.com.blz.testjava.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.blz.testjava.modelo.Produto;
import br.com.blz.testjava.repositorio.ProdutoRepositorio;

@Service
public class StoqueService {
	
	@Autowired
    ProdutoRepositorio produtoRepositorio;

	public HttpStatus add(Produto produto) throws Exception {
		HttpStatus httpStatus = HttpStatus.CREATED;
		
		try {
			if (produto != null) {
				Produto hasProduto = produtoRepositorio.findBySku(produto.getSku());
				
				if (hasProduto == null ) {
					produtoRepositorio.save(produto);
				}
				else {
					httpStatus = HttpStatus.CONFLICT;
				}
			}
			else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		}
		catch(Exception e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			throw new Exception(e.getMessage());
		}
		
		return httpStatus;
	}

	public List<Produto> getList() throws Exception {
		List<Produto> produtoList = new ArrayList<Produto>();
		
		try {
		produtoList = produtoRepositorio.findAll();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return produtoList;
	}

	public HttpStatus update(Produto produto) throws Exception {
		HttpStatus httpStatus = HttpStatus.CREATED;

		try {
			produtoRepositorio.save(produto);
		}
		catch(Exception e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			throw new Exception(e.getMessage());
		}
		return httpStatus;
	}

	public HttpStatus delete(Produto produto) throws Exception {
		HttpStatus httpStatus = HttpStatus.CREATED;

		try {
			produtoRepositorio.delete(produto);
		}
		catch(Exception e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			throw new Exception(e.getMessage());
		}
			
		return httpStatus;
	}

}
