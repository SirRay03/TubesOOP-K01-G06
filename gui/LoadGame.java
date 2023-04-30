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
        // frame = new JFrame();
        // frame.setTitle("SimPlicity 5 - Load Game");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(800,600);
        // frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // title = new JPanel();
        // title.setPreferredSize(new Dimension(1000, 300));
        // title.setBackground(Color.black);
        // titleText = new JLabel("Load Game");
        // titleText.setForeground(Color.white);
        // titleText.setFont(titleFont);
        // title.add(titleText);

        // simListPanel = new JPanel();
        // simListPanel.setPreferredSize(new Dimension(1000, 700));
        // simListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // for (Sim sim: World.getInstance().getSimList()){
        //     if (sim == null) break;
        //     JButton tombol = new JButton(sim.getFullName());
        //     tombol.addActionListener(new ActionListener(){
        //          public void actionPerformed(ActionEvent e){
        //              frame.dispose();
        //              new SimMenu(World.getSimList()[0]);
        //          }
        //      });
        //     tombol.setPreferredSize(new Dimension(300, 100));
        //     tombol.setFont(buttonFont);
        //     simListPanel.add(tombol);
        // }
        // // sim1 = new JButton(World.getSimList()[0].getFullName());
        // // sim1.setPreferredSize(new Dimension(300, 100));
        // // sim1.setFont(buttonFont);
        // // sim1.addActionListener(new ActionListener(){
        // //     public void actionPerformed(ActionEvent e){
        // //         frame.dispose();
        // //         new SimMenu(World.getSimList()[0]);
        // //     }
        // // });

        // // sim2 = new JButton(World.getSimList()[1].getFullName());
        // // sim2.setPreferredSize(new Dimension(300, 100));
        // // sim2.setFont(buttonFont);
        // // sim2.addActionListener(new ActionListener(){
        // //     public void actionPerformed(ActionEvent e){
        // //         frame.dispose();
        // //         new SimMenu(World.getSimList()[1]);
        // //     }
        // // });

        // back = new JButton("Back");
        // back.setPreferredSize(new Dimension(300, 100));
        // back.setFont(buttonFont);
        // back.addActionListener(new ActionListener(){
        //     public void actionPerformed(ActionEvent e){
        //         frame.dispose();
        //         new MainMenu();
        //     }
        // });
        // back.setFocusPainted(false);

        // // simListPanel.add(sim1);
        // // simListPanel.add(sim2);
        // simListPanel.add(back);

        // frame.add(title);
        // frame.add(simListPanel);
        // frame.setVisible(true);