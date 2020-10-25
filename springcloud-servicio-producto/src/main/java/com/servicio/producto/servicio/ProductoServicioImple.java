package com.servicio.producto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicio.producto.entity.Producto;
import com.servicio.producto.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImple implements ProductoServicio{
	
	@Autowired
	ProductoRepositorio repo;

	@Override
	public List<Producto> listaProducto() {
		
		return (List<Producto>) repo.findAll();
	}

	@Override
	public Producto buscarProdcuto(long id) {
		
		return repo.findById(id).orElse(null);
	}

}
