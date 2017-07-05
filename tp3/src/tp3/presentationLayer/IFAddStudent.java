package tp3.presentationLayer;

import javax.swing.*;

import tp3.Etudiant;
import tp3.Filiere;
import tp3.businessLogicLayer.EtudiantDAO;
import tp3.businessLogicLayer.FiliereDAO;

import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IFAddStudent extends JInternalFrame {
	// static int openFrameCount = 0;
	static final int xOffset = 0, yOffset = 70;
	private JTextField txtnum, txtnom, txtprenom, txtorg, txtville,txtadresse,txttel;

	public IFAddStudent() {

		super("Ajouter un \u00E9tudiant : ", true, // resizable
				true, // closable
				true, // maximizable
				true);

		setLocation(xOffset, yOffset);
		setSize(1000, 529);
		getContentPane().setLayout(null);

		JLabel lblInternalJframe = new JLabel("AJOUTER UN ETUDIANT");
		lblInternalJframe.setHorizontalAlignment(SwingConstants.CENTER);
		lblInternalJframe.setForeground(new Color(128, 0, 0));
		lblInternalJframe.setFont(new Font("Arial", Font.BOLD, 22));
		lblInternalJframe.setBounds(0, 0, 984, 39);
		getContentPane().add(lblInternalJframe);

		JLabel lblNumro = new JLabel("Num\u00E9ro :");
		lblNumro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumro.setBounds(93, 54, 82, 14);
		getContentPane().add(lblNumro);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(93, 127, 46, 14);
		getContentPane().add(lblNom);

		JLabel lblVille = new JLabel("Pr\u00E9nom :");
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVille.setBounds(537, 127, 82, 14);
		getContentPane().add(lblVille);

		txtnum = new JTextField();
		txtnum.setBounds(103, 79, 86, 20);
		getContentPane().add(txtnum);
		txtnum.setColumns(10);

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
				
				txtnum.setText("");
				txtnum.requestFocus();
				txtnom.setText("");
				txtprenom.setText("");
				txtadresse.setText("");
				txttel.setText("");
				txtorg.setText("");
				txtville.setText("");
			}
		});

		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(707, 455, 113, 23);
		getContentPane().add(btnNouveau);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresse.setBounds(93, 189, 96, 14);
		getContentPane().add(lblAdresse);

		txtadresse = new JTextField();
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

		txttel = new JTextField();
		// txttel.set
		txttel.setBounds(547, 214, 254, 20);
		getContentPane().add(txttel);

		JLabel lblFailSuccess = new JLabel("");
		lblFailSuccess.setForeground(new Color(255, 0, 0));
		lblFailSuccess.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFailSuccess.setBounds(161, 470, 324, 30);
		getContentPane().add(lblFailSuccess);

		JComboBox cbFiliere = new JComboBox();
		for(Filiere F : new FiliereDAO().getAll())
			cbFiliere.addItem(F.getIdFil()+ " : "+F.getIntitule());
		//cbFiliere.setModel(new DefaultComboBoxModel(new String[] { "G\u00E9nie Informatique", "G\u00E9nie Electronique" }));
		cbFiliere.setBounds(103, 359, 254, 20);
		getContentPane().add(cbFiliere);

		JLabel lblFilire = new JLabel("Fili\u00E8re :");
		lblFilire.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFilire.setBounds(93, 334, 82, 14);
		getContentPane().add(lblFilire);

		JButton btnSave = new JButton("Enregistrer");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Filiere = cbFiliere.getSelectedItem().toString().split(":")[1].trim();
				int id = Integer.parseInt(cbFiliere.getSelectedItem().toString().split("(:)")[0].trim());
				Etudiant etd = new Etudiant(Integer.parseInt(txtnum.getText()), txtnom.getText(), txtprenom.getText(),
						txtadresse.getText(), txttel.getText(), txtorg.getText(), txtville.getText(), new Filiere(id,Filiere));
				EtudiantDAO etDao = new EtudiantDAO();
				if (etDao.create(etd) == true) {
					JOptionPane.showConfirmDialog(null,"Etudiant créé avec succées");
					txtnum.setText("");
					txtnum.requestFocus();
					txtnom.setText("");
					txtprenom.setText("");
					txtadresse.setText("");
					txttel.setText("");
					txtorg.setText("");
					txtville.setText("");
				} else {
					JOptionPane.showConfirmDialog(null,"Echec de création veuillez entrer un nouveau numéro");
					txtnom.requestFocus();
				}
			}
		});

		btnSave.setBounds(161, 455, 111, 23);
		getContentPane().add(btnSave);

	}
}
