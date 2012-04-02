package fr.badgers.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.badgers.AlreadyExistingIdException;
import fr.badgers.TooLongIdException;
import fr.badgers.model.Port;
import fr.badgers.model.dao.DAOPort;
import fr.badgers.model.dao.jpa.DAOFactoryJPA;

public class NewPortDial extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	JTextField codePort = new JTextField(2);
	JTextField namePort = new JTextField(8);

	DAOFactoryJPA daof = null;

	DAOPort daoport = null;

	private List<Port> ports = null;
	JFrame parent = null;

	public NewPortDial(JFrame parent, String title, boolean modal, EntityManager em) {
		super(parent, title, modal);
		this.parent = parent;
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		this.initComponent(em);
		this.setVisible(true);
	}

	private void initComponent(EntityManager em) {
		this.em = em;
		daof = new DAOFactoryJPA(em);
		daoport = daof.createDAOPort();
		ports = daoport.FindAll();

		JPanel portPanel = new JPanel();
		portPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		portPanel.add(new JLabel("Port"));

		codePort.setToolTipText("Code Bateau");
		codePort.setText("Code");
		
		namePort.setToolTipText("Nom Port");
		namePort.setText("Nom");
		
		JButton acceptButtonPort = new JButton("Ajouter");
		acceptButtonPort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (codePort.getText().length() > 2) {
						throw new TooLongIdException();
					}
					else if (daoport.getById(codePort.getText()) != null)
					{
						throw new AlreadyExistingIdException();
					}
					Port port = new Port(codePort.getText());
					port.setNom(namePort.getText());
					daoport.insert(port);
				} catch (TooLongIdException e1) {
					JOptionPane.showMessageDialog(null, "Le code du port doit avoir uniquement deux charactères", "Erreur de code", JOptionPane.ERROR_MESSAGE);
				}
				catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Les deux valeurs doivent être remplies pour créer un port", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				catch (AlreadyExistingIdException e3) {
					JOptionPane.showMessageDialog(null, "L'id du port doit être unique, celui indiqué existe déjà", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		portPanel.add(codePort);
		portPanel.add(namePort);
		
		portPanel.add(acceptButtonPort);
		
		this.add(portPanel);
	}

}
