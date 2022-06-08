package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPartDao;
import pe.edu.upc.entity.Part;
import pe.edu.upc.service.IPartService;

@Named
@RequestScoped
public class PartServiceImpl implements IPartService, Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private IPartDao pD;

	@Override
	public void insert(Part part) {
		pD.insert(part);
	}
	@Override
	public List<Part> list() {
		// TODO Auto-generated method stub
		return pD.list();
	}
	@Override
	public void delete(int idPart) {
		pD.delete(idPart);
	}
}
