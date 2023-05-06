package gui;

import java.awt.event.*;
import java.util.Random;
import java.awt.*;

import javax.swing.JLabel;

import src.World;

public class MainMenu{
    MyFrame frame;

    public MainMenu(){
        String[] quotes = {"TURG!!","Besok adalah hari ini", "When in doubt, kumpulin aja", "Saya Hugo, anda siapa?", "All hail Jim Pickens", "Technoblade never dies", "Juara 1 Speedrun Tubes", "Contains cordyceps","Young, Dumb, Stupid!","No Sana, No Life!","Github susah","Josua ngestan NewJeans sekarang","Sims rasa BitLife","Deadline plis dimundurin kita udah 6 hari pacaran sama laptop","Stuck tengah malem bersama dollar billsnya Lisa", "Todo list: Bangunin Willy","Correction: Josua kpopers skrg","Hugo nyolong chiki di borju", "Raysi karena mepet dedline, manjat pager"};
        int random = new Random().nextInt(quotes.length);
        frame = new MyFrame("Main Menu", World.getInstance().displayTime());

        MyButton newGame = new MyButton("New Sim");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new NewGame();
            }
        });

        MyButton loadGame = new MyButton("Change Sim");
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

        JLabel quot = new JLabel(quotes[random]);
        quot.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        quot.setForeground(Color.WHITE);

        frame.bottomPanel.add(quot);
        frame.middlePanel.add(newGame);
        frame.middlePanel.add(loadGame);
        frame.middlePanel.add(help);
        frame.middlePanel.add(exitGame);

        frame.setVisible(true);
    }
}