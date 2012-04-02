package fr.badgers.gui;

import javax.persistence.EntityManager;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainPanel extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6892256375053106268L;

	/**
	 * Create the panel.
	 */
	public MainPanel(EntityManager em) {
		/*
		 * Affectation tab
		 */

		this.addTab("Affectation", null, new Affectation(em), null);

		/*
		 * Statistiques tab
		 */

		this.addTab("Statistiques", null, new Statistics(em), null);

		/*
		 * Sorties tab
		 */

		this.addTab("Sorties", null, new Leave(em), null);
	}

}
