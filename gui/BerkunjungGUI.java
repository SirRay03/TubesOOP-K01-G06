package gui; 

import java.awt.*;
import javax.swing.*;

import src.*;

public class BerkunjungGUI {

    BerkunjungGUI(Sim sim){
        Sim[] arr = World.getInstance().getSimList();

        MyFrame frame = new MyFrame("Let's go on a trip!", "Select the house you want to visit");

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new LandingPage(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        JPanel map = new JPanel();
        int size = (int) Math.sqrt(World.getInstance().getSimCount());
        map.setLayout(new GridLayout(size, size));
        map.setPreferredSize(new Dimension(1200, 650));
        frame.middlePanel.add(map);

        for (Object s: arr){
            while (s != null){
                MyButton button = new MyButton(((Sim) s).getFirstName() + "'s house" + "(" + ((Sim) s).getRumah().getHAddress() + "," + ((Sim) s).getRumah().getVAddress() + ")");
            button.addActionListener(e -> {
                sim.setCurrentRumah(((Sim) s).getRumah());
                sim.setRuangan(sim.getcurrentRumah().searchRuangan("Kamar Utama"));
                new RoomMap(sim);
                frame.dispose();
            });
            map.add(button);
            }
        }

        frame.setVisible(true);
    }
}
