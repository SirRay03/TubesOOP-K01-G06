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
    JPanel mapTextPanel;
    JLabel mapText;
    JButton back;

    BerkunjungGUI(){
        frame = new JFrame();
        frame.setTitle("SimPlicity 5 - Berkunjung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);

        title = new JPanel();
        title.setBounds(0, 0, 1920, 150);
        title.setBackground(Color.black);

        titleText = new JLabel("Berkunjung");
        titleText.setForeground(Color.white);
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        title.add(titleText);
        
        mapTextPanel = new JPanel();
        mapTextPanel.setBounds(0, 800, 1920, 150);
        frame.add(mapTextPanel);

        map = new JPanel();
        map.setBounds(0, 100, 1920, 725);
        map.setLayout(new GridLayout(64, 64));
        map.setBackground(Color.GREEN);
        ButtonGroup group = new ButtonGroup();
        String[] owner = new String[World.getSimList().length];
        int k = 0;
        for (int i = 0; i < 64; i++){
            for (int j = 0; j < 64; j++){
                if (World.getMap()[i][j] != null){
                    JRadioButton rumah = new JRadioButton();
                    group.add(rumah);
                    map.add(rumah);

                    owner[k] = World.getMap()[i][j].getOwner().getFirstName();
                    k++;

                    rumah.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            for (int i = 0; i < World.getSimList().length; i++){
                                if (owner[i].equals(World.getSimList()[i].getFirstName())){
                                    JOptionPane.showMessageDialog(frame, "Rumah milik " + owner[i]);
                                }
                            }
                        }
                    });
                }
                else{
                    JPanel rumah = new JPanel();
                    rumah.setBackground(Color.GREEN);
                    rumah.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    map.add(rumah);
                }
            }
        }

        back = new JButton("Back");
        back.setBounds(0, 830, 100, 30);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new MainMenu();
            }
        });

        frame.add(title);
        frame.add(map);
        frame.setVisible(true);
    }
}
