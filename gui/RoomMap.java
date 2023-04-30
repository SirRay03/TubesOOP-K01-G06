package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.*;
import Items.*;

public class RoomMap {
    RoomMap(Sim sim){
        NonMakanan[][] ruangan = sim.getRuangan().getMatriksPemetaan();

        MyFrame frame = new MyFrame("You are now in " + sim.getFirstName() + "'s house", sim.getRuangan().getNamaRuangan() + " Room");
        
        JPanel gap = new JPanel();
        gap.setPreferredSize(new Dimension(1500, 10));
        gap.setBackground(Color.DARK_GRAY);
        frame.middlePanel.add(gap, BorderLayout.NORTH);

        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(660,660));
        frame.middlePanel.add(map);

        for (Object any: sim.getRuangan().toPropArray()){
            if (any != null){
                MyButton prop = new MyButton(any.getClass().getSimpleName());
                prop.setPreferredSize(new Dimension(50,50));
                prop.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ((NonMakanan) any).doAction(sim);
                    }
                });
                map.add(prop);
            }
            else{
                JLabel prop = new JLabel();
                prop.setPreferredSize(new Dimension(50,50));
                prop.setOpaque(true);
                prop.setBackground(Color.BLUE);
                prop.setHorizontalAlignment(JLabel.CENTER);
                prop.setVerticalAlignment(JLabel.CENTER);
                map.add(prop);
            }
        }
        
        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new HomePage1(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        MyButton moveRoom = new MyButton("Move");
        moveRoom.setPreferredSize(new Dimension(200, 50));
        moveRoom.addActionListener(e -> {
            String[] rooms = sim.getRumah().getRoomNames();
            String room = (String) JOptionPane.showInputDialog(null, "Choose room", "Move Room", JOptionPane.QUESTION_MESSAGE, null, rooms, rooms[0]);
            Ruangan pindah = sim.getRumah().searchRuangan(room);
            sim.setRuangan(pindah);
            frame.dispose();
            new RoomMap(sim);
        });
        frame.bottomPanel.add(moveRoom, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Sim sim = new Sim("John", "Doe");
        Rumah rumah = new Rumah();
        World.getInstance().addSim(sim,rumah);
        new RoomMap(sim);
    }
}