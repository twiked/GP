package fr.badgers.gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerDateModel;
import fr.badgers.model.*;
import fr.badgers.model.dao.DAOBateau;
import fr.badgers.model.dao.DAOProprietaire;
import fr.badgers.model.dao.jpa.DAOFactoryJPA;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("GP");
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
		 * Initialize the values we will be using later
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GP");
		EntityManager em = emf.createEntityManager();

		DAOFactoryJPA daof = new DAOFactoryJPA(em);
		// All owners of a boat 
		DAOProprietaire daop = daof.createDAOProprietaire();
		List<Proprietaire> proprietaires = daop.FindAll();
		// All boats
		DAOBateau daob = daof.createDAOBateau();
		List<Bateau> bateaux = daob.FindAll();
		// An empty 'Proprietaire' to fill with the currently selected owner
		Proprietaire currentProp = null;
		// An empty 'Bateau' to fill with the currently selected boat
		Bateau currentBoat = null;
		
		/*
		 * Affectation tab
		 */
		
		JPanel panel_1 = new JPanel();
		mainpanel.addTab("Affectation", null, panel_1, null);
		
		/*
		 * Statistiques tab
		 */
		
		JPanel panel_2 = new JPanel();
		mainpanel.addTab("Statistiques", null, panel_2, null);
		
		/*
		 * Sorties tab
		 */
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		mainpanel.addTab("Sorties", null, panel, null);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1);
		panel.add(splitPane_1);
		
		/*
		 * Left panel
		 */
		
		JPanel panel_3 = new JPanel();
		splitPane_1.setLeftComponent(panel_3);
		FlowLayout fl_panel_3 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_3.setLayout(fl_panel_3);
		
		JLabel label = new JLabel("Retour");
		panel_3.add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				box.getSelectedItem();
			}
		});
		
		// We fill bomboBox_1 with proprietaires
		currentProp = proprietaires.get(0);
		comboBox_1.addItem("all");
		for (Proprietaire p : proprietaires)
		{
			comboBox_1.addItem(p.getNom());
		}
		panel_3.add(comboBox_1);
		comboBox_1.setToolTipText("Propriétaire");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("none");
		for (Bateau b : bateaux)
		{
			if (currentProp == null || comboBox_1.getSelectedItem().equals(b.getProprietaire()))
			{	// If currentProp is null it means we are selecting all the boats!
				comboBox_2.addItem(b.getNomBateau());
			}
		}
		comboBox_2.setToolTipText("Bateau");
		panel_3.add(comboBox_2);
		
		JSpinner spinner = new JSpinner(new SpinnerDateModel());
		panel_3.add(spinner);
		
		JButton btnConfirmEntre = new JButton("Valider");
		panel_3.add(btnConfirmEntre);
		btnConfirmEntre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		/*
		 * Right panel
		 */
		
		JPanel panel_4 = new JPanel();
		splitPane_1.setRightComponent(panel_4);
		
		JLabel lblSortie = new JLabel("Sortie");
		panel_4.add(lblSortie);
		
		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox);
		comboBox.setToolTipText("Propriétaire");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setToolTipText("Bateau");
		panel_4.add(comboBox_3);
		
		JSpinner spinner_1 = new JSpinner(new SpinnerDateModel());
		panel_4.add(spinner_1);
		
		JButton btnConfirmSortie = new JButton("Valider");
		panel_4.add(btnConfirmSortie);
		btnConfirmSortie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);
	}
}
