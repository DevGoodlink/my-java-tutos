package evenements;

import java.awt.Container;

import javax.swing.*;

class Fen2Boutons2 extends JFrame{
private JButton monBouton1, monBouton2;
public Fen2Boutons(){
	setTitle("Avec deux boutons");
	setSize("300,200");
	monBouton1=new JButton("Bouton 1");
	monBouton2=new JButton("Bouton 2");
	Container contenu = GetContentPane();
	contenu.setLayout(new FlowLayout());
	contenu.add(monBouton1);
	contenu.add(monBouton2);
	EcouteBouton1 ecout1= new EcouteBouto1();
	EcouteBouton2 ecout2= new EcouteuBouton2();
	monBouton1.addActionListener(ecout1);
	monBouton2.addActionListener(ecout2);
}
}
