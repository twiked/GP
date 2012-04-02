package fr.badgers.gui;

import javax.persistence.EntityManager;
import javax.swing.JFrame;
import fr.badgers.Translator;

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
