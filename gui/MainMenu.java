package gui;

import java.awt.event.*;
import src.*;

public class MainMenu{
    MyFrame frame;

    public MainMenu(){
        String[] quotes = {"All hail Jim Pickens", "Technoblade never dies", "Juara 1 Speedrun Tubes", "Contains cordyceps","Young, Dumb, Stupid!","No Sana, No Life!","Github susah","Josua ngestan NewJeans sekarang"};
        int random = (int)(Math.random() * 8);

        frame = new MyFrame("Main Menu1", quotes[random]);

        MyButton newGame = new MyButton("New Game");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new NewGame();
            }
        });

        MyButton loadGame = new MyButton("Load Game");
        loadGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoadGame();
            }
        });

        MyButton help = new MyButton("Help");
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Help();
            }
        });

        MyButton exitGame = new MyButton("Exit Game");
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.middlePanel.add(newGame);
        frame.middlePanel.add(loadGame);
        frame.middlePanel.add(help);
        frame.middlePanel.add(exitGame);

        frame.setVisible(true);
    }
}