package maFenetrebouton;

import java.awt.FlowLayout;

import javax.swing.*;

public class Fen1Bouton extends JFrame{

	JButton monBouton;

	public Fen1Bouton(){
	
		this.setTitle("Premier bouton");
		this.setSize(300,200);
		monBouton = new JButton ("Essai");
		this.getContentPane().setLayout(new FlowLayout());
		this.add(monBouton);
	
}
}
