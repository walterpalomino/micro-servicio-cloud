package com.servicio.producto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.producto.entity.Producto;
import com.servicio.producto.servicio.ProductoServicio;

@RestController
@RequestMapping("/api/servico-producto")
public class ProductoControlador {

	@Autowired
	ProductoServicio servicio;
	
	@GetMapping("/listado-producto")
	public ResponseEntity<List<Producto>> listadoProductos()
	{		 
		return (!servicio.listaProducto().isEmpty())? ResponseEntity.ok(servicio.listaProducto()):ResponseEntity.noContent().build();  
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> buscandoProducto(@PathVariable long id)
	{
		return (servicio.buscarProdcuto(id) !=null)? ResponseEntity.ok(servicio.buscarProdcuto(id)) : ResponseEntity.notFound().build();
	}
}
