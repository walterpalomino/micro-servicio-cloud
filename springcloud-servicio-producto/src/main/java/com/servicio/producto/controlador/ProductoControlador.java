package com.servicio.producto.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	
	@Autowired
	private Environment env;
	
	@GetMapping("/listado-producto")
	public ResponseEntity<List<Producto>> listadoProductos()
	{		 
		List<Producto> productos= servicio.listaProducto().stream().map(p ->{
			p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return p;
		}).collect(Collectors.toList());
		
		if (!productos.isEmpty())
		{
			 System.out.println("Tiene productos "+ productos);
			return ResponseEntity.ok(productos);
		  
		}
		
		System.out.println("NOoo Tiene productos "+ productos);
		return ResponseEntity.noContent().build();  
		
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> buscandoProducto(@PathVariable long id)
	{
		return (servicio.buscarProdcuto(id) !=null)? ResponseEntity.ok(servicio.buscarProdcuto(id)) : ResponseEntity.notFound().build();
	}
}
