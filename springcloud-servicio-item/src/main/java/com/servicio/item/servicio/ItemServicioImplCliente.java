package com.servicio.item.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.servicio.item.cliente.ProductoClienteRest;
import com.servicio.item.modelo.Item;

@Service("ItemServicioImplCliente")
@Primary
public class ItemServicioImplCliente implements ItemServicio {
	
	@Autowired	
	private ProductoClienteRest cliente;
	
	@Override
	public List<Item> findAll() {  
	
		return cliente.listadoProductoCliente().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(long id, int cantidad) {
		
		return new Item( cliente.buscarproductoCliente(id),2); 
	}

}
