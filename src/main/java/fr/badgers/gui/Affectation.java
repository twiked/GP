package fr.badgers.gui;

import java.awt.FlowLayout;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.badgers.model.Bateau;
import fr.badgers.model.Modele;
import fr.badgers.model.Port;
import fr.badgers.model.Proprietaire;
import fr.badgers.model.dao.DAOBateau;
import fr.badgers.model.dao.DAOModele;
import fr.badgers.model.dao.DAOPort;
import fr.badgers.model.dao.DAOProprietaire;
import fr.badgers.model.dao.jpa.DAOFactoryJPA;

public class Affectation extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	private List<Proprietaire> proprietaires;
	private List<Bateau> bateaux;
	private List<Port> ports;
	private List<Modele> models;

	public Affectation(EntityManager em)  {
		super();
		this.em = em;
		
		DAOFactoryJPA daof = new DAOFactoryJPA(em);
		
		// All owners
		DAOProprietaire daoowner = daof.createDAOProprietaire();
		proprietaires = daoowner.FindAll();

		// All boats
		DAOBateau daoboat = daof.createDAOBateau();
		bateaux = daoboat.FindAll();
		
		// All models
		DAOModele daomodel = daof.createDAOModele();
		models = daomodel.FindAll();
		
		// All ports
		DAOPort daoport = daof.createDAOPort();
		ports = daoport.FindAll();

		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel boatPanel = new JPanel();
		boatPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		boatPanel.add(new JLabel("Bateau"));
		
		// boat id -- can stay empty
		JTextField idBoat = new JTextField(2);
		idBoat.setToolTipText("Id Bateau");
		
		// boat name
		JTextField nameBoat = new JTextField(5);
		nameBoat.setToolTipText("Nom Bateau");
		
		// serial number
		JTextField numBoat = new JTextField(4);
		numBoat.setToolTipText("Numero Bateau");
		
		// boat insurance
		JTextField insuBoat = new JTextField(4);
		insuBoat.setToolTipText("Assurance Bateau");
		
		// boat model -- list with the currently available models
		JComboBox modelBoat = new JComboBox();
		modelBoat.setToolTipText("Modele Bateau");
		for (Modele m : models)
		{
			modelBoat.addItem(m);
		}
		
		// boat port -- list with the currently known ports
		JComboBox portBoat = new JComboBox();
		portBoat.setToolTipText("Port Bateau");
		for (Port p : ports)
		{
			portBoat.addItem(p);
		}
		
		// boat owner -- list with all the currently known owners
		JComboBox ownBoat = new JComboBox();
		ownBoat.setToolTipText("Proprietaire");
		for (Proprietaire p : proprietaires)
		{
			ownBoat.addItem(p);
		}
		
		boatPanel.add(idBoat);
		boatPanel.add(nameBoat);
		boatPanel.add(numBoat);
		boatPanel.add(insuBoat);
		boatPanel.add(modelBoat);
		boatPanel.add(portBoat);
		boatPanel.add(ownBoat);
		
		
		
		
		
		
		this.add(boatPanel);
		JSeparator separ = new JSeparator(SwingConstants.HORIZONTAL);
		this.add(separ);
	}

}
