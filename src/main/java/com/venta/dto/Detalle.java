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
@Table(name="detalle")

public class Detalle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int preciounit;
	private int cantidad;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="factura_id")
	private Factura factura;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="producto_id")
	private Producto producto;
	
	public Detalle(Factura factura, int preciounit, int cantidad, Producto producto) {
		super();
		this.factura = factura;
		this.preciounit = preciounit;
		this.cantidad = cantidad;
	}

	public Detalle(int preciounit, int cantidad, Factura factura, Producto producto) {
		super();
		this.preciounit = preciounit;
		this.cantidad = cantidad;
		this.factura = factura;
		this.producto = producto;
	}

	public Detalle() {
		super();
	}

	public int getPreciounit() {
		return preciounit;
	}

	public void setPreciounit(int preciounit) {
		this.preciounit = preciounit;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
