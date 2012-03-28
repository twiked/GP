package fr.badgers.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.badgers.model.Proprietaire;
import fr.badgers.model.dao.DAOProprietaire;

public class DAOProprietaireJPA implements DAOProprietaire {

	private EntityManager entityManager;

	public DAOProprietaireJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int computeNbProprietaire() {
		return 0;
	}

	public Proprietaire insert(Proprietaire obj) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(obj);
		tx.commit();
		return entityManager.find(Proprietaire.class, obj.getIdProprietaire());
	}

	public boolean update(Proprietaire obj) {
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

	public boolean delete(Proprietaire obj) {
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

	public Proprietaire getById(Integer id) {
		return entityManager.find(Proprietaire.class, id);
	}

	public List<Proprietaire> FindAll() {
		TypedQuery<Proprietaire> query = entityManager.createQuery(
				"SELECT P FROM Proprietaire P", Proprietaire.class);
		return query.getResultList();
	}

}
