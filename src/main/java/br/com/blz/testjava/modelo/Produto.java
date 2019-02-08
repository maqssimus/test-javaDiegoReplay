package br.com.blz.testjava.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer sku;
	
	private String nome;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Inventario inventario;
	
	@Transient
	private Boolean isMarketable;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Boolean getIsMarketable() {
		
		return this.isMarketable;
	}

	public void setIsMarketable() {

		this.isMarketable = (this.getInventario().getQuantity() > 0) ? true : false;
	}

}
