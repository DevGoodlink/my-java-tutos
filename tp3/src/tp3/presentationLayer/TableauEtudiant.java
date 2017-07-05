package tp3.presentationLayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import tp3.Etudiant;
import tp3.businessLogicLayer.EtudiantDAO;
import java.awt.Color;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.awt.event.ActionListener;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TableauEtudiant extends JInternalFrame {
	private JTextField txtRecherche;
	Object[][] vide = { {} };
	private int id;
	private String ville;
	private String[] columnName= {"Numéro", "Nom", "Prénom", "Adresse em@il","GSM", "Organisation","Ville","Filière"};
	private TableModelEtudiant tabModEtu;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableauEtudiant frame = new TableauEtudiant();
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
	
	public TableauEtudiant() {
		
		
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 1354, 404);
		getContentPane().add(scrollPane);
		
		tabModEtu=new TableModelEtudiant(columnName,traitement(2));
        table = new JTable(tabModEtu);
		table.setRowSorter(new TableRowSorter<TableModelEtudiant>(tabModEtu));
		
		
		
		JLabel lblInternalJframe = new JLabel("LISTE DES ETUDIANTS");
		lblInternalJframe.setHorizontalAlignment(SwingConstants.CENTER);
		lblInternalJframe.setForeground(new Color(128, 0, 0));
		lblInternalJframe.setFont(new Font("Arial", Font.BOLD, 22));
		lblInternalJframe.setBounds(0, 0, 984, 39);
		getContentPane().add(lblInternalJframe);
//		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rechercher par num\u00E9ro Etudiant", "Rechercher par ville", "Afficher tous les \u00E9tudiants"}));
		comboBox.setBounds(36, 521, 182, 20);
		getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==2){
					txtRecherche.setText("");
					Object[][] data = traitement(2);
					table.removeAll();
					tabModEtu.setData(data);
					scrollPane.setViewportView(table);
				}
			}
		});
		
		
		txtRecherche = new JTextField();
		txtRecherche.setBounds(233, 521, 190, 20);
		getContentPane().add(txtRecherche);
		txtRecherche.setColumns(10);
		
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index=comboBox.getSelectedIndex();//position de l'élément choisi en combobox
				if(txtRecherche!=null || index==0 || index==1){
					Object[][] dataFounded=traitement(index);					
					table.removeAll();
					tabModEtu.setData(dataFounded);
					scrollPane.setViewportView(table);
				}
			}
		});
		btnRechercher.setBounds(448, 520, 200, 23);
		getContentPane().add(btnRechercher);
		
		JButton btnexport = new JButton("Exporter au format PDF");
		btnexport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Document d=new Document();
					PdfWriter.getInstance(d,new FileOutputStream(System.getProperty("user.dir")+"\\pdf\\data.pdf"));
			          d.open();
			          PdfPTable tab=new PdfPTable(8);
			          for(int i=0;i<8;i++)
			        	  tab.addCell(columnName[i]);
			          
			          for (int i=0;i<table.getRowCount();i++){
			        	  for(int j=0;j<8;j++)
			        		  tab.addCell(GetData(table, i, j).toString());
			          }
			          d.add(tab);
			          d.close();
			          JOptionPane.showMessageDialog(null, "Fichier PDF généré avec succés \n  "+System.getProperty("user.dir")+"\\pdf", "Fichier pdf", JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception ex){
					ex.getStackTrace();
				}
				
			}
		});
		
		btnexport.setBounds(800, 520, 170, 23);
		getContentPane().add(btnexport);
		
		JButton btnexportxml = new JButton("Exporter au format xml");
		btnexportxml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					  PrintWriter writer = new PrintWriter(System.getProperty("user.dir")+"\\xml\\data.xml","UTF-8");
					  writer.println("<?xml version=1.0 ?>");
					  for (int i=0;i<table.getRowCount();i++){
						  writer.println("<Etudiant>");
						  writer.println("\t<id>"+GetData(table, i, 0).toString()+"</id>");
						  writer.println("\t<nom>"+GetData(table, i, 1).toString()+"</nom>");
						  writer.println("\t<prenom>"+GetData(table, i,2).toString()+"</prenom>");
						  writer.println("\t<email>"+GetData(table, i, 3).toString()+"</email>");
						  writer.println("\t<gsm>"+GetData(table, i, 4).toString()+"</gsm>");
						  writer.println("\t<organisation>"+GetData(table, i, 5).toString()+"</organisation>");
						  writer.println("\t<ville>"+GetData(table, i, 6).toString()+"</ville>");
						  writer.println("\t<filiere>"+GetData(table, i,7).toString()+"</filiere>");
						  writer.println("</Etudiant>");
			          }
					  writer.close();
					  JOptionPane.showMessageDialog(null, "Fichier XML généré avec succés \n "+System.getProperty("user.dir")+"\\xml",
							  "Fichier XML",
							  JOptionPane.INFORMATION_MESSAGE);
			         
				}catch (Exception ex){
					ex.getStackTrace();
				}
				
			}
		});
		
		btnexportxml.setBounds(1000, 520, 170, 23);
		getContentPane().add(btnexportxml);
		
		setSize(995, 625);
		setSize(995, 625);
		setTitle("Liste des Etudiants");
        setLocation(0, 70);
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
       
        scrollPane.setViewportView(table);//affichage de la table
		
	}
	public Object GetData(JTable table, int row_index, int col_index){
		  return table.getModel().getValueAt(row_index, col_index);
		 }

	private Object[][] traitement(int i) {
		EtudiantDAO etdDao = new EtudiantDAO();
		List<Etudiant> data = etdDao.getAll();
		Etudiant e=new Etudiant();
		Object[][] tableau;
		switch (i) {
		case 0:
			id=Integer.parseInt(txtRecherche.getText());
			tableau=new Object[1][8];
			e = etdDao.getById(id);
			tableau[0][0] = e.getNum();
			tableau[0][1] = e.getNom();
			tableau[0][2] = e.getPrenomEtu();
			tableau[0][3] = e.getAdresse();
			tableau[0][4] = e.getTel();
			tableau[0][5] = e.getOrganisation();
			tableau[0][6] = e.getVille();
			tableau[0][7]= e.getFiliere().getIntitule();
			
			return tableau;
		case 1:
			ville = txtRecherche.getText();
			data = etdDao.findByVille(ville);
			tableau=new Object[data.size()][8];
			int j = 0;
			for (Etudiant eVille : data) {
				tableau[j][0] = eVille.getNum();
				tableau[j][1] = eVille.getNom();
				tableau[j][2] = eVille.getPrenomEtu();
				tableau[j][3] = eVille.getAdresse();
				tableau[j][4] = eVille.getTel();
				tableau[j][5] = eVille.getOrganisation();
				tableau[j][6] = eVille.getVille();
				tableau[j][7]=eVille.getFiliere().getIntitule();
				j++;
			}
			
			return tableau;
		case 2:
			tableau=new Object[data.size()][8];
			j = 0;// incrémente l'indice du tableau
			for (Etudiant eAll : data) {
				tableau[j][0] = eAll.getNum();
				tableau[j][1] = eAll.getNom();
				tableau[j][2] = eAll.getPrenomEtu();
				tableau[j][3] = eAll.getAdresse();
				tableau[j][4] = eAll.getTel();
				tableau[j][5] = eAll.getOrganisation();
				tableau[j][6] = eAll.getVille();
				tableau[j][7]=eAll.getFiliere().getIntitule();
				j++;
			}
			return tableau;
		}
		return null;
	}
}
