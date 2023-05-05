package gui; 

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import src.*;

public class BerkunjungGUI {

    BerkunjungGUI(Sim sim){
        Sim[] arr = World.getInstance().getSimList();
        // System.out.println(sim.getcurrentRumah());
        // System.out.println(sim.getRuangan());

        MyFrame frame = new MyFrame("Let's go on a trip!", "Your address is at (" + sim.getRumah().getHAddress() + ", " + sim.getRumah().getVAddress() + ")");

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new LandingPage(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        if (World.getInstance().getSimCount() == 1) {
            JLabel label = new JLabel("There are no houses to visit");
            label.setFont(new Font("Arial", Font.PLAIN, 30));
            label.setHorizontalAlignment(JLabel.CENTER);
            frame.middlePanel.add(label);
        }
        else{
            JPanel map = new JPanel();
            int size = (int) Math.sqrt(World.getInstance().getSimCount());
            map.setLayout(new GridLayout(size, size));
            map.setPreferredSize(new Dimension(1200, 650));
            frame.middlePanel.add(map);    
            for (Sim s : arr) {
                if (s == null) break;
                if (s != sim) {
                    MyButton button = new MyButton(s.getFullName() + "(" + s.getRumah().getHAddress() + ", " + s.getRumah().getVAddress() + ")");
                    button.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent e) {
                                try{
                                    sim.berkunjung(s.getRumah());
                                    sim.getKesejahteraan().isAlive();
                                    new RoomMap(sim);
                                    frame.dispose();
                                } catch (DeadException dead){
                                    JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                                    new MainMenu();
                                    World.getInstance().removeSim(sim);
                                }
                            }
                        });
                    map.add(button);
                }
            }
        }

        frame.setVisible(true);
    }
}
