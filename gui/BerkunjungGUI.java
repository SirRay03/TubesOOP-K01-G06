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

        for (int i = 0; i < World.getInstance().getSimCount(); i++){
            final int index = i;
            if (World.getInstance().getSimList()[i] != sim){
                final JButton button = new JButton("Rumah " + arr[i].getFullName() + " (" + arr[i].getRumah().getHAddress() + "," + arr[i].getRumah().getVAddress() + ")");
                button.addActionListener(e -> {
                    frame.dispose();
                    sim.setRumah(World.getInstance().getMap()[arr[index].getRumah().getHAddress()][arr[index].getRumah().getVAddress()]);
                    new RoomMap(sim);
                });
                map.add(button);
            }
        }

        frame.setVisible(true);
    }
}
