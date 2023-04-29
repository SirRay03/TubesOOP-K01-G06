package gui;

import javax.swing.*;
import java.awt.*;

public class SleepOverlay{
    MyFrame frame;
    public SleepOverlay(){
        frame = new MyFrame("Sim is sleeping zzz...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        ImageIcon tidur = new ImageIcon("tidur.gif");
        JLabel label = new JLabel(tidur);

        frame.add(label);
        frame.setVisible(true);
    }

    public void dispose(){
        frame.dispose();
    }
}