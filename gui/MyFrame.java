package gui;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String title){
        this.setTitle("SimplyCity 5 - TubesOOP-K01-G06");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500,1000);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        this.setLocationRelativeTo(null);
        
        JPanel intro = new JPanel();
        JLabel titleText = new JLabel(title);
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 90));
        titleText.setForeground(Color.white);
        intro.add(titleText);
        intro.setPreferredSize(new Dimension(1500, 125));
        intro.setBackground(Color.black);

        this.add(intro);
        this.setVisible(true);
    } 
}
