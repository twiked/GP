package fr.badgers.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.badgers.model.Modele;
import fr.badgers.model.dao.DAOModele;

public class DAOModeleJPA implements DAOModele {

	private EntityManager entityManager;

	public DAOModeleJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int computeNbModele() {
		return 0;
	}

	public Modele insert(Modele obj) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(obj);
		tx.commit();
		return entityManager.find(Modele.class, obj.getIdModele());
	}

	public boolean update(Modele obj) {
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

	public boolean delete(Modele obj) {
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

	public Modele getById(Integer id) {
		return entityManager.find(Modele.class, id);
	}

	public List<Modele> FindAll() {
		TypedQuery<Modele> query = entityManager.createNamedQuery(
				"SELECT * FROM Modele", Modele.class);
		return query.getResultList();
	}

}
