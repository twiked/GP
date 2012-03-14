package badgers.model.dao;

import badgers.model.Model;

public class DAOModel {
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
		if (own != null)
			em.remove(mod);
	}
}
