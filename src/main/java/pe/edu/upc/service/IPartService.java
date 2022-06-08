package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Part;

public interface IPartService {
	public void insert(Part part);

	public List<Part> list();

	public void delete(int idPart);


}
