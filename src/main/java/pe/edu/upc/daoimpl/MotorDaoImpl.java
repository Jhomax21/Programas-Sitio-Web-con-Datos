package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IMotorDao;
import pe.edu.upc.entity.Motor;

public class MotorDaoImpl implements IMotorDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "migracionPU")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Motor motor) {
		try {
			em.persist(motor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Motor> list() {
		List<Motor> lista = new ArrayList<Motor>();
		try {
			Query q = em.createQuery("select m from Motor m");
			lista = (List<Motor>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	@Transactional
	@Override
	public void delete(int idMotor) {
		Motor mot = new Motor();
		try {
			mot = em.getReference(Motor.class, idMotor);
			em.remove(mot);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Motor> finByName(Motor motor) {
		List<Motor> lista = new ArrayList<Motor>();
		try {
			Query q = em.createQuery("select m from Motor m where m.nameMotor like ?1");
			q.setParameter(1, "%" + motor.getNameMotor() + "%");
			lista = (List<Motor>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
