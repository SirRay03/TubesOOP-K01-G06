package gui;

import java.awt.*;
import java.awt.event.*;

import src.*;

public class LoadGame {
    MyFrame frame;

    LoadGame(){
        frame = new MyFrame("Load Game", "Select one of the existing sims to play!");
        frame.middlePanel.setLayout(new GridLayout(5,5,5,5));

        if (World.getInstance().getSimList()[0] == null){
            MyButton tombol = new MyButton("No existing sims!");
            frame.middlePanel.add(tombol);
        }
        else{
            for (Sim sim: World.getInstance().getSimList()){
                if (sim == null) break;
                MyButton tombol = new MyButton(sim.getFullName());
                tombol.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                        frame.dispose();
                        new LandingPage(sim);
                     }
                 });
                frame.middlePanel.add(tombol);
            }
        }

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new MainMenu();
            }
        });
        frame.bottomPanel.add(back);
        
        frame.setVisible(true);
    }
}