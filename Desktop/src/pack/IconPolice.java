package pack;

import java.beans.*;

import javax.swing.*;

public class IconPolice implements VetoableChangeListener{
	public void vetoableChange(PropertyChangeEvent ev)
	        throws PropertyVetoException {
	      String name = ev.getPropertyName();
	      if (name.equals(JInternalFrame.IS_ICON_PROPERTY)
	          && (ev.getNewValue() == Boolean.TRUE)) {
	        JInternalFrame[] frames = desk.getAllFrames();
	        int count = frames.length;
	        int nonicons = 0; // how many are not icons?
	        for (int i = 0; i < count; i++) {
	          if (!frames[i].isIcon()) {
	            nonicons++;
	          }
	        }
	        if (nonicons <= 1) {
	          throw new PropertyVetoException("Invalid Iconification!",ev);
	        }
	      }
	    }

// A simple test program.
public static void main(String[] args) {
  SampleDesktop td = new SampleDesktop("Sample Desktop");

  td.setSize(300, 220);
  td.setVisible(true);
}
}