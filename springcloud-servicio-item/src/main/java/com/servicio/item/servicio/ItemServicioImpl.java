package com.servicio.item.servicio;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicio.item.modelo.Item;
import com.servicio.item.modelo.Producto;

@Service
public class ItemServicioImpl implements ItemServicio {

	@Autowired
	private RestTemplate clientRest;
	
	@Override
	public List<Item> findAll() {
		
		List<Producto> productos= Arrays.asList(clientRest.getForObject("http://localhost:8081/api/servico-producto/listado-producto", Producto[].class));
				
		return productos.stream().map(p -> new Item(p,0)).collect(Collectors.toList());  
	}

	@Override
	public Item findById(long id, int cantidad) {   
		
		Producto producto= this.clientRest.getForObject("http://localhost:8081/api/servico-producto/producto/{id}", Producto.class,id);
		return new Item(producto,cantidad);
	}

}
