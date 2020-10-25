package com.servicio.item.servicio;

import java.util.List;


import com.servicio.item.modelo.Item;


public interface ItemServicio {
	
	public List<Item> findAll();
	public Item findById(long id, int cantidad);

}
