package com.venta.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="factura")

public class Factura {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private int nrofactura;
	private String fecha;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
		
	public Factura(int nrofactura, String fecha, Cliente cliente) {
		super();
		this.nrofactura = nrofactura;
		this.fecha = fecha;
		this.cliente = cliente;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNrofactura() {
		return nrofactura;
	}


	public void setNrofactura(int nrofactura) {
		this.nrofactura = nrofactura;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Factura(int id, int nrofactura, String fecha, Cliente cliente) {
		super();
		this.id = id;
		this.nrofactura = nrofactura;
		this.fecha = fecha;
		this.cliente = cliente;
	}


	public Factura(int id) {
		super();
		this.id = id;
	}


	public Factura() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}


	
	
}
	