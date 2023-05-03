package gui;

import src.*;
import javax.swing.*;

public class OverlayOlahraga{
    MyOverlay frame;

    public OverlayOlahraga(Sim sim){
        frame = new MyOverlay("Your sim is now exercising!", "You should go exercise too, you lazy f**ks!");
        
        int duration = Integer.parseInt(JOptionPane.showInputDialog("How long do you want to exercise?"));
        sim.olahraga(duration);

        JOptionPane.showMessageDialog(null, "Your sim has finished exercising!", "Exercise", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();

        ImageIcon icon = new ImageIcon("olahraga.png");
        frame.middlePanel.add(new JLabel(icon));

        frame.setVisible(true);
    }
}