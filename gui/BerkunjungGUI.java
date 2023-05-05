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

        MyFrame frame = new MyFrame("Let's go on a trip!", "Select the house you want to visit");

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
            for (Object o : arr) {
                if (o == null) break;
                Sim s = (Sim) o;
                if (s != sim) {
                    MyButton button = new MyButton(s.getFullName());
                    button.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent e) {
                                sim.setCurrentRumah(s.getRumah());
                                sim.setRuangan(s.getRumah().getDenahRumah()[11][11]);
                                // System.out.println(sim.getRuangan());
                                // System.out.println(sim.getcurrentRumah());
                                new RoomMap(sim);
                                frame.dispose();
                            }
                        });
                    map.add(button);
                }
            }
        }

        frame.setVisible(true);
    }
}
