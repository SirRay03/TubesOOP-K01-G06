package gui;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

import src.Sim;
import src.World;


public class OverlayMerenung{
    MyOverlay frame;

    public OverlayMerenung(Sim sim){
        frame = new MyOverlay("I am the magic conch shell", "Ïnsert your question here", "Sim sedang merenung");
        JTextField textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(800, 100));
        textField.setForeground(Color.GRAY); // Set the text color to gray
        frame.interactionBar.setForeground(Color.GRAY); // Set the text color to gray
        frame.interactionBar.add(textField);
        
        MyButton button = new MyButton("Ask");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e -> {
            textField.setEditable(false);
            button.setEnabled(false);
            JOptionPane.showMessageDialog(null,sim.merenung(), "Merenung", JOptionPane.INFORMATION_MESSAGE);
            sim.getKesejahteraan().setMood(3);
            sim.getKesejahteraan().setHunger(-2);
            World.getInstance().addWaktu(1000);
            // World.getInstance().checkSimTime(durasiOlahraga);
            sim.tambahWaktuBelumTidur(1000);
            sim.tambahWaktuBelumBAB(1000); 
            sim.resetTimerBelumBab();
            sim.resetWaktuTidurAfterNoSleep();
            frame.dispose();
        });
        frame.interactionBar.add(button);
    }
}