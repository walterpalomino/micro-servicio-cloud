package com.servicio.producto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicio.producto.entity.Producto;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, Long> {

}
