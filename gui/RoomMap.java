package gui;

import javax.swing.*;
import java.awt.*;

import src.*;

public class RoomMap {
    RoomMap(Sim sim){
        MyFrame frame = new MyFrame("You are now in " + sim.getFirstName() + "'s house", sim.getRuangan().getNamaRuangan() + " Room");
        
        JPanel gap = new JPanel();
        gap.setPreferredSize(new Dimension(1500, 10));
        gap.setBackground(Color.DARK_GRAY);
        frame.middlePanel.add(gap, BorderLayout.NORTH);

        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(700,700));
        frame.middlePanel.add(map);
        
        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new HomePage1(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Sim sim = new Sim("John", "Doe");
        Rumah rumah = new Rumah();
        World.addSim(sim,rumah);
        new RoomMap(sim);
    }
}
