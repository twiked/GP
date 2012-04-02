package fr.badgers.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.badgers.AlreadyExistingIdException;
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
	
	JTextField idBoat = new JTextField(2);
	JTextField nameBoat = new JTextField(8);
	JTextField numBoat = new JTextField(6);
	JTextField insuBoat = new JTextField(6);
	JComboBox modelBoat = new JComboBox();
	JComboBox portBoat = new JComboBox();
	JComboBox ownBoat = new JComboBox();
	
	JTextField idOwner = new JTextField(2);
	JTextField nameOwner = new JTextField(8);
	JTextField addressOwner = new JTextField(20);
	JTextField phoneOwner = new JTextField(10);
	
	DAOFactoryJPA daof = null;
	
	DAOProprietaire daoowner = null;
	DAOBateau daoboat = null;
	DAOModele daomodel = null;
	DAOPort daoport = null;
	
	// All owners
	private List<Proprietaire> proprietaires = null;
	// All boats
	private List<Bateau> bateaux = null;
	// All ports
	private List<Port> ports = null;
	// All models
	private List<Modele> models = null;

	public Affectation(EntityManager em)  {
		super();
		this.em = em;
		
		daof = new DAOFactoryJPA(em);
		
		daoowner = daof.createDAOProprietaire();
		daoboat = daof.createDAOBateau();
		daomodel = daof.createDAOModele();
		
		this.refreshOwnBoat();
		// All models
		models = daomodel.FindAll();
		// All
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel boatPanel = new JPanel();
		boatPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		boatPanel.add(new JLabel("Bateau"));
		
		// boat name
		nameBoat.setToolTipText("Nom Bateau");
		nameBoat.setText("Nom");
		
		// serial number
		numBoat.setToolTipText("Numero Bateau");
		numBoat.setText("Numéro");
		
		// boat insurance
		insuBoat.setToolTipText("Assurance Bateau");
		insuBoat.setText("Assurance");
		
		// boat model -- list with the currently available models
		modelBoat.setToolTipText("Modele Bateau");
		for (Modele m : models)
		{
			modelBoat.addItem(m);
		}
		modelBoat.addItem("Ajouter ...");
		
		modelBoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				if (box.getSelectedItem().equals("Ajouter ..."))
				{
					refreshModelBoat();
					NewModelDial dialbox = new NewModelDial(null, "Nouveau Modele", false, Affectation.this.em);
				}
			}
		});
		
		refreshPortBoat();
		
		// boat port -- list with the currently known ports
		
		portBoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				if (box.getSelectedItem().equals("Ajouter ..."))
				{
					refreshPortBoat();
					NewPortDial dialbox = new NewPortDial(null, "Nouveau Port", false, Affectation.this.em);
				}
			}
		});
		
		
		boatPanel.add(idBoat);
		boatPanel.add(nameBoat);
		boatPanel.add(numBoat);
		boatPanel.add(insuBoat);
		boatPanel.add(modelBoat);
		boatPanel.add(portBoat);
		boatPanel.add(ownBoat);
		
		JButton acceptButtonBoat = new JButton("Ajouter");
		acceptButtonBoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Bateau boat = null;
					if (idBoat.getText().equals("") || idBoat.getText().equals("Id"))
					{
						// New boat with automaticaly generated Id
						boat = new Bateau();
						JOptionPane.showMessageDialog(null, "L'id du bateau n'a pas été déterminé, il sera généré automatiquement", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (Integer.parseInt(idBoat.getText()) > 0)
					{
						if (daoboat.getById(Integer.parseInt(idBoat.getText())) == null)
						{
							boat = new Bateau(Integer.parseInt(idBoat.getText()));
						}
						else
						{
							throw (new AlreadyExistingIdException());
						}
					}
					else
						throw (new NumberFormatException());
					// Filling the rest of the informations
					boat.setNomBateau(nameBoat.getText());
					boat.setAssurance(insuBoat.getText());
					boat.setNumeroSerie(numBoat.getText());
					boat.setModele((Modele) modelBoat.getSelectedItem());
					boat.setPortOrigine((Port) portBoat.getSelectedItem());
					boat.setProprietaire((Proprietaire) ownBoat.getSelectedItem());
					daoboat.insert(boat);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Vous devez entrer un entier pour l'id ou laisser la case vide pour un id automatique, " +
							"le numéro de série du bateau doit être un entier", "Erreur d'id", JOptionPane.ERROR_MESSAGE);
				}
				catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Vous devez entrer un nom de bateau et une assurance valide", "Erreur de nom", JOptionPane.ERROR_MESSAGE);
				}
				catch (AlreadyExistingIdException e3) {
					JOptionPane.showMessageDialog(null, "L'id indiqué existe déjà, vous devez choisir un identifiant unique", "Erreur d'id", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		boatPanel.add(acceptButtonBoat);
		this.add(boatPanel);
		
		/*
		 * Owner adding section
		 */
	
		JSeparator separ1 = new JSeparator(SwingConstants.HORIZONTAL);
		this.add(separ1);
		
		JPanel ownerPanel = new JPanel();
		ownerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		ownerPanel.add(new JLabel("Propriétaire"));
		
		// owner name
		idOwner.setToolTipText("Identifiant");
		idOwner.setText("Id");
		
		// owner name
		nameOwner.setToolTipText("Nom");
		nameOwner.setText("Nom");
		
		// owner's address
		addressOwner.setToolTipText("Adresse du propriétaire");
		addressOwner.setText("Adresse");
		
		// phone number
		phoneOwner.setToolTipText("N° Téléphone");
		phoneOwner.setText("Téléphone");
		
		ownerPanel.add(idOwner);
		ownerPanel.add(nameOwner);
		ownerPanel.add(addressOwner);
		ownerPanel.add(phoneOwner);
		
		JButton acceptButtonOwner = new JButton("Ajouter");
		acceptButtonOwner.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Proprietaire owner = null;
					if (idOwner.getText().equals("") || idOwner.getText().equals("Id"))
					{
						// New boat with automaticaly generated Id
						owner = new Proprietaire();
						JOptionPane.showMessageDialog(null, "L'identifiant n'a pas été déterminé, il sera généré automatiquement", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (Integer.parseInt(idOwner.getText()) > 0)
					{
						if (daoowner.getById(Integer.parseInt(idOwner.getText())) == null)
						{
							owner = new Proprietaire(Integer.parseInt(idOwner.getText()));
						}
						else
						{
							throw (new AlreadyExistingIdException());
						}
					}
					else
						throw (new NumberFormatException());
					// Filling the rest of the informations
					owner.setNom(nameOwner.getText());
					owner.setAdresse(addressOwner.getText());
					owner.setTelephone(numBoat.getText());
					daoowner.insert(owner);
					refreshOwnBoat();
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Vous devez entrer un entier pour l'id ou laisser la case vide pour un id automatique", "Erreur d'identifiant", JOptionPane.ERROR_MESSAGE);
				}
				catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Vous devez entrer un nom, un telephone et une adresse valide", "Erreur de nom", JOptionPane.ERROR_MESSAGE);
				}
				catch (AlreadyExistingIdException e3) {
					JOptionPane.showMessageDialog(null, "L'id indiqué existe déjà, vous devez choisir un identifiant unique", "Erreur d'id", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		ownerPanel.add(acceptButtonOwner);
		this.add(ownerPanel);
		
		JSeparator separ2 = new JSeparator(SwingConstants.HORIZONTAL);
		this.add(separ2);
	}
	
	public void refreshOwnBoat ()
	{
		daoowner = daof.createDAOProprietaire();
		ownBoat.removeAll();
		proprietaires = daoowner.FindAll();
		// boat owner -- list with all the currently known owners
		ownBoat.setToolTipText("Proprietaire");
		for (Proprietaire p : proprietaires)
		{
			ownBoat.addItem(p);
		}
	}
	
	public void refreshPortBoat ()
	{
		daoport = daof.createDAOPort();
		// portBoat.removeAll();
		portBoat.removeAllItems();
		ports = daoport.FindAll();
		// boat owner -- list with all the currently known owners
		portBoat.setToolTipText("Port");
		for (Port p : ports)
		{
			portBoat.addItem(p);
		}
		portBoat.addItem("Ajouter ...");
	}
	
	public void refreshModelBoat ()
	{
		daomodel = daof.createDAOModele();
		modelBoat.removeAllItems();
		models = daomodel.FindAll();
		modelBoat.setToolTipText("Modele");
		for (Modele m : models)
		{
			modelBoat.addItem(m);
		}
		modelBoat.addItem("Ajouter ...");
	}

}
