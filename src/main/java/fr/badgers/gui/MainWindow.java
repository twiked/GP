package fr.badgers.gui;

import javax.persistence.EntityManager;
import javax.swing.JFrame;
import fr.badgers.Translator;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		//We don't use it yet, btw it should be static to this class or App class
		Translator t = new Translator("fr_FR");
		this.setTitle(t.translate("MainWindow.title"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel mainpanel = new MainPanel(em);
		this.getContentPane().add(mainpanel);
		this.pack();
		this.setVisible(true);
		this.setMinimumSize(this.getSize());
	}
}
