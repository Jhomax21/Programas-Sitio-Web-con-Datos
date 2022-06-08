package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICarritoDao;
import pe.edu.upc.entity.Carrito;

public class CarritoDaoImpl implements ICarritoDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "migracionPU")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Carrito carrito) {
		// TODO Auto-generated method stub
		try {
			em.persist(carrito);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrito> list() {
		// TODO Auto-generated method stub
		List<Carrito> lista = new ArrayList<Carrito>();
		try {
			Query q = em.createQuery("select c from Carrito c");
			lista = (List<Carrito>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int idCarrito) {
		// TODO Auto-generated method stub
		Carrito c = new Carrito();
		try {
			c = em.getReference(Carrito.class, idCarrito);
			em.remove(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
