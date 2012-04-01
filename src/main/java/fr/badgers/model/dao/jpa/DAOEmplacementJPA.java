package fr.badgers.model.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fr.badgers.model.Emplacement;
import fr.badgers.model.EmplacementId;
import fr.badgers.model.Modele;
import fr.badgers.model.dao.DAOEmplacement;


public class DAOEmplacementJPA extends DAOGeneriqueJPA<Emplacement, EmplacementId>
		implements DAOEmplacement {

	public DAOEmplacementJPA(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<Emplacement> findByModel(Modele model, boolean isResident) {
		// TODO
		return null;
	}

}

