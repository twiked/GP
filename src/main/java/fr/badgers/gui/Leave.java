package fr.badgers.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerDateModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import fr.badgers.model.Bateau;
import fr.badgers.model.Proprietaire;
import fr.badgers.model.dao.DAOBateau;
import fr.badgers.model.dao.DAOProprietaire;
import fr.badgers.model.dao.jpa.DAOFactoryJPA;

public class Leave extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Proprietaire currentProp;
	private Bateau currentBoat;
	
	private DAOProprietaire daop;
	private DAOBateau daob;
	
	private List<Proprietaire> proprietaires;
	private List<Bateau> bateaux;
	private JSpinner spinner;
	
	public Leave(EntityManager em) {
		super();
		
		DAOFactoryJPA daof = new DAOFactoryJPA(em);
		
		// All owners of a boat
		daop = daof.createDAOProprietaire();
		proprietaires = daop.FindAll();
		
		// All boats
		DAOBateau daob = daof.createDAOBateau();
		bateaux = daob.FindAll();
		
		spinner = null;
		
		// An empty 'Proprietaire' to fill with the currently selected owner
		currentProp = null;
		// An empty 'Bateau' to fill with the currently selected boat
		currentBoat = null;
		/*
		 * Upper panel
		 */

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		this.add(verticalStrut_1);
		this.add(splitPane_1);
		
		JPanel panel_3 = new JPanel();
		splitPane_1.setLeftComponent(panel_3);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("77px"),
				ColumnSpec.decode("28px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("28px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("20px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("87px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("98px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JComboBox comboBox_1 = new JComboBox();
		// We fill comboBox_1 with proprietaires
		currentProp = null;
		comboBox_1.addItem("");
		for (Proprietaire p : proprietaires) {
			comboBox_1.addItem(p.getNom());
		}
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				for (Proprietaire prop : proprietaires) {
					if (box.getSelectedItem().equals(""))
					{
						currentProp = null;
					}
					else if (prop.getNom().equals(box.getSelectedItem())) {
						currentProp = prop;
					}
				}
			}
		});
		comboBox_1.setToolTipText("Propriétaire");
		panel_3.add(comboBox_1, "2, 2, left, top");

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("");
		comboBox_2.setToolTipText("Bateau");
		for (Bateau b : bateaux)
		{
			comboBox_2.addItem(b.getNomBateau());
		}
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				for (Bateau bate : bateaux) {
					if (box.getSelectedItem().equals(""))
					{
						currentBoat = null;
					}
					else if (bate.getNomBateau().equals(box.getSelectedItem())) {
						currentBoat = bate;
					}
				}
			}
		});
		panel_3.add(comboBox_2, "4, 2, left, top");
		
		JLabel lblDateDepart = new JLabel("Date depart");
		panel_3.add(lblDateDepart, "8, 4");
		
		spinner = new JSpinner(new SpinnerDateModel());
		panel_3.add(spinner, "10, 4, left, top");
		
		JLabel lblDateRetourPrevu = new JLabel("Date retour");
		panel_3.add(lblDateRetourPrevu, "8, 6, left, center");
		
		JSpinner spinner_1 = new JSpinner(new SpinnerDateModel());
		panel_3.add(spinner_1, "10, 6");

		/*
		 * Lower panel
		 */

		JPanel panel_4 = new JPanel();
		splitPane_1.setRightComponent(panel_4);
		
				JLabel label = new JLabel("Retour");
				panel_4.add(label);

		JButton btnConfirmEntre = new JButton("Confirmer retour");
		panel_4.add(btnConfirmEntre);
		btnConfirmEntre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(currentProp);
				System.out.println(currentBoat);
				System.out.println(spinner.getValue());
			}
		});

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_4.add(rigidArea_1);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel_4.add(rigidArea);

		JButton btnConfirmSortie = new JButton("Confirmer sortie");
		panel_4.add(btnConfirmSortie);

		JLabel lblSortie = new JLabel("Sortie");
		panel_4.add(lblSortie);
		btnConfirmSortie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}
