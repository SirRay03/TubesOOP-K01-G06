package gui;

import java.awt.*;
import javax.swing.*;

import src.*;

public class RemoveItem {
    RemoveItem(Sim sim){
        MyFrame frame = new MyFrame("You are now in " + sim.getcurrentRumah().getOwner().getFirstName() + "'s house", "Select the item you want to remove");

        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(600,600));
        frame.middlePanel.add(map);

        for (Object any: sim.getRuangan().toPropArray()){
            if (any != null){
                JButton prop = new JButton(any.getClass().getSimpleName());
                prop.setFont(new Font("Arial", Font.PLAIN, 10));
                prop.setPreferredSize(new Dimension(50,50));
                prop.addActionListener(e->{
                    sim.getRuangan().mengambilBarang(any.getClass().getSimpleName(), sim);
                    frame.dispose();
                    new RoomMap(sim);
                });
                map.add(prop);
            }
            else{
                JLabel prop = new JLabel();
                prop.setPreferredSize(new Dimension(50,50));
                prop.setOpaque(true);
                prop.setBackground(Color.WHITE);
                prop.setHorizontalAlignment(JLabel.CENTER);
                prop.setVerticalAlignment(JLabel.CENTER);
                prop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                map.add(prop);
            }
        }
        
        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new RoomMap(sim);
        });
        frame.bottomPanel.add(back);

        frame.setVisible(true);
    }
}
