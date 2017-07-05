package tp3.presentationLayer;

import javax.swing.*;

import tp3.Etudiant;
import tp3.Filiere;
import tp3.businessLogicLayer.EtudiantDAO;
import tp3.businessLogicLayer.FiliereDAO;

import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JUpdateStudent extends JInternalFrame {
	// static int openFrameCount = 0;
	static final int xOffset = 0, yOffset = 70;
	private JTextField txtnum, txtnom, txtprenom, txtorg, txtville, txtadresse;
	private JFormattedTextField txttel;
	JComboBox cbFiliere;
	private Etudiant et;
	private FiliereDAO fdao;
	private EtudiantDAO etda;
	
	public JUpdateStudent() {

		super("MODIFIER LES INFORMATIONS D'UN ETUDIANT : ", true, // resizable
				true, // closable
				true, // maximizable
				true);

		setLocation(xOffset, yOffset);
		setSize(1000, 529);
		getContentPane().setLayout(null);

		JLabel lblInternalJframe = new JLabel("MODIFIER UN ETUDIANT");
		lblInternalJframe.setHorizontalAlignment(SwingConstants.CENTER);
		lblInternalJframe.setForeground(new Color(128, 0, 0));
		lblInternalJframe.setFont(new Font("Arial", Font.BOLD, 22));
		lblInternalJframe.setBounds(0, 0, 984, 39);
		getContentPane().add(lblInternalJframe);

		txttel = new JFormattedTextField();
		txtnum=new JTextField();
		txtadresse = new JTextField();
		cbFiliere = new JComboBox();

//		cbFiliere.setModel(
//				new DefaultComboBoxModel(new String[] { "G\u00E9nie Informatique", "G\u00E9nie Electronique" }));
		for(Filiere f:new FiliereDAO().getAll())
			cbFiliere.addItem(f.getIdFil()+" : "+f.getIntitule());
		cbFiliere.setBounds(103, 359, 254, 20);
		getContentPane().add(cbFiliere);
		
		
		JComboBox cbStudent = new JComboBox();
		for(Etudiant etu : new EtudiantDAO().getAll())
			cbStudent.addItem(etu.getNum()+" : "+etu.getNom());
		
		//cbStudent.setModel(new DefaultComboBoxModel(comboMod));
		cbStudent.setBounds(420, 54, 254, 20);
		getContentPane().add(cbStudent);
		cbStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numEtu=Integer.parseInt(cbStudent.getSelectedItem().toString().split("(:)")[0].trim());
				//JOptionPane.showMessageDialog(null, new EtudiantDAO().getById(numEtu).getNom());
				try{
					//extraction de l étudiant
					et=new EtudiantDAO().getById(numEtu);
					//alimention des champs
					txtnum.setText(""+et.getNum());
					txtnom.setText(et.getNom());
					txtprenom.setText(et.getPrenomEtu());
					txtorg.setText(et.getOrganisation());
					txtville.setText(et.getVille());
					txttel.setText(et.getTel());
					txtadresse.setText(et.getAdresse());
					//extraction des filières
					fdao=new FiliereDAO();
					List<Filiere> lf=fdao.getAll();
					String[] modFiliere=new String[lf.size()];
					int a=0,b=0;
					for(Filiere f:lf){
						if(f.getIdFil()==et.getFiliere().getIdFil()) b=a;
						modFiliere[a]=f.getIdFil()+" : "+f.getIntitule();
						a++;
					}
					//alimentation de la liste de choix
					cbFiliere.setModel(new DefaultComboBoxModel<>(modFiliere));
					cbFiliere.setSelectedIndex(b);
					
				}catch(Exception ex){
					ex.getStackTrace();
					JOptionPane.showMessageDialog(null,"Veuillez vérifier la connexion au serveur",
							"Problème de connexion : ",JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		
		
		JLabel lblNumro = new JLabel("Veuillez Choisir un Etudiant à modifier :");
		lblNumro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumro.setBounds(10, 54, 400, 20);
		getContentPane().add(lblNumro);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(93, 127, 46, 14);
		getContentPane().add(lblNom);

		JLabel lblVille = new JLabel("Pr\u00E9nom :");
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVille.setBounds(537, 127, 82, 14);
		getContentPane().add(lblVille);

		
		txtnom = new JTextField();
		txtnom.setBounds(103, 152, 195, 20);
		getContentPane().add(txtnom);
		txtnom.setColumns(10);

		txtprenom = new JTextField();
		txtprenom.setBounds(547, 152, 195, 20);
		getContentPane().add(txtprenom);
		txtprenom.setColumns(10);

		JButton btnEscape = new JButton("Annuler");
		btnEscape.setBounds(433, 455, 113, 23);
		getContentPane().add(btnEscape);
		btnEscape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JUpdateStudent.this.doDefaultCloseAction();
		
			}
		});

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresse.setBounds(93, 189, 96, 14);
		getContentPane().add(lblAdresse);

		
		txtadresse.setBounds(103, 214, 254, 20);
		getContentPane().add(txtadresse);

		JLabel lblOrganisation = new JLabel("Organisation :");
		lblOrganisation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOrganisation.setBounds(93, 256, 114, 20);
		getContentPane().add(lblOrganisation);

		txtorg = new JTextField();
		txtorg.setBounds(103, 287, 254, 20);
		getContentPane().add(txtorg);
		txtorg.setColumns(10);

		JLabel lblVille_1 = new JLabel("Ville :");
		lblVille_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVille_1.setBounds(537, 262, 46, 14);
		getContentPane().add(lblVille_1);

		txtville = new JTextField();
		txtville.setBounds(547, 287, 254, 20);
		getContentPane().add(txtville);
		txtville.setColumns(10);

		JLabel lblGsm = new JLabel("GSM :");
		lblGsm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGsm.setBounds(537, 186, 114, 20);
		getContentPane().add(lblGsm);

		txttel.setBounds(547, 214, 254, 20);
		getContentPane().add(txttel);

		JLabel lblFailSuccess = new JLabel("");
		lblFailSuccess.setForeground(new Color(255, 0, 0));
		lblFailSuccess.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFailSuccess.setBounds(161, 470, 324, 30);
		getContentPane().add(lblFailSuccess);

		
		

		JLabel lblFilire = new JLabel("Fili\u00E8re :");
		lblFilire.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFilire.setBounds(93, 334, 82, 14);
		getContentPane().add(lblFilire);

		JButton btnSave = new JButton("Enregistrer");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fdao = new FiliereDAO();
				//JOptionPane.showMessageDialog(null, cbFiliere.getSelectedItem().toString().split("(:)")[0].trim());
				Filiere f = new Filiere(Integer.parseInt(cbFiliere.getSelectedItem().toString().split("(:)")[0].trim()),
						cbFiliere.getSelectedItem().toString().split("(:)")[1].trim());
				et = new Etudiant(Integer.parseInt(txtnum.getText()),
						txtnom.getText(),
						txtprenom.getText(),
						txtadresse.getText(),
						txttel.getText(),
						txtorg.getText(),
						txtville.getText(),
						f);
				if (new EtudiantDAO().update(et) == true) {
					JOptionPane.showMessageDialog(null,"Etudiant modifié avec succés",
							"Modification d'un étudiant : "+txtnum.getText(),JOptionPane.INFORMATION_MESSAGE); 
					cbStudent.removeAllItems();
					for(Etudiant etu : new EtudiantDAO().getAll())
						cbStudent.addItem(etu.getNum()+" : "+etu.getNom());
					
					txtnum.setText("");
					txtnum.requestFocus();
					txtnom.setText("");
					txtprenom.setText("");
					txtadresse.setText("");
					txttel.setText("");
					txtorg.setText("");
					txtville.setText("");
				} else {
					JOptionPane.showMessageDialog(null,"Modification échouée",
							"Problème de mise à jour ",JOptionPane.ERROR_MESSAGE); ;
					txtnom.requestFocus();
				}
			}
		});

		btnSave.setBounds(161, 455, 111, 23);
		getContentPane().add(btnSave);

	}
}
