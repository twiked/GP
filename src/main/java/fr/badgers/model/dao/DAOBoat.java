package fr.badgers.model.dao;

import fr.badgers.model.Boat;

public class DAOBoat extends DAO {

	private DAOBoat() {

	}

	public Boat createBoat() {
		Boat boat = new Boat();
		em.persist(boat);
		return boat;
	}

	public void removeBoat(int id) {
		Boat boat = em.find(Boat.class, id);
		if (boat != null)
			em.remove(boat);
	}
}
