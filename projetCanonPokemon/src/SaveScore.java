package saving;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;

public class SaveScore extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public int score ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveScore frame = new SaveScore();
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
	public SaveScore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGameOver.setBounds(165, 24, 99, 38);
		contentPane.add(lblGameOver);
		
		JLabel lblVotreScoreEst = new JLabel("Votre Score est :");
		lblVotreScoreEst.setBounds(122, 84, 87, 14);
		contentPane.add(lblVotreScoreEst);
		
		JLabel lblScore = new JLabel("");
		lblScore.setBounds(231, 84, 46, 14);
		contentPane.add(lblScore);
		
		JLabel lblEntrerVotreNom = new JLabel("Entrer Votre Nom :");
		lblEntrerVotreNom.setBounds(97, 120, 99, 14);
		contentPane.add(lblEntrerVotreNom);
		
		textField = new JTextField();
		textField.setBounds(206, 117, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GregorianCalendar calender = new GregorianCalendar();
//				   if(isSave())
//				   		JOptionPane.showMessageDialog(null, "Saved!!");
//				   else
//					   JOptionPane.showMessageDialog(null, "Problem !");
//				//GregorianCalendar calender = new GregorianCalendar();
//			
//				  // dispose();
				String sb="";
				   sb +="Nom : "+textField.getText()+": score = 111 :"+calender.getTime();
					try {
						File f = new File("res/score");
						PrintWriter sortie = new PrintWriter(new FileWriter(f.getPath(),true));
						JOptionPane.showMessageDialog(null, ""+f.getPath());
						sortie.println(sb);
						sortie.close();
						//return  true;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//return false;
					}	
			}
		});
		btnEnregistrer.setBounds(165, 162, 89, 23);
		contentPane.add(btnEnregistrer);
	}
	public boolean  isSave(){
		//boolean isOk = false;
		
		String sb = "";
		//sb +="Nom :"+textField.getText()+":"+ score+" : "+calender.getTime();
		//sb +="Nom : hahaha : 14 :"+calender.getTime();
		try {
			File f = new File("res/score");
			PrintWriter sortie = new PrintWriter(new FileWriter(f.getPath(),true));
			JOptionPane.showMessageDialog(null, ""+f.getPath());
			sortie.println(sb);
			sortie.close();
			return  true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		//return isOk;
	}
}
