package fr.badgers.model.dao;

import java.util.List;

import fr.badgers.model.Emplacement;
import fr.badgers.model.EmplacementId;
import fr.badgers.model.Modele;

public interface DAOEmplacement extends DAO<Emplacement, EmplacementId> {
	public List<Emplacement> findByModel(Modele model, boolean isResident);
}
