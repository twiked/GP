package fr.badgers.model.dao.jpa;

import javax.persistence.EntityManager;

import fr.badgers.model.dao.DAOBateau;
import fr.badgers.model.dao.DAOFactory;
import fr.badgers.model.dao.DAOModele;
import fr.badgers.model.dao.DAOPonton;
import fr.badgers.model.dao.DAOPort;
import fr.badgers.model.dao.DAOProprietaire;
import fr.badgers.model.dao.DAOTypeEmplacement;

public class DAOFactoryJPA implements DAOFactory {

	private EntityManager entityManager;

	public DAOFactoryJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public DAOBateau createDAOBateau() {
		return new DAOBateauJPA(entityManager);
	}

	public DAOModele createDAOModele() {
		return new DAOModeleJPA(entityManager);
	}

	public DAOPonton createDAOPonton() {
		return new DAOPontonJPA(entityManager);
	}

	@Override
	public DAOPort createDAOPort() {
		return new DAOPortJPA(entityManager);
	}

	@Override
	public DAOProprietaire createDAOProprietaire() {
		return new DAOProprietaireJPA(entityManager);
	}

	@Override
	public DAOTypeEmplacement createDAOTypeEmplacement() {
		return new DAOTypeEmplacementJPA(entityManager);
	}
}
