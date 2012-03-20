package fr.badgers.model.dao;
import javax.persistence.*;

public class DAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persUnit");
	EntityManager em = emf.createEntityManager();
}
