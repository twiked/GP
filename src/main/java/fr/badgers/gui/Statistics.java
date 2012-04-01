package fr.badgers.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.badgers.model.Bateau;
import fr.badgers.model.Emplacement;
import fr.badgers.model.Modele;
import fr.badgers.model.Proprietaire;
import fr.badgers.model.Sortir;
import fr.badgers.model.dao.jpa.DAOBateauJPA;
import fr.badgers.model.dao.jpa.DAOEmplacementJPA;
import fr.badgers.model.dao.jpa.DAOModeleJPA;
import fr.badgers.model.dao.jpa.DAOProprietaireJPA;
import fr.badgers.model.dao.jpa.DAOSortirJPA;

public class Statistics extends JPanel {
	EntityManager em;
	private JLabel propDisplay;
	private JLabel boatDisplay;
	private JLabel modelDisplay;
	private JLabel poolDisplay;
	private JSpinner since;
	
	DAOProprietaireJPA daop;
	List<Proprietaire> props;
	DAOBateauJPA daob;
	List<Bateau> boats;
	DAOModeleJPA daom;;
	List<Modele> models;
	DAOSortirJPA daos;
	List<Sortir> sorties;
	DAOEmplacementJPA daoe;
	List<Emplacement> emplacements;

	private static final long serialVersionUID = 1L;

	public Statistics(EntityManager em) {
		super();
		this.em = em;

		daop = new DAOProprietaireJPA(em);
		props = daop.FindAll();
		daob = new DAOBateauJPA(em);
		boats = daob.FindAll();
		daom = new DAOModeleJPA(em);
		models = daom.FindAll();
		daos = new DAOSortirJPA(em);
		sorties = daos.FindAll();
		daoe = new DAOEmplacementJPA(em);
		emplacements = daoe.FindAll();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//Owner
		JPanel propPanel = new JPanel();
		propPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		propPanel.add(new JLabel("Propriétaire"));
		propDisplay = new JLabel();
		JComboBox propComboBox = new JComboBox();
		propComboBox.addItem("Propriétaire");
		for (Proprietaire p : props)
			propComboBox.addItem(p);
		propComboBox.addActionListener(new propActionListener());
		
		propPanel.add(propComboBox);
		propPanel.add(propDisplay);
		
		//Boat
		JPanel boatPanel = new JPanel();
		boatPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		JComboBox boatComboBox = new JComboBox();
		boatComboBox.addItem("Bateau");
		boatDisplay = new JLabel();
		for(Bateau b : boats)
			boatComboBox.addItem(b);
		boatComboBox.addActionListener(new boatActionListener());
		boatPanel.add(new JLabel("Bateau"));
		
		boatPanel.add(boatComboBox);
		boatPanel.add(boatDisplay);
		
		
		//Model
		JPanel modelPanel = new JPanel();
		modelPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		JComboBox modelComboBox = new JComboBox();
		modelComboBox.addItem("Modèle");
		modelDisplay = new JLabel("N/A", 4);
		for(Modele m : models)
			modelComboBox.addItem(m);
		modelComboBox.addActionListener(new modelActionListener());
				
		modelPanel.add(modelComboBox);
		modelPanel.add(modelDisplay);
		
		//Pool
		JPanel bassinPanel = new JPanel();
		bassinPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		poolDisplay = new JLabel("N/A");
		
		bassinPanel.add(new JLabel("Bassin"));
		bassinPanel.add(new JLabel("Nombre de sorties depuis"));
		since = new JSpinner(new SpinnerDateModel());
		bassinPanel.add(since);
		bassinPanel.add(poolDisplay);

		// Adding widgets to the main panel
		this.add(propPanel);
		this.add(new JSeparator(JSeparator.HORIZONTAL));
		this.add(boatPanel);
		this.add(new JSeparator(JSeparator.HORIZONTAL));
		this.add(modelPanel);
		this.add(new JSeparator(JSeparator.HORIZONTAL));
		this.add(bassinPanel);
	}

	private class propActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JComboBox jc = (JComboBox) arg0.getSource();
			if(jc.getSelectedIndex() != 0) {
				propDisplay.setText(String.valueOf(((Proprietaire) (jc.getSelectedItem()))
						.getBateaux().size()));
			}
			else
				propDisplay.setText("N/A");
		}
	}
	private class boatActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JComboBox jc = (JComboBox) arg0.getSource();
			if(jc.getSelectedIndex() != 0) {
				Bateau b = (Bateau) jc.getSelectedItem();
				int count = 0;
				for (Sortir s : sorties)
					if (s.getResident().equals(b))
							count += 1;
				boatDisplay.setText(String.valueOf(count));
			}
			else
				boatDisplay.setText("N/A");
		}
	}
	private class modelActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JComboBox jc = (JComboBox) arg0.getSource();
			if(jc.getSelectedIndex() != 0) {
				int count = 0;
				for(Bateau b : boats) {
					if(b.getModele().equals((Modele) jc.getSelectedItem()))
						count++;
				}
				modelDisplay.setText(String.valueOf(count));
			}
			else
				modelDisplay.setText("N/A");
		}
	}
	
	private class poolChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent arg0) {
			//TODO
			((SpinnerDateModel) since.getModel()).getDate();
		}
		
	}
}
