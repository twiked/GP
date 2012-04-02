package fr.badgers.gui;

import javax.persistence.EntityManager;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainPanel extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6892256375053106268L;
	private EntityManager em;

	/**
	 * Create the panel.
	 */
	public MainPanel(EntityManager em) {
		
		this.em = em;
		/*
		 * Affectation tab
		 */

		JPanel panel_1 = new Affectation(em);
		this.addTab("Affectation", null, panel_1, null);

		/*
		 * Statistiques tab
		 */

		JPanel stat_tab = new Statistics(em);
		this.addTab("Statistiques", null, stat_tab, null);

		/*
		 * Sorties tab
		 */

		JPanel panel = new Leave(em);
		panel.setToolTipText("");
		this.addTab("Sorties", null, panel, null);
	}

}
