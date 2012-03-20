package fr.badgers.model.dao;

import fr.badgers.model.Owner;

public class DAOOwner extends DAO {
	private DAOOwner() {

	}

	public Owner createOwner(String name) {
		Owner own = new Owner();
		own.setNameOwn(name);
		em.persist(own);

		return own;
	}

	public void removeOwner(int id) {
		Owner own = em.find(Owner.class, id);
		if (own != null)
			em.remove(own);
	}
}
