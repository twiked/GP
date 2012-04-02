package fr.badgers.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import fr.badgers.Translator;
import fr.badgers.model.Bateau;
import fr.badgers.model.Proprietaire;
import fr.badgers.model.dao.DAOBateau;
import fr.badgers.model.dao.DAOProprietaire;
import fr.badgers.model.dao.jpa.DAOFactoryJPA;

public class MainWindow {

	private JFrame frame;
	private EntityManager em;

	/**
	 * Create the application.
	 */
	public MainWindow(EntityManager em) {
		this.em = em;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//We don't make use of it yet, it should be static to this class or App class
		Translator t = new Translator("fr_FR");
		frame = new JFrame(t.translate("MainWindow.title"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel mainpanel = new MainPanel(em);
		frame.getContentPane().add(mainpanel);
		frame.pack();
		frame.setVisible(true);
		frame.setMinimumSize(frame.getSize());
	}
}
