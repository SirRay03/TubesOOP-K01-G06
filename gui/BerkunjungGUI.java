package gui; 

import java.awt.*;
//import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

import src.*;

public class BerkunjungGUI {

    BerkunjungGUI(Sim sim){
        MyFrame frame = new MyFrame("Let's go on a trip!", "Select the house you want to visit");
        frame.setSize(1920, 1080);
        frame.middlePanel.setLayout(new GridLayout(64, 64));
        frame.middlePanel.setBackground(Color.GREEN);
        ButtonGroup group = new ButtonGroup();
        JLabel[] label = new JLabel[World.getSimList().length];

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new HomePage1(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        int k = 0;

        for (int i = 0; i < 64; i++){
            for (int j = 0; j < 64; j++){
                if (World.getMap()[i][j] != null){
                    JRadioButton rumah = new JRadioButton();
                    rumah.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    group.add(rumah);
                    frame.middlePanel.add(rumah);

                    label[k] = new JLabel();
                    label[k].setText(World.getMap()[i][j].getOwner().getFirstName() + "'s house");

                    rumah.addChangeListener(new ChangeListener(){
                        public void stateChanged(ChangeEvent e){
                            if (rumah.isSelected()){
                                frame.bottomPanel.removeAll();
                                frame.bottomPanel.add(label[k]);
                                frame.bottomPanel.add(back);
                                frame.bottomPanel.revalidate();
                                frame.bottomPanel.repaint();
                            }
                        }
                    });
                }
                else{
                    JPanel rumah = new JPanel();
                    rumah.setBackground(Color.GREEN);
                    rumah.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    frame.middlePanel.add(rumah);
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
