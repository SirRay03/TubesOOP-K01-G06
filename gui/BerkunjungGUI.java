package gui; 

import java.awt.*;
//import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

import src.*;

public class BerkunjungGUI {

    BerkunjungGUI(Sim sim){
        MyFrame frame = new MyFrame("Let's go on a trip!", "Select the house you want to visit");
        
        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(700,700));
        frame.middlePanel.add(map);
        
        ButtonGroup group = new ButtonGroup();

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new LandingPage(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        for (int i = 0; i < 64; i++){
            for (int j = 0; j < 64; j++){
                if (World.getInstance().getMap()[i][j] != null){
                    JRadioButton rumah = new JRadioButton();
                    rumah.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    group.add(rumah);
                    map.add(rumah);

                    JLabel label = new JLabel();
                    label.setText(World.getInstance().getMap()[i][j].getOwner().getFirstName() + "'s house" + " (" + i + "," + j + ")");
                    label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    label.setForeground(Color.WHITE);

                    rumah.addChangeListener(new ChangeListener(){
                        public void stateChanged(ChangeEvent e){
                            if (rumah.isSelected()){
                                frame.bottomPanel.add(label);
                                frame.bottomPanel.add(back);
                            }
                        }
                    });
                } else {
                    continue;
                }
            }
        }

        frame.setVisible(true);
    }

    // JFrame frame;
    // JPanel title;
    // JLabel titleText;
    // JPanel map;
    // JPanel mapTextPanel;
    // JLabel mapText;
    // JButton back;

    // BerkunjungGUI(){
    //     frame = new JFrame();
    //     frame.setTitle("SimPlicity 5 - Berkunjung");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(1920,1080);
    //     frame.setLayout(null);

    //     title = new JPanel();
    //     title.setBounds(0, 0, 1920, 150);
    //     title.setBackground(Color.black);

    //     titleText = new JLabel("Berkunjung");
    //     titleText.setForeground(Color.white);
    //     titleText.setFont(new Font("Times New Roman", Font.PLAIN, 50));
    //     title.add(titleText);
        
    //     mapTextPanel = new JPanel();
    //     mapTextPanel.setBounds(0, 800, 1920, 150);
    //     frame.add(mapTextPanel);

    //     map = new JPanel();
    //     map.setBounds(0, 100, 1920, 725);
    //     map.setLayout(new GridLayout(64, 64));
    //     map.setBackground(Color.GREEN);
    //     ButtonGroup group = new ButtonGroup();
    //     String[] owner = new String[World.getSimList().length];
    //     int k = 0;

    //     back = new JButton("Back");
    //     back.setBounds(0, 830, 100, 30);
    //     back.addActionListener(new ActionListener(){
    //         public void actionPerformed(ActionEvent e){
    //             frame.dispose();
    //             new MainMenu();
    //         }
    //     });

    //     frame.add(title);
    //     frame.add(map);
    //     frame.setVisible(true);
    // }
}
