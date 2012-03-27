package fr.badgers.model.dao;

import javax.persistence.EntityManager;

import fr.badgers.model.dao.jpa.DAOGeneriqueJPA;

public class DAOEmplacement extends DAOGeneriqueJPA<Object, Object> {

	public DAOEmplacement(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
