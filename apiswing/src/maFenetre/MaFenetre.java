package maFenetre;

import javax.swing.JFrame;

class MaFenetre extends JFrame {
	public static final int DEFAULT_WIDTH=300;
	public static final int DEFAULT_HEIGHT=150;
	
	public MaFenetre(){
		this.setTitle("Ma premiere fenetre");
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}

}
