package fr.badgers.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import fr.badgers.model.Bateau;
import fr.badgers.model.Proprietaire;
import fr.badgers.model.dao.DAOBateau;
import fr.badgers.model.dao.DAOProprietaire;
import fr.badgers.model.dao.jpa.DAOFactoryJPA;

public class MainWindow {

	private JFrame frame;

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("GP");
	EntityManager em = emf.createEntityManager();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntityManagerFactory emf = Persistence
							.createEntityManagerFactory("GP");
					EntityManager em = emf.createEntityManager();

					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel mainpanel = new MainPanel();
		frame.getContentPane().add(mainpanel);

		/*
		 * Affectation tab
		 */

		JPanel panel_1 = new Affectation(em);
		mainpanel.addTab("Affectation", null, panel_1, null);

		/*
		 * Statistiques tab
		 */

		JPanel stat_tab = new Statistics(em);
		mainpanel.addTab("Statistiques", null, stat_tab, null);

		/*
		 * Sorties tab
		 */

		JPanel panel = new Leave(em);
		panel.setToolTipText("");
		mainpanel.addTab("Sorties", null, panel, null);
	}
}
