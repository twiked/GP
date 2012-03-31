/*package fr.badgers.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
		// TODO Auto-generated method stub
		return null;
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
		return entityManager.find(Sortir.class, SortirId.class);
	}

	@Override
	public boolean update(Sortir obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
*/