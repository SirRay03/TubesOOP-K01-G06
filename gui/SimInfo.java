package gui;

import javax.swing.*;
import java.awt.*;

import src.*;

public class SimInfo{
    JPanel middlePanel;
    JPanel bottomPanel;

    public SimInfo(Sim sim){
        JFrame frame = new JFrame();
        frame.setTitle("SimplyCity 5 - TubesOOP-K01-G06");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(750,500);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel introGroup = new JPanel();
        introGroup.setPreferredSize(new Dimension(600, 100));
        introGroup.setBackground(Color.black);
        introGroup.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(introGroup, BorderLayout.NORTH);
        
        JPanel intro = new JPanel();
        JLabel titleText = new JLabel("Sim Info");
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        titleText.setForeground(Color.white);
        intro.add(titleText);
        intro.setPreferredSize(new Dimension(600, 50));
        intro.setBackground(Color.black);
        introGroup.add(intro);

        JPanel subIntro = new JPanel();
        JLabel subtitleText = new JLabel("Here, you can view the sim's stats and info");
        subtitleText.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        subtitleText.setForeground(Color.white);
        subIntro.add(subtitleText);
        subIntro.setPreferredSize(new Dimension(600, 25));
        subIntro.setBackground(Color.black);
        introGroup.add(subIntro);

        middlePanel = new JPanel();
        middlePanel.setPreferredSize(new Dimension(600, 350));
        middlePanel.setBackground(Color.DARK_GRAY);

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(600, 50));
        bottomPanel.setBackground(Color.GRAY);

        frame.add(introGroup, BorderLayout.NORTH);        
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        
        JPanel nameText = new JPanel();
        nameText.setPreferredSize(new Dimension(600, 35));
        nameText.setBackground(Color.DARK_GRAY);
        nameText.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel nameLabel = new JLabel("Name:" + sim.getFullName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setForeground(Color.white);
        nameText.add(nameLabel);
        middlePanel.add(nameText);

        JPanel occupationText = new JPanel();
        occupationText.setPreferredSize(new Dimension(600, 35));
        occupationText.setBackground(Color.DARK_GRAY);
        occupationText.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel occupationLabel = new JLabel("Occupation:" + sim.getPekerjaan().getProfesi());
        occupationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        occupationLabel.setForeground(Color.white);
        occupationText.add(occupationLabel);
        middlePanel.add(occupationText);

        JPanel blank1 = new JPanel();
        blank1.setPreferredSize(new Dimension(600, 5));
        blank1.setBackground(Color.DARK_GRAY);
        middlePanel.add(blank1);

        JPanel moodText = new JPanel();
        moodText.setPreferredSize(new Dimension(600, 25));
        moodText.setBackground(Color.DARK_GRAY);
        moodText.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel moodLabel = new JLabel("Mood:" + sim.getKesejahteraan().getMood() + "%");
        moodLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        moodLabel.setForeground(Color.white);
        moodText.add(moodLabel);
        middlePanel.add(moodText);

        JPanel mood = new JPanel();
        mood.setPreferredSize(new Dimension(725, 20));
        mood.setBackground(Color.DARK_GRAY);
        mood.setLayout(new FlowLayout(FlowLayout.CENTER));

        for(int i = 0; i < sim.getKesejahteraan().getMood(); i++){
            JLabel label = new JLabel();                
            label.setPreferredSize(new Dimension(1, 20));
            label.setOpaque(true);
            if (sim.getKesejahteraan().getMood() < 30){
                label.setBackground(Color.RED);
            } else if (sim.getKesejahteraan().getMood() < 70){
                label.setBackground(Color.YELLOW);
            } else {
                label.setBackground(Color.GREEN);
            }
            mood.add(label);
        }
        middlePanel.add(mood);

        JPanel hungerText = new JPanel();
        hungerText.setPreferredSize(new Dimension(600, 25));
        hungerText.setBackground(Color.DARK_GRAY);
        hungerText.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel hungerLabel = new JLabel("Hunger:" + sim.getKesejahteraan().getHunger() + "%");
        hungerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        hungerLabel.setForeground(Color.white);
        hungerText.add(hungerLabel);
        middlePanel.add(hungerText);

        JPanel hunger = new JPanel();
        hunger.setPreferredSize(new Dimension(725, 20));
        hunger.setBackground(Color.DARK_GRAY);
        hunger.setLayout(new FlowLayout(FlowLayout.CENTER));

        for(int i = 0; i < sim.getKesejahteraan().getHunger(); i++){
            JLabel label = new JLabel();                
            label.setPreferredSize(new Dimension(1, 20));
            label.setOpaque(true);
            if (sim.getKesejahteraan().getHunger() < 30){
                label.setBackground(Color.RED);
            } else if (sim.getKesejahteraan().getHunger() < 70){
                label.setBackground(Color.YELLOW);
            } else {
                label.setBackground(Color.GREEN);
            }
            hunger.add(label);
        }
        middlePanel.add(hunger);

        JPanel healthText = new JPanel();
        healthText.setPreferredSize(new Dimension(600, 25));
        healthText.setBackground(Color.DARK_GRAY);
        healthText.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel healthLabel = new JLabel("Health:" + sim.getKesejahteraan().getHealth() + "%");
        healthLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        healthLabel.setForeground(Color.white);
        healthText.add(healthLabel);
        middlePanel.add(healthText);

        JPanel health = new JPanel();
        health.setPreferredSize(new Dimension(725, 20));
        health.setBackground(Color.DARK_GRAY);
        health.setLayout(new FlowLayout(FlowLayout.CENTER));

        for(int i = 0; i < sim.getKesejahteraan().getHealth(); i++){
            JLabel label = new JLabel();                
            label.setPreferredSize(new Dimension(1, 20));
            label.setOpaque(true);
            if (sim.getKesejahteraan().getHealth() < 30){
                label.setBackground(Color.RED);
            } else if (sim.getKesejahteraan().getHealth() < 70){
                label.setBackground(Color.YELLOW);
            } else {
                label.setBackground(Color.GREEN);
            }
            health.add(label);
        }
        middlePanel.add(health);

        JPanel blank = new JPanel();
        blank.setPreferredSize(new Dimension(600, 5));
        blank.setBackground(Color.DARK_GRAY);
        middlePanel.add(blank);

        JPanel moneyText = new JPanel();
        moneyText.setPreferredSize(new Dimension(600, 35));
        moneyText.setBackground(Color.DARK_GRAY);
        moneyText.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel moneyLabel = new JLabel("Money: $" + sim.getUang());
        moneyLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        moneyLabel.setForeground(Color.white);
        moneyText.add(moneyLabel);
        middlePanel.add(moneyText);

        MyButton confirm = new MyButton("OK");
        confirm.setFont(new Font("Arial", Font.PLAIN, 15));
        confirm.setPreferredSize(new Dimension(60, 40));
        confirm.addActionListener(e -> {
            frame.dispose();
        });
        bottomPanel.add(confirm, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}