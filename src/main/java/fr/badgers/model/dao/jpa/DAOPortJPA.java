package fr.badgers.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.badgers.model.Port;
import fr.badgers.model.dao.DAOPort;

public class DAOPortJPA implements DAOPort {

	private EntityManager entityManager;

	public DAOPortJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int computeNbPort() {
		return 0;
	}

	public Port insert(Port obj) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(obj);
		tx.commit();
		return entityManager.find(Port.class, obj.getCode());
	}

	public boolean update(Port obj) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Port obj) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Port getById(Integer id) {
		return entityManager.find(Port.class, id);
	}

	public List<Port> FindAll() {
		TypedQuery<Port> query = entityManager.createQuery(
				"SELECT P FROM Port P", Port.class);
		return query.getResultList();
	}

}
