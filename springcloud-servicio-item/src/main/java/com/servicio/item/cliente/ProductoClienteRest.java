package com.servicio.item.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.servicio.item.modelo.Producto;


@FeignClient(name = "servicio-producto", url = "localhost:8081")
public interface ProductoClienteRest {
	
	
	
	@GetMapping("/api/servico-producto/listado-producto")
	public List<Producto> listadoProductoCliente();
	
	@GetMapping("/api/servico-producto/producto/{id}")
	public Producto buscarproductoCliente(@PathVariable long id);

}
