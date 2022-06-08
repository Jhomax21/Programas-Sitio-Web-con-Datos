package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IProductDao;
import pe.edu.upc.entity.Product;
import pe.edu.upc.service.IProductService;

@Named
@RequestScoped
public class ProductServiceImpl implements IProductService, Serializable {

	private static final long serialVersionUID = 1L;		
	@Inject
	private IProductDao pD;
	
	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		pD.insert(product);
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return pD.list();
	}

	@Override
	public void delete(int idProduct) {
		// TODO Auto-generated method stub
		pD.delete(idProduct);
	}

	@Override
	public List<Product> finByName(Product product) {
		// TODO Auto-generated method stub
		return pD.finByName(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		pD.update(product);
	}

}
