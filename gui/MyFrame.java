package gui;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    JPanel middlePanel;
    JPanel bottomPanel;

    public MyFrame(String title, String subtitle){
        this.setTitle("SimplyCity 5 - TubesOOP-K01-G06");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500,1075);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.setLocationRelativeTo(null);
        
        JPanel intro = new JPanel();
        JLabel titleText = new JLabel(title);
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 80));
        titleText.setForeground(Color.white);
        intro.add(titleText);
        intro.setPreferredSize(new Dimension(1500, 100));
        intro.setBackground(Color.black);

        JPanel subIntro = new JPanel();
        JLabel subtitleText = new JLabel(subtitle);
        subtitleText.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        subtitleText.setForeground(Color.white);
        subIntro.add(subtitleText);
        subIntro.setPreferredSize(new Dimension(1500, 50));
        subIntro.setBackground(Color.black);

        middlePanel = new JPanel();
        middlePanel.setPreferredSize(new Dimension(1500, 750));
        middlePanel.setBackground(Color.DARK_GRAY);

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(1500, 150));
        bottomPanel.setBackground(Color.GRAY);

        this.add(intro);
        this.add(subIntro);
        this.add(middlePanel);
        this.add(bottomPanel);
        this.setVisible(true);
    } 
}
