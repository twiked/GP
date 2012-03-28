package fr.badgers.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.badgers.model.Ponton;
import fr.badgers.model.dao.DAOPonton;

public class DAOPontonJPA implements DAOPonton {

	private EntityManager entityManager;

	public DAOPontonJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int computeNbPonton() {
		return 0;
	}

	public Ponton insert(Ponton obj) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(obj);
		tx.commit();
		return entityManager.find(Ponton.class, obj.getIdPonton());
	}

	public boolean update(Ponton obj) {
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

	public boolean delete(Ponton obj) {
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

	public Ponton getById(Integer id) {
		return entityManager.find(Ponton.class, id);
	}

	public List<Ponton> FindAll() {
		TypedQuery<Ponton> query = entityManager.createNamedQuery(
				"SELECT * FROM Ponton", Ponton.class);
		return query.getResultList();
	}

}
