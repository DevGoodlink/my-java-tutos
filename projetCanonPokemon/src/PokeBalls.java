package mainproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projetCanon.Bombs;

public class PokeBalls extends JFrame {

	//private JPanel contentPane;
	JLabel lblNewLabel_1,lblNewLabel_2,lblScore;
	JLabel btnImage;
	static int x, y,xb,yb;
	private JPanel contentPane;
	private Bombs b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokeBalls frame = new PokeBalls();
					//frame.setExtendedState(MAXIMIZED_BOTH);
					//x=(frame.getWidth()/2)-70;
					//y=frame.getHeight()-200;
					
					frame.setVisible(true);
					frame.btnImage.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PokeBalls() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		setTitle("PokeRun");
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(50, 50, 50, 50);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnImage = new JLabel(new ImageIcon(System.getProperty("user.dir")+"//res//p1.gif"));
		btnImage.setPreferredSize(new Dimension(300, 300));
		btnImage.setBackground(Color.WHITE);
		btnImage.setBounds(new Rectangle(397, 387, 90, 90));
		btnImage.setBorder(null);
		btnImage.setMaximumSize(new Dimension(300, 300));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(10, 15, 500, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(10, 37, 500, 14);
		contentPane.add(lblNewLabel_2);
		
		lblScore = new JLabel("Score");
		lblScore.setForeground(Color.BLUE);
		lblScore.setBounds(10, 67, 500, 14);
		contentPane.add(lblScore);
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight()-50;
		gd=null;
		
		btnImage.requestFocus();
		//btnImage.setBounds((width/2)-60, height-170, 130, 150);
		btnImage.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyPressed(KeyEvent e) {
//				JOptionPane.showMessageDialog(null, e.getKeyCode());
				if(e.getKeyCode()==38){
					//enHaut();
				}
				if(e.getKeyCode()==39){
					aDroite();
				}
				if(e.getKeyCode()==37){
					aGauche();
				}
				if(e.getKeyCode()==40){
					//enBas();
				}
			}
		});
		contentPane.add(btnImage);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBounds(0, 498, 794, 73);
		contentPane.add(controlPanel);
		controlPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(55, 24, 100, 23);
		controlPanel.add(btnNewButton);
		
		JButton btnShowScore = new JButton("Show Score");
		btnShowScore.setBounds(631, 24, 120, 23);
		controlPanel.add(btnShowScore);
		
		JButton btnChangeRate = new JButton("Change Rate");
		btnChangeRate.setBounds(309, 24, 120, 23);
		controlPanel.add(btnChangeRate);
		
		for(int i=0;i<7;i++){
			JLabel j = new JLabel(new ImageIcon(System.getProperty("user.dir")+"//res//b1.gif"));
			j.setBounds(103+(i*10), 0, 50,50);
			contentPane.add(j);
			b = new Bombs("Poke",j,btnImage,this,lblScore,20,103+(i*150));
			b.start();
		}
		
	}
//	public void enHaut(){
//		btnImage.setBounds(btnImage.getX(), btnImage.getY()-10, 130, 152);
//		lblNewLabel_1.setText("X = "+btnImage.getX());
//		lblNewLabel_2.setText("Y = "+btnImage.getY());
//	}
//	public void enBas(){
//		btnImage.setBounds(btnImage.getX(), btnImage.getY()+10, 130, 152);
//		lblNewLabel_1.setText("X = "+btnImage.getX());
//		lblNewLabel_2.setText("Y = "+btnImage.getY());
//	}
	public void aDroite(){
		//btnImage.setIcon(play(2));
		if(btnImage.getX() < 600)
		btnImage.setBounds(btnImage.getX()+btnImage.getWidth(), btnImage.getY(),90, 90);
		lblNewLabel_1.setText("X = "+btnImage.getX());
		lblNewLabel_2.setText("Y = "+btnImage.getY());
	}
	public void aGauche(){
		
		//btnImage.setIcon(play(1));
		if(btnImage.getX()> 53)
		btnImage.setBounds(btnImage.getX()-btnImage.getWidth(), btnImage.getY(), 90, 90 );
		lblNewLabel_1.setText("X = "+btnImage.getX());
		lblNewLabel_2.setText("Y = "+btnImage.getY());
	}
}
