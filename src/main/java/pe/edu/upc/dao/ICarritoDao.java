package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Carrito;

public interface ICarritoDao {
	public void insert(Carrito carrito);

	public List<Carrito> list();

	public void delete(int idCarrito);
}
