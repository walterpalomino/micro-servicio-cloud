package com.servicio.producto.servicio;

import java.util.List;

import com.servicio.producto.entity.Producto;

public interface ProductoServicio {
	
	public List<Producto> listaProducto();
	public Producto buscarProdcuto(long id);
	

}
