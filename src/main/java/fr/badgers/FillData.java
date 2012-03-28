package fr.badgers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.badgers.model.Proprietaire;

public class FillData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("GP");
				EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Proprietaire p = new Proprietaire();
		p.setAdresse("Volrundd");
		p.setNom("Draugr");
		p.setTelephone(null);
		em.persist(p);
		em.getTransaction().commit();
	}

}
