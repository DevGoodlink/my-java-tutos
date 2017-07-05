package projetCanon;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Main extends JFrame {
	JLabel lblNewLabel_1,lblNewLabel_2;
	JButton btnImage;
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
					Main frame = new Main();
					frame.setExtendedState(MAXIMIZED_BOTH);
					x=(frame.getWidth()/2)-70;
					y=frame.getHeight()-200;
					
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1040, 720);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 1040, 720));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(50, 50, 50, 50);
		
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		//contentPane.setOpaque(false);
		//contentPane.setBackground(Color.BLACK);
		
		btnImage = new JButton(play(1));
		btnImage.setPreferredSize(new Dimension(300, 300));
		btnImage.setBackground(Color.WHITE);
		btnImage.setBorder(null);
		btnImage.setMaximumSize(new Dimension(300, 300));
		
		JButton button = new JButton(">");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aDroite();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(1189, 33, 41, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aGauche();
			}
		});
		button_1.setBounds(1105, 33, 41, 23);
		contentPane.add(button_1);
		
		
		
		JButton button_2 = new JButton("^");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enHaut();
			}
		});
		button_2.setBounds(1147, 11, 41, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u02C5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enBas();
			}
		});
		button_3.setBounds(1147, 56, 41, 23);
		contentPane.add(button_3);
		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(10, 15, 500, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(10, 37, 500, 14);
		contentPane.add(lblNewLabel_2);
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight()-50;
		gd=null;

		
		btnImage.requestFocus();
		btnImage.setBounds((width/2)-60, height-170, 130, 150);
		btnImage.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyPressed(KeyEvent e) {
//				JOptionPane.showMessageDialog(null, e.getKeyCode());
				if(e.getKeyCode()==38){
					enHaut();
				}
				if(e.getKeyCode()==39){
					aDroite();
				}
				if(e.getKeyCode()==37){
					aGauche();
				}
				if(e.getKeyCode()==40){
					enBas();
				}
			}
		});
		contentPane.add(btnImage);
		
		JLabel j = new JLabel(new ImageIcon(System.getProperty("user.dir")+"//res//b.png"));
		j.setBounds(500, 0, 150,150);
		contentPane.add(j);
		Thread b = new Bombs(j);
		b.start();
		
//		Graph g= new Graph();
//		g.drawRoundRect(50, 50, 100, 100, 5, 5);
//		Color couleur=new Color(100,100,100);
//		g.setColor(couleur);
//		contentPane.paint(g);
		}
	
	public ImageIcon play(int i){
		String url = null ;
		if(i == 2){
			url = System.getProperty("user.dir")+"//res//P1.png";
		}
		else if (i == 1) {
			url = System.getProperty("user.dir")+"//res//P2.png";
		}
		
		return new ImageIcon(url);
	}
	public void enHaut(){
		btnImage.setBounds(btnImage.getX(), btnImage.getY()-10, 130, 152);
		lblNewLabel_1.setText("X = "+btnImage.getX());
		lblNewLabel_2.setText("Y = "+btnImage.getY());
	}
	public void enBas(){
		btnImage.setBounds(btnImage.getX(), btnImage.getY()+10, 130, 152);
		lblNewLabel_1.setText("X = "+btnImage.getX());
		lblNewLabel_2.setText("Y = "+btnImage.getY());
	}
	public void aDroite(){
		btnImage.setIcon(play(2));
		if(btnImage.getX() < 1143)
		btnImage.setBounds(btnImage.getX()+btnImage.getWidth(), btnImage.getY(), 130, 152);
		lblNewLabel_1.setText("X = "+btnImage.getX());
		lblNewLabel_2.setText("Y = "+btnImage.getY());
	}
	public void aGauche(){
		
		btnImage.setIcon(play(1));
		if(btnImage.getX()> 103)
		btnImage.setBounds(btnImage.getX()-btnImage.getWidth(), btnImage.getY(), 130,152 );
		lblNewLabel_1.setText("X = "+btnImage.getX());
		lblNewLabel_2.setText("Y = "+btnImage.getY());
	}
}
