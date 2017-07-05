package projetCanonPokemon;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.function.LongToIntFunction;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bombs extends Thread {
	
	private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon image;
    private JLabel j,lblScore;
    private JLabel btnImg;
    public static int score = 0;
    public boolean state = false;
    private JFrame frame;
    private long timeSleep;
    public static boolean interuption;
    
    public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Bombs(String nom, JLabel j,JLabel btnImg, JFrame frame,JLabel lblScore, long timeSleep,int x){
			super(nom);
    		this.image = new ImageIcon(System.getProperty("user.dir")+"//res//b1.gif");
    		this.frame = frame;
	       	this.j = j;
	       	this.timeSleep = timeSleep;
	       	this.lblScore = lblScore;
    	 	this.btnImg = btnImg;
	        this.width = this.image.getIconWidth();
	        this.height = this.image.getIconHeight();
	        this.x=x;
	        this.interuption=false;
    }
    public void run(){
		while(this.interuption==false){
			//jl = new JLabel(this.image);
			int i = (int)(Math.random()*10);
			//int y=0;
			if(j.getY()<400){//(i>= 20 || i <= 1000)
				this.j.setBounds(x, j.getY()+i,j.getWidth(),j.getHeight());
			}else{
				this.j.setBounds(x, 0,j.getWidth(),j.getHeight());
			}
			try {
				
				Thread.sleep(timeSleep);
				if( j.getBounds().intersects(btnImg.getBounds())  ){
					score++;
					Thread.sleep(3000);
					this.lblScore.setText("Touché "+score);
					this.lblScore.setForeground(Color.RED);
					this.j.setBounds(0, 0, 0, 0);
					
				}else
				{
					this.lblScore.setForeground(Color.blue);
				}

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public static int getScore() {
		return score;
	}
	public static void setScore(int score) {
		Bombs.score = score;
	}
}
