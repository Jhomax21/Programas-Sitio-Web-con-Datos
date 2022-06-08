package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICarritoDao;
import pe.edu.upc.entity.Carrito;
import pe.edu.upc.service.ICarritoService;

@Named
@RequestScoped
public class CarritoServiceImpl implements ICarritoService, Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private ICarritoDao cD;

	@Override
	public void insert(Carrito carrito) {
		// TODO Auto-generated method stub
		cD.insert(carrito);
	}

	@Override
	public List<Carrito> list() {
		// TODO Auto-generated method stub
		return cD.list();
	}

	@Override
	public void delete(int idCarrito) {
		// TODO Auto-generated method stub
		cD.delete(idCarrito);
	}

}
