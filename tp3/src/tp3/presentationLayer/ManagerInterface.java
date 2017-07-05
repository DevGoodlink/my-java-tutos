package tp3.presentationLayer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.*;

public class ManagerInterface {

	public JFrame frame = new JFrame();
	private JDesktopPane desktop;

	public ManagerInterface() {

		desktop = new JDesktopPane();
		frame = new JFrame("Gestion des Etudiants : Menu principal");
		ImageIcon img = new ImageIcon(System.getProperty("user.dir")+"\\res\\Icons\\user.png");
		frame.setIconImage(img.getImage());
		frame.setContentPane(desktop);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Fichier");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAdd = new JMenuItem("Ajouter un étudiant");
		mnNewMenu.add(mntmAdd);
		mntmAdd.addActionListener(new ActionListener() {// add a student with
														// menu
			public void actionPerformed(ActionEvent e) {
				IFAddStudent iFrame = new IFAddStudent();
				desktop.add(iFrame);
				iFrame.show();
			}
		});
		JMenuItem mntmAddFilliere = new JMenuItem("Ajouter une Filière");
		mnNewMenu.add(mntmAddFilliere);
		mntmAddFilliere.addActionListener(new ActionListener() {// add a student with
														// menu
			public void actionPerformed(ActionEvent e) {
				JUpdateFiliere iFrame = new JUpdateFiliere();
				desktop.add(iFrame);
				iFrame.show();
			}
		});

		JMenuItem mntmFindAll = new JMenuItem("Afficher la liste des étudiants");
		mnNewMenu.add(mntmFindAll);
		mntmFindAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableauEtudiant tableStudent = new TableauEtudiant();
				tableStudent.setBounds(0, 70, 1335, 600);
				desktop.add(tableStudent);
				tableStudent.show();
			}
		});

		JMenuItem mntmFindCity = new JMenuItem("Afficher la liste des étudiants par ville");
		mntmFindCity.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				TableauEtudiant t=new TableauEtudiant();
				t.setBounds(0, 70, 1335, 600);
				desktop.add(t);
				t.show();
				
			}
		});
		mnNewMenu.add(mntmFindCity);

		JMenuItem mntmOuvrir = new JMenuItem("Fermer");
		mnNewMenu.add(mntmOuvrir);

		JMenu mnEdit = new JMenu("Edition");
		menuBar.add(mnEdit);

		JMenuItem mntmEditStud = new JMenuItem("Editer la fiche d'un étudiant");
		mnEdit.add(mntmEditStud);
		mntmEditStud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JUpdateStudent update = new JUpdateStudent();
				desktop.add(update);
				update.show();
			}
		});

		JMenu mnSetting = new JMenu("Paramètres");
		menuBar.add(mnSetting);

		JMenuItem mntmEditSett = new JMenuItem("Modifier les paramètres");
		mnSetting.add(mntmEditSett);
		mntmEditSett.addActionListener(new ActionListener() {// update setting
																// with menu
			public void actionPerformed(ActionEvent e) {
				JEditSetting jeSetting = new JEditSetting();
				desktop.add(jeSetting);
				jeSetting.show();
				
			}
		});
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(-2, 0, 1500, 65);
		contentPane.add(toolBar);
		frame.setContentPane(desktop);
		desktop.add(toolBar);

		String p = System.getProperty("user.dir") + "\\res\\Icons";// adresse
																	// par
																	// défaut
																	// des
																	// icones
		// toolbar elements-------------------------------------------------------------------------------------------
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(p + "\\user.png"));
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					IFAddStudent iFrame = new IFAddStudent();
					desktop.add(iFrame);
					iFrame.setBounds(0, 70, 1335, 600);
					iFrame.show();
				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Veuillez vérifier la connexion au serveur",
							"Problème de connexion : ",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnChercher = new JButton("");
		btnChercher.setIcon(new ImageIcon(p + "\\seek.png"));
		toolBar.add(btnChercher);
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					TableauEtudiant tabEtu = new TableauEtudiant();
					tabEtu.setBounds(0, 70, 1335, 600);
					desktop.add(tabEtu);
					tabEtu.show();

				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Veuillez vérifier la connexion au serveur",
							"Problème de connexion : ",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

		JButton btnConsulter = new JButton("");
		btnConsulter.setIcon(new ImageIcon(p + "\\file.png"));
		toolBar.add(btnConsulter);
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				JUpdateStudent update = new JUpdateStudent();
				update.setBounds(0, 70, 1335, 600);
				desktop.add(update);
				update.show();
				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"Veuillez vérifier la connexion au serveur",
							"Problème de connexion : ",JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});

		JButton btnSetting = new JButton("");// update a student with toolbar
												// button
		btnSetting.setIcon(new ImageIcon(p + "\\settings.png"));
		toolBar.add(btnSetting);
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					JEditSetting jeSetting = new JEditSetting();
					desktop.add(jeSetting);
					jeSetting.setBounds(0, 70, 1335, 600);
					jeSetting.show();
				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"Veuillez vérifier la connexion au serveur",
							"Problème de connexion : ",JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1350, 724);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ManagerInterface();
			}
		});
	}
}
