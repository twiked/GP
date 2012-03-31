package fr.badgers.gui;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Statistics extends JPanel{
	EntityManager em;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Statistics(EntityManager em) {
		super();
		this.em = em;
		this.add(new JButton());
	}

}
