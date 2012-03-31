package fr.badgers.gui;

import javax.persistence.EntityManager;
import javax.swing.JPanel;

public class Affectation extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public Affectation(EntityManager em)  {
		super();
		this.em = em;
	}

}
