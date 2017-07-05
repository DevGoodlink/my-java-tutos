package tp3.presentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import tp3.Filiere;
import tp3.businessLogicLayer.FiliereDAO;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class JUpdateFiliere extends JInternalFrame {
	static final int xOffset = 0, yOffset = 70;
	private JTextField txtIntitFiliere;
	private JTextField txtIdFiliere;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JUpdateFiliere frame = new JUpdateFiliere();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JUpdateFiliere() {
		super("Ajouter un \u00E9tudiant : ", true, // resizable
				true, // closable
				true, // maximizable
				true);
		setSize(1000, 529);
		getContentPane().setLayout(null);
		setLocation(xOffset, yOffset);
		JLabel lblInternalJframe = new JLabel("MISE A JOUR DES FILIERES");
		lblInternalJframe.setBounds(0, 0, 984, 39);
		lblInternalJframe.setHorizontalAlignment(SwingConstants.CENTER);
		lblInternalJframe.setForeground(new Color(128, 0, 0));
		lblInternalJframe.setFont(new Font("Arial", Font.BOLD, 22));
		getContentPane().add(lblInternalJframe);
		
		JLabel lblIntitulFilire = new JLabel("Intitul\u00E9 Fili\u00E8re :");
		lblIntitulFilire.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntitulFilire.setBounds(55, 168, 148, 25);
		getContentPane().add(lblIntitulFilire);
		
		txtIntitFiliere = new JTextField();
		txtIntitFiliere.setBounds(99, 203, 249, 20);
		getContentPane().add(txtIntitFiliere);
		txtIntitFiliere.setColumns(20);
		
		txtIdFiliere = new JTextField();
		txtIdFiliere.setBounds(99, 137, 125, 20);
		getContentPane().add(txtIdFiliere);
		
		JLabel lblIdFilire = new JLabel("ID Fili\u00E8re :");
		lblIdFilire.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIdFilire.setBounds(55, 102, 148, 25);
		getContentPane().add(lblIdFilire);
		DefaultListModel<Filiere> lsM= new DefaultListModel<Filiere>();
		
		for(Filiere f : new FiliereDAO().getAll())
			lsM.addElement(f);
		
		JList<Filiere> list=new JList<Filiere>(lsM);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filiere f = new Filiere();
				try{
				f.setIdFil(Integer.parseInt(txtIdFiliere.getText()));
				f.setIntitule(txtIntitFiliere.getText());
				if(new FiliereDAO().create(f)==true){
				JOptionPane.showMessageDialog(null, "Filière Créée avec succés",
						"Création de filière",JOptionPane.INFORMATION_MESSAGE);
				txtIdFiliere.setText("");
				txtIntitFiliere.setText("");
				for(Filiere fi : new FiliereDAO().getAll())
					lsM.addElement(fi);
				
				list.setModel(lsM);
				
				}else{
					JOptionPane.showMessageDialog(null, "Problème de création de filière",
							"Problème création de filière",JOptionPane.INFORMATION_MESSAGE);
				}
				}catch(Exception e )
				{
					JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de la création de la nouvelle filiere",
							"Erreur de création de filière",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEnregistrer.setBounds(120, 391, 100, 23);
		getContentPane().add(btnEnregistrer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtIdFiliere.setText("");
				txtIntitFiliere.setText("");
			}
		});
		btnAnnuler.setBounds(274, 391, 100, 23);
		getContentPane().add(btnAnnuler);
		
		
		list.setBounds(544, 73, 290, 289);
		
		getContentPane().add(list);
		
		

	}
}
