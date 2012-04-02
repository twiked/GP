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
import fr.badgers.model.Modele;
import fr.badgers.model.dao.DAOModele;
import fr.badgers.model.dao.jpa.DAOFactoryJPA;

public class NewModelDial extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	JTextField idModele = new JTextField(2);
	JTextField serie = new JTextField(6);
	JTextField type = new JTextField(8);
	JTextField constructeur = new JTextField(8);
	JTextField longueur = new JTextField(2);
	JTextField largeur = new JTextField(2);
	JTextField tirant = new JTextField(2);

	DAOFactoryJPA daof = null;

	DAOModele daomodel = null;

	private List<Modele> models = null;
	JFrame parent = null;

	public NewModelDial(JFrame parent, String title, boolean modal, EntityManager em) {
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
		daomodel = daof.createDAOModele();
		models = daomodel.FindAll();

		JPanel modelPanel = new JPanel();
		modelPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		modelPanel.add(new JLabel("Modele"));

		idModele.setToolTipText("Id Modele");
		idModele.setText("Id");
		
		serie.setToolTipText("Serie");
		serie.setText("Serie");
		
		type.setToolTipText("Type");
		type.setText("Type");
		
		constructeur.setToolTipText("Constructeur");
		constructeur.setText("Constructeur");
		
		longueur.setToolTipText("Longueur");
		longueur.setText("Long");
		
		largeur.setToolTipText("Largeur");
		largeur.setText("Larg");
		
		tirant.setToolTipText("Tirant");
		tirant.setText("Tirant");
		
		JButton acceptButtonPort = new JButton("Ajouter");
		acceptButtonPort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (daomodel.getById(Integer.parseInt(idModele.getText())) != null)
					{
						throw new AlreadyExistingIdException();
					}
					if (Integer.parseInt(largeur.getText()) < 0 
							|| Integer.parseInt(longueur.getText()) < 0
							|| Integer.parseInt(tirant.getText()) < 0)
					{
						throw new NumberFormatException();
					}
					Modele model = new Modele();
					model.setSérie(serie.getText());
					model.setConstructeur(constructeur.getText());
					model.setLargeur(Integer.parseInt(largeur.getText()));
					model.setLongueur(Integer.parseInt(longueur.getText()));
					model.setTirant(Integer.parseInt(tirant.getText()));
					model.setType(type.getText());
					daomodel.insert(model);
				}
				catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Tout les champ doivent être renseigné", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				catch (AlreadyExistingIdException e2) {
					JOptionPane.showMessageDialog(null, "L'id du modele doit être unique, celui indiqué existe déjà", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(null, "La largeur, la longueur et le tirant doivent être des entiers positifs", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		modelPanel.add(idModele);
		modelPanel.add(serie);
		modelPanel.add(type);
		modelPanel.add(constructeur);
		modelPanel.add(largeur);
		modelPanel.add(longueur);
		modelPanel.add(tirant);
		
		modelPanel.add(acceptButtonPort);
		
		this.add(modelPanel);
	}

}
