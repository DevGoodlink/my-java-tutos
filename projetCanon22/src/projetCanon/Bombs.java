package projetCanon;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bombs extends Thread {
	
	private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon image;
    private JLabel j;
	
    public Bombs(JLabel j){
    	
    	 try {
    		 
	            this.image = new ImageIcon(System.getProperty("user.dir")+"//res//b.png");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    	 	this.j = j;
	        this.width = this.image.getIconWidth();
	        this.height = this.image.getIconHeight();
    }
    public void run(){
		while(true){
			//jl = new JLabel(this.image);
			this.j.setBounds(500, j.getY()+50,j.getWidth(),j.getHeight());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
}
