package fr.badgers.model.dao;

import javax.persistence.EntityManager;

import fr.badgers.model.dao.jpa.DAOGeneriqueJPA;

public class DAOModelePassager extends DAOGeneriqueJPA<Object, Object> {

	public DAOModelePassager(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
