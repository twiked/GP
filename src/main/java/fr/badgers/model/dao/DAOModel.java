package fr.badgers.model.dao;

import fr.badgers.model.Model;

public class DAOModel extends DAO{
	private DAOModel() {

	}

	public Model createModel(String constructor) {
		Model mod = new Model();
		mod.setConstructor(constructor);
		em.persist(mod);

		return mod;
	}

	public void removeModel(int id) {
		Model mod = em.find(Model.class, id);
		if (mod != null)
			em.remove(mod);
	}
}
