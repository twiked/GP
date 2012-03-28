package fr.badgers.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.badgers.model.TypeEmplacement;
import fr.badgers.model.dao.DAOTypeEmplacement;

public class DAOTypeEmplacementJPA implements DAOTypeEmplacement {

	private EntityManager entityManager;

	public DAOTypeEmplacementJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int computeNbTypeEmplacement() {
		return 0;
	}

	public TypeEmplacement insert(TypeEmplacement obj) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(obj);
		tx.commit();
		return entityManager.find(TypeEmplacement.class, obj.getIdType());
	}

	public boolean update(TypeEmplacement obj) {
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

	public boolean delete(TypeEmplacement obj) {
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

	public TypeEmplacement getById(Integer id) {
		return entityManager.find(TypeEmplacement.class, id);
	}

	public List<TypeEmplacement> FindAll() {
		TypedQuery<TypeEmplacement> query = entityManager.createNamedQuery(
				"SELECT TP FROM TypeEmplacement TP", TypeEmplacement.class);
		return query.getResultList();
	}

}
