package gui;

import javax.swing.*;
import java.awt.*;

public class MyOverlay extends JFrame{

    JPanel middlePanel;
    JPanel interactionBar;

    public MyOverlay(String title, String subtitle){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1250,850);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel introGroup = new JPanel();
        introGroup.setPreferredSize(new Dimension(1250,100));
        introGroup.setBackground(Color.black);
        introGroup.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel intro = new JPanel();
        JLabel titleText = new JLabel(title);
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        titleText.setForeground(Color.white);
        intro.add(titleText);
        intro.setPreferredSize(new Dimension(1200,60));
        intro.setBackground(Color.black);
        introGroup.add(intro);

        JPanel subIntro = new JPanel();
        JLabel subtitleText = new JLabel(subtitle);
        subtitleText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        subtitleText.setForeground(Color.white);
        subIntro.add(subtitleText);
        subIntro.setPreferredSize(new Dimension(1200, 30));
        subIntro.setBackground(Color.black);
        introGroup.add(subIntro);
        
        interactionBar = new JPanel();
        interactionBar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        interactionBar.setPreferredSize(new Dimension(1250, 70));
        interactionBar.setBackground(Color.black);
        
        middlePanel = new JPanel();
        middlePanel.setPreferredSize(new Dimension(1250, 680));
  
        this.add(introGroup, BorderLayout.NORTH);
        this.add(interactionBar, BorderLayout.CENTER);
        this.add(middlePanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void close(){
        this.dispose();
    }
}