package gui;

import javax.swing.*;
import java.awt.*;

public class MyOverlay extends JFrame{

    JPanel middlePanel;

    public MyOverlay(String title){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1600,1175);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel intro = new JPanel();
        JLabel titleText = new JLabel(title);
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 80));
        titleText.setForeground(Color.white);
        intro.add(titleText);
        intro.setPreferredSize(new Dimension(1600, 100));
        intro.setBackground(Color.black);

        middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        middlePanel.setPreferredSize(new Dimension(1600, 1075));

        this.add(intro, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void close(){
        this.dispose();
    }
}