package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IProductDao;
import pe.edu.upc.entity.Product;

public class ProductDaoImpl implements IProductDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "migracionPU")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		try {
			em.persist(product);;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		List<Product> lista = new ArrayList<Product>();
		try {
			Query q = em.createQuery("select p from Product p");
			lista = (List<Product>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	@Transactional
	@Override
	public void delete(int idProduct) {
		// TODO Auto-generated method stub
		Product pro = new Product();
		try {
			pro = em.getReference(Product.class, idProduct);
			em.remove(pro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> finByName(Product product) {
		// TODO Auto-generated method stub
		List<Product> lista = new ArrayList<Product>();
		try {
			Query q = em.createQuery("select p from Product p where p.nombre like ?1");
			q.setParameter(1, "%" + product.getNombre() + "%");
			lista = (List<Product>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		try {
			em.merge(product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
