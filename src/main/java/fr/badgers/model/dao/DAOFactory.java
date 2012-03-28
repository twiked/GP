package fr.badgers.model.dao;

public interface DAOFactory {

	public DAOBateau createDAOBateau();
	public DAOModele createDAOModele();
	public DAOPonton createDAOPonton();
	public DAOPort createDAOPort();
	public DAOProprietaire createDAOProprietaire();
	public DAOTypeEmplacement createDAOTypeEmplacement();
}
