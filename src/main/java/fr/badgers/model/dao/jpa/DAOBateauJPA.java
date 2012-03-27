package fr.badgers.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.badgers.model.Bateau;
import fr.badgers.model.dao.DAOBateau;

public class DAOBateauJPA implements DAOBateau{

		private EntityManager entityManager;

		public DAOBateauJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
		}

		public int computeNbBateau() {
		return 0;
		}

		public Bateau insert(Bateau obj) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(obj);
		tx.commit();
		return entityManager.find(Bateau.class, obj.getNumeroSerie());
		}

		public boolean update(Bateau obj) {
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

		public boolean delete(Bateau obj) {
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

		public Bateau getById(Integer id) {
		return entityManager.find(Bateau.class, id);
		}

		public List<Bateau> FindAll() {
		TypedQuery<Bateau> query = entityManager.createNamedQuery("SELECT * FROM BATEAU", Bateau.class);
		return query.getResultList();
		}

}
