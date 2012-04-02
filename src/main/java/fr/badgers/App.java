package fr.badgers;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.badgers.gui.MainWindow;

/**
 * Main class of program
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntityManagerFactory emf = Persistence
							.createEntityManagerFactory("GP");
					EntityManager em = emf.createEntityManager();

					new MainWindow(em);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
