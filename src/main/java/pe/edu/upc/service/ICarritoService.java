package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Carrito;

public interface ICarritoService {
	
	public void insert(Carrito carrito);

	public List<Carrito> list();

	public void delete(int idCarrito);

}
