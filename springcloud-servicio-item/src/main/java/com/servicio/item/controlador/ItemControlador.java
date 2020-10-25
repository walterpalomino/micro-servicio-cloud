package com.servicio.item.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.item.modelo.Item;
import com.servicio.item.servicio.ItemServicio;

@RestController
public class ItemControlador {
	
	@Autowired
	ItemServicio servicio;
	
	@GetMapping("listado-item")
	public List<Item> listadoItem()
	{
		return servicio.findAll();   
	}
	
	@GetMapping("item/{id}/{cantidad}")
	public Item buscandoItem(@PathVariable long id, @PathVariable int cantidad)
	{
		return servicio.findById(id, cantidad);
	}

}
