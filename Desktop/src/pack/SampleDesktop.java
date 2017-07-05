package pack;

/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly 
*/

// SampleDesktop.java
//Another example that shows how to do a few interesting things using
//JInternalFrames, JDesktopPane, and DesktopManager.
//

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import javax.swing.AbstractAction;
import javax.swing.DefaultDesktopManager;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class SampleDesktop extends JFrame {

  private JDesktopPane desk;

  private IconPolice iconPolice = new IconPolice();

  public SampleDesktop(String title) {
    super(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Create a desktop and set it as the content pane. Don't set the
    // layered
    // pane, since it needs to hold the menu bar too.
    desk = new JDesktopPane();
    setContentPane(desk);

    // Install our custom desktop manager.
    desk.setDesktopManager(new SampleDesktopMgr());

    createMenuBar();
    loadBackgroundImage();
  }

  // Create a menu bar to show off a few things.
  protected void createMenuBar() {
    JMenuBar mb = new JMenuBar();
    JMenu menu = new JMenu("Frames");

    menu.add(new AddFrameAction(true)); // add "upper" frame
    menu.add(new AddFrameAction(false)); // add "lower" frame
    menu.add(new TileAction(desk)); // add tiling capability

    setJMenuBar(mb);
    mb.add(menu);
  }

  // Here we load a background image for our desktop.
  protected void loadBackgroundImage() {
    ImageIcon icon = new ImageIcon("images/matterhorn.gif");
    JLabel l = new JLabel(icon);
    l.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

    // Place the image in the lowest possible layer so nothing
    // can ever be painted under it.
    desk.add(l, new Integer(Integer.MIN_VALUE));
  }
}
