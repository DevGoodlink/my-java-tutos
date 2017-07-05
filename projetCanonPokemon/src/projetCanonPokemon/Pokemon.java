package projetCanonPokemon;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
//import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Pokemon extends JFrame {

	private JPanel contentPane;
	
	public Renderer renderer;

	public Rectangle r ;
	
	public JLabel pokemon;

	public ArrayList<Rectangle> pkeballs;

	public int ticks, yMotion, score;

	public boolean gameOver, started;

	public Random rand;
	
	private ImageIcon img ;
     
	private Graphics dbi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokemon frame = new Pokemon();
					frame.pokemon.requestFocus();
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
	public Pokemon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		setTitle("PokeRun");
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		pokemon = new JLabel(new ImageIcon(System.getProperty("user.dir")+"//res//p1.gif"));
		pokemon.requestFocus();
		pokemon.setBounds(new Rectangle(362, 387, 100, 100));
		//pokemon.setBounds((WIDTH/2)-60, HEIGHT-170, 50, 50);
		pokemon.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyPressed(KeyEvent e) {
//				JOptionPane.showMessageDialog(null, e.getKeyCode());
				if(e.getKeyCode()==39){
					aDroite();
				}
				if(e.getKeyCode()==37){
					aGauche();
				}
			}
		});
		contentPane.add(pokemon);
		
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
		
		renderer = new Renderer();
		//JPanel gamePanel = new JPanel();
		renderer.setBackground(Color.BLACK);
		renderer.setBounds(0, 0, 794, 498);
		//renderer.add(renderer);
		contentPane.add(renderer);
		setResizable(false);
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight()-50;
		gd=null;
		
		r = new Rectangle(width / 2 - 10, height / 2 - 10, 20, 20);
		renderer.setLayout(null);
		//private Rectangle rectangle;
		//ImageIcon(System.getProperty("user.dir")+"//res//b1.gif");
		//img = new ImageIcon("res/b1.gif");
		
		
	}

	public static void repaint(Graphics g) {
		// TODO Auto-generated method stub
//		g.setColor(Color.red);
//		g.fillRect(100, 100, 200, 200);
		
		
	}
	public void aDroite(){
		//pokemon.setIcon(play(2));
		if(pokemon.getX() < 1143)
		pokemon.setBounds(pokemon.getX()+pokemon.getWidth(), pokemon.getY(), 362, 387);
		//lblNewLabel_1.setText("X = "+pokemon.getX());
		//lblNewLabel_2.setText("Y = "+pokemon.getY());
	}
	public void aGauche(){
		
		//pokemon.setIcon(play(1));
		if(pokemon.getX()> 103)
		pokemon.setBounds(pokemon.getX()-pokemon.getWidth(), pokemon.getY(), 362, 387);
		//lblNewLabel_1.setText("X = "+pokemon.getX());
		//lblNewLabel_2.setText("Y = "+pokemon.getY());
	}
}
