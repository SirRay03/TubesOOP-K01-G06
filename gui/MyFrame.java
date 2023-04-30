package gui;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    JPanel middlePanel;
    JPanel bottomPanel;

    public MyFrame(String title, String subtitle){
        this.setTitle("SimplyCity 5 - TubesOOP-K01-G06");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 925);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        JPanel introGroup = new JPanel();
        introGroup.setPreferredSize(new Dimension(1200, 120));
        introGroup.setBackground(Color.black);
        introGroup.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(introGroup, BorderLayout.NORTH);
        
        JPanel intro = new JPanel();
        JLabel titleText = new JLabel(title);
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        titleText.setForeground(Color.white);
        intro.add(titleText);
        intro.setPreferredSize(new Dimension(1200, 70));
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

        middlePanel = new JPanel();
        middlePanel.setPreferredSize(new Dimension(1200, 650));
        middlePanel.setBackground(Color.DARK_GRAY);

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(1200, 75));
        bottomPanel.setBackground(Color.GRAY);

        this.add(introGroup, BorderLayout.NORTH);        
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    } 
}
