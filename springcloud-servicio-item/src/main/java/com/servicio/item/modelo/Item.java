package com.servicio.item.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Item {
	
	private Producto producto;
	private int cantidad;
	private double total;
	
	public Item(Producto producto,int cantidad)
	{
		this.producto=producto;
		this.cantidad=cantidad;
		this.total=importeTotal();
		
	}
	
	public double importeTotal()
	{
		return producto.getPrecio() * cantidad;
	}
	
	
	

}
