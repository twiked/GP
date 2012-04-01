package fr.badgers.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

public class Statistics extends JPanel{
	EntityManager em;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Statistics(EntityManager em) {
		super();
		this.em = em;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel propPanel = new JPanel();
		propPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		propPanel.add(new JLabel("Propriétaire"));
		propPanel.add(new JComboBox());
		JTextField propDisplay = new JTextField("N/A",4);
		propPanel.add(propDisplay);
		
		JSeparator separ = new JSeparator(SwingConstants.HORIZONTAL);
		// separ.setPreferredSize(new Dimension(10,10));
		this.add(separ);
		
		JPanel boatPanel = new JPanel();
		boatPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		boatPanel.add(new JLabel("Bateau"));
		boatPanel.add(new JComboBox());
		JTextField boatDisplay = new JTextField("N/A",4);
		boatPanel.add(boatDisplay);
		
		JPanel modelPanel = new JPanel();
		modelPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		modelPanel.add(new JLabel("Modèle"));
		modelPanel.add(new JComboBox());
		JTextField modelDisplay = new JTextField("N/A",4);
		modelPanel.add(modelDisplay);
		
		JPanel bassinPanel = new JPanel();
		bassinPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		bassinPanel.add(new JLabel("Bassin"));
		bassinPanel.add(new JComboBox());
		bassinPanel.add(new JLabel("Nombre de sorties depuis"));
		bassinPanel.add(new JSpinner(new SpinnerDateModel()));
		JTextField bassinDisplay = new JTextField("N/A",4);
		bassinPanel.add(bassinDisplay);
		
		this.add(propPanel);
		this.add(new JSeparator(JSeparator.HORIZONTAL));
		this.add(boatPanel);
		this.add(new JSeparator(JSeparator.HORIZONTAL));
		this.add(modelPanel);
		this.add(new JSeparator(JSeparator.HORIZONTAL));
		this.add(bassinPanel);
	}

}
