package gui;

import javax.swing.*;
import java.awt.*;

public class MyOverlay extends JFrame{
    public MyOverlay(String title, String path){
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
        intro.setPreferredSize(new Dimension(1500, 100));
        intro.setBackground(Color.black);

        ImageIcon image = new ImageIcon(path);
        System.out.println(image.getDescription());
        JLabel imageLabel = new JLabel(image);
        imageLabel.setPreferredSize(new Dimension(1500, 900));

        this.add(intro, BorderLayout.NORTH);
        this.add(imageLabel, BorderLayout.CENTER);
    }

    public void close(){
        this.dispose();
    }
}