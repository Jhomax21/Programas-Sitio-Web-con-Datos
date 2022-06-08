package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Part;

public interface IPartDao {
	public void insert(Part part);

	public List<Part> list();

	public void delete(int idPart);


}
