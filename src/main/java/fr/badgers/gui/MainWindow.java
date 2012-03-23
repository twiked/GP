package fr.badgers.gui;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JButton;

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
		
		JPanel panel_1 = new JPanel();
		mainpanel.addTab("Affectation", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		mainpanel.addTab("Statistiques", null, panel_2, null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		mainpanel.addTab("Sortie", null, panel, null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Propriétaire");
		panel.add(comboBox);
	}
}
