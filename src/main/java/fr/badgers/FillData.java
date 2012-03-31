package fr.badgers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.badgers.model.Bateau;
import fr.badgers.model.Modele;
import fr.badgers.model.Port;
import fr.badgers.model.Proprietaire;
import fr.badgers.model.dao.DAOBateau;
import fr.badgers.model.dao.DAOModele;
import fr.badgers.model.dao.DAOPort;
import fr.badgers.model.dao.DAOProprietaire;
import fr.badgers.model.dao.jpa.DAOFactoryJPA;

public class FillData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("GP");
				EntityManager em = emf.createEntityManager();
		
		DAOFactoryJPA daof = new DAOFactoryJPA(em);
				
		Random r = new Random();
		List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
		
		String[] names1 = {"Jean", 	"Ben", 	"Mig", 	"Sal", 	"Ser", 	"Bim", 	"Xan", 
							"Tur", 	"Dem", 	"Cha", 	"Zab", 	"Hih"};
		String[] names2 = {"ien", 	"lio", 	"mon", 	"nub", 	"zar", 	"bou", 	"hol", 
							"sed", 	"lig", 	"", 	"by", 	"man"};
		int stringLength = names1.length;
		DAOProprietaire daopr = daof.createDAOProprietaire();
		for (int i = 0; i<20; ++i)
		{
			Proprietaire p = new Proprietaire();
			// We generate random numbers to fill the 
			p.setNom(names1[r.nextInt(stringLength)] + names2[r.nextInt(stringLength)]);
			p.setAdresse("Volrundd");
			p.setTelephone(null);
			daopr.insert(p);
			proprietaires.add(p);
		}
		DAOPort daopo = daof.createDAOPort();
		
		Port p1 = new Port("AB");
		p1.setNom("ArenaBui");
		
		Port p2 = new Port("SU");
		p2.setNom("SouthernUnion");
		
		Port p3 = new Port("NU");
		p3.setNom("NorthernUnion");
		
		Port p4 = new Port("SV");
		p4.setNom("SandVich");
		
		daopo.insert(p1);
		daopo.insert(p2);
		daopo.insert(p3);
		daopo.insert(p4);
		
		DAOModele daomo = daof.createDAOModele();
		
		Modele m1 = new Modele();
		m1.setSerie("S600");
		m1.setConstructeur("Organisation of Governmental Crisis");
		m1.setLargeur(8);
		m1.setLongueur(20);
		m1.setTirant(5);
		m1.setType("Small Ship");
		
		Modele m2 = new Modele();
		m2.setSerie("S610");
		m2.setConstructeur("Organisation of Governmental Crisis");
		m2.setLargeur(9);
		m2.setLongueur(30);
		m2.setTirant(8);
		m2.setType("Ship");
		
		daomo.insert(m1);
		daomo.insert(m2);
		
		DAOBateau daoba = daof.createDAOBateau();
		
		Bateau b1 = new Bateau();
		b1.setAssurance("Nope");
		b1.setModele(m1);
		b1.setNomBateau("Helena");
		b1.setPortOrigine(p1);
		b1.setProprietaire(proprietaires.get(r.nextInt(proprietaires.size())));
//		Proprietaire tempProp = proprietaires.get(r.nextInt(proprietaires.size()));
//		b1.setProprietaire(tempProp);
//		Collection<Bateau> bateaux = tempProp.getBateaux();
//		bateaux.add(b1);
//		tempProp.setBateaux(bateaux);
		
		Bateau b2 = new Bateau();
		b2.setAssurance("Still nope");
		b2.setModele(m1);
		b2.setNomBateau("Amy");
		b2.setPortOrigine(p2);
		b2.setProprietaire(proprietaires.get(r.nextInt(proprietaires.size())));
//		tempProp = proprietaires.get(r.nextInt(proprietaires.size()));
//		b2.setProprietaire(tempProp);
//		bateaux = tempProp.getBateaux();
//		bateaux.add(b2);
//		tempProp.setBateaux(bateaux);
		
		Bateau b3 = new Bateau();
		b3.setAssurance("Not yet");
		b3.setModele(m2);
		b3.setNomBateau("Lucy");
		b3.setPortOrigine(p1);
		b3.setProprietaire(proprietaires.get(r.nextInt(proprietaires.size())));
		
		Bateau b4 = new Bateau();
		b4.setAssurance("AGRC");
		b4.setModele(m1);
		b4.setNomBateau("Mundy");
		b4.setPortOrigine(p1);
		b4.setProprietaire(proprietaires.get(r.nextInt(proprietaires.size())));
		
		Bateau b5 = new Bateau();
		b5.setAssurance("Gaad");
		b5.setModele(m2);
		b5.setNomBateau("Salem");
		b5.setPortOrigine(p3);
		b5.setProprietaire(proprietaires.get(r.nextInt(proprietaires.size())));
		
		Bateau b6 = new Bateau();
		b6.setAssurance("MYMYMY");
		b6.setModele(m1);
		b6.setNomBateau("Sarah");
		b6.setPortOrigine(p4);
		b6.setProprietaire(proprietaires.get(r.nextInt(proprietaires.size())));
		
		Bateau b7 = new Bateau();
		b7.setAssurance("SssssSSssss");
		b7.setModele(m2);
		b7.setNomBateau("Kree Per");
		b7.setPortOrigine(p3);
		b7.setProprietaire(proprietaires.get(r.nextInt(proprietaires.size())));
		
		Bateau b8 = new Bateau();
		b8.setAssurance("Gaad");
		b8.setModele(m1);
		b8.setNomBateau("Natacha");
		b8.setPortOrigine(p4);
		b8.setProprietaire(proprietaires.get(r.nextInt(proprietaires.size())));
		
		daoba.insert(b1);
		daoba.insert(b2);
		daoba.insert(b3);
		daoba.insert(b4);
		daoba.insert(b5);
		daoba.insert(b6);
		daoba.insert(b7);
		daoba.insert(b8);
	}
	
	

}
