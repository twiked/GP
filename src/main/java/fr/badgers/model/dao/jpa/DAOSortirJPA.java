package fr.badgers.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.badgers.model.Modele;
import fr.badgers.model.Sortir;
import fr.badgers.model.SortirId;
import fr.badgers.model.dao.DAOSortir;

public class DAOSortirJPA implements DAOSortir{

	private EntityManager entityManager;

	public DAOSortirJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	public boolean delete(Sortir obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Sortir> FindAll() {
		TypedQuery<Sortir> query = entityManager.createQuery(
				"SELECT M FROM Sortir M", Sortir.class);
		return query.getResultList();
	}

	@Override
	public Sortir getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sortir insert(Sortir obj) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(obj);
		tx.commit();
		return entityManager.find(Sortir.class, new SortirId(obj.getResident().getIdBateau(), obj.getDateDebut()));
	}

	@Override
	public boolean update(Sortir obj) {
		// TODO Auto-generated method stub
		return false;
	}

}