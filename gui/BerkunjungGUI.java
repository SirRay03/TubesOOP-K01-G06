package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.*;

public class BerkunjungGUI {
    JFrame frame;
    JPanel title;
    JLabel titleText;
    JPanel map;

    BerkunjungGUI(){
        frame = new JFrame();
        frame.setTitle("SimPlicity 5 - Berkunjung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,900);
        frame.setLayout(null);

        title = new JPanel();
        title.setBounds(0, 0, 1200, 100);
        title.setBackground(Color.black);

        titleText = new JLabel("Berkunjung");
        titleText.setForeground(Color.white);
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        title.add(titleText);
        
        map = new JPanel();
        map.setBounds(0, 100, 1200, 800);
        map.setLayout(new GridLayout(0, 0));
        map.setBackground(Color.Green);
        for (int i = 0; i < 64; i++){
            for (int j = 0; j < 64; j++){
                if (World.getMap()[i][j] != null){
                    JButton rumah = new JButton();
                    
                }
                else{
                    JPanel rumah = new JPanel();
                    rumah.setBackground(Color.black);
                    map.add(rumah);
                }
            }
        }

        frame.add(title);
        frame.add(map);
        frame.setVisible(true);
    }
}
