package gui;

import src.*;
import javax.swing.*;
import java.awt.*;

public class OverlayOlahraga{
    MyOverlay frame;

    public OverlayOlahraga(Sim sim){
        frame = new MyOverlay("Your sim is now exercising!", "You should go exercise too, you lazy f**ks!");

        ImageIcon icon = new ImageIcon("exercise.png");
        frame.middlePanel.add(new JLabel(icon));

        frame.setVisible(true);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(500, 100));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 300, 0);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider, BorderLayout.CENTER);

        int option = JOptionPane.showOptionDialog(null, panel, "Select duration", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
            try{
            int value = slider.getValue();
            sim.olahraga(value);
            sim.getKesejahteraan().isAlive();
            JOptionPane.showMessageDialog(null, "Your sim has finished exercising!", "Exercise", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            } catch (DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(sim);
            }
        }
        else{
            frame.dispose();
        }
    }
}