package gui;

import src.*;
import javax.swing.*;
import java.awt.*;

public class OverlayKertas{
    public MyOverlay frame;
    public OverlayKertas(Sim sim, String status){
        frame = new MyOverlay("Your sim is now writing!", "A better love letter to Starla", status);
        frame.setVisible(true);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(800, 100));
        textField.setForeground(Color.GRAY);
        frame.interactionBar.setForeground(Color.GRAY);
        frame.interactionBar.add(textField);

        MyButton button = new MyButton("Write");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e ->{
            textField.setEditable(false);
            button.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Your sim wrote: " + textField.getText(), "Writing", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();            
        });
        frame.interactionBar.add(button);
    }
}