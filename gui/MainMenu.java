package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu implements ActionListener{
    JFrame frame;
    JPanel title;
    JPanel buttonPanel;
    JButton newGame;
    JButton loadGame;
    JButton help;
    JButton exitGame;
    JLabel titleText;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);

    public MainMenu(){
        frame = new JFrame();
        frame.setTitle("SimPlicity 5 - Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        title = new JPanel();
        title.setPreferredSize(new Dimension(1000, 300));
        title.setBackground(Color.black);
        titleText = new JLabel("SimPlicity 5");
        titleText.setForeground(Color.white);
        titleText.setFont(titleFont);
        title.add(titleText);

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(1000, 700));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        //buttonPanel.setBackground(Color.black);
        
        newGame = new JButton("New Game");
        newGame.setPreferredSize(new Dimension(300, 100));
        newGame.setFont(buttonFont);
        newGame.addActionListener(this);
        newGame.setFocusPainted(false);
        newGame.setBackground(Color.white);

        loadGame = new JButton("Load Game");
        loadGame.setPreferredSize(new Dimension(300, 100));
        loadGame.setFont(buttonFont);
        loadGame.addActionListener(this);
        loadGame.setFocusPainted(false);
        loadGame.setBackground(Color.white);

        help = new JButton("Help");
        help.setPreferredSize(new Dimension(300, 100));
        help.setFont(buttonFont);
        help.addActionListener(this);
        help.setFocusPainted(false);
        help.setBackground(Color.white);

        exitGame = new JButton("Exit Game");
        exitGame.setPreferredSize(new Dimension(300, 100));
        exitGame.setFont(buttonFont);
        exitGame.addActionListener(this);
        exitGame.setFocusPainted(false);
        exitGame.setBackground(Color.white);

        buttonPanel.add(newGame);
        buttonPanel.add(loadGame);
        buttonPanel.add(exitGame);

        frame.add(title);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newGame){
            frame.dispose();
            new NewGame();
        }
        if(e.getSource() == loadGame){
            frame.dispose();
            System.out.println("new LoadGame()");
        }
        if(e.getSource() == help){
            frame.dispose();
            new Help();
        }
        if(e.getSource() == exitGame){
            System.exit(0);
        }
    }
    
}