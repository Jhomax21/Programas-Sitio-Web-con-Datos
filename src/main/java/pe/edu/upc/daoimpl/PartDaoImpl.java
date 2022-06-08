package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPartDao;
import pe.edu.upc.entity.Part;

public class PartDaoImpl implements IPartDao, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "migracionPU")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Part part) {
		try {
			em.persist(part);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Part> list() {
		List<Part> lista = new ArrayList<Part>();
		try {
			Query q = em.createQuery("select p from Part p");
			lista = (List<Part>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;

	}

	@Transactional
	@Override
	public void delete(int idPart) {
		Part p = new Part();
		try {
			p = em.getReference(Part.class, idPart);
			em.remove(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
