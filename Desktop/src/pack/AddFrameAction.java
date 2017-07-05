package pack;

import java.awt.event.ActionEvent;

import javax.swing.*;

class AddFrameAction extends AbstractAction {
    public AddFrameAction(boolean upper) {
      super(upper ? "Add Upper Frame" : "Add Lower Frame");
      if (upper) {
        this.layer = new Integer(2);
        this.name = "Up";
      } else {
        this.layer = new Integer(1);
        this.name = "Lo";
      }
    }

    public void actionPerformed(ActionEvent ev) {
      JInternalFrame f = new JInternalFrame(name, true, true, true, true);
      f.addVetoableChangeListener(iconPolice);

      f.setBounds(0, 0, 120, 60);
      desk.add(f, layer);
      f.setVisible(true); // Needed since 1.3
    }

    private Integer layer;

    private String name;
  }
