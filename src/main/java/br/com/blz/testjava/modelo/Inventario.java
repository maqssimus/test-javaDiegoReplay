package br.com.blz.testjava.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inventario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;

	@Transient
	private int quantidade;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Armazem> armazems;

	public int getQuantity() {
		return this.quantidade;
	}

	public void setquantidade() {
		int soma = 0;
		List<Armazem> armazem = this.getWarehouses();
		
		for ( Armazem armazems : armazem) {
			soma = soma + armazems.getQuantidade();
		}
		
		this.quantidade = soma;
	}

	public List<Armazem> getWarehouses() {
		return armazems;
	}

	public void setWarehouses(List<Armazem> warehouses) {
		this.armazems = armazems;
	}

	public int getId() {
		return id;
	}

}
