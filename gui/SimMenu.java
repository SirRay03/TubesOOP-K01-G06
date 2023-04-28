package gui;
import javax.swing.*;

import src.Sim;

import java.awt.*;
import java.awt.event.*;

public class SimMenu implements ActionListener{

    Sim sim;
    JFrame frame;
    // JButton start;
    // JButton help;
    // JButton exit;
    JButton viewSimInfo;
    JButton viewCurrentLocation;
    JButton viewInventory;
    JButton upgradeHouse;
    JButton moveRoom;
    JButton backToMain;
    // JButton editRoom;
    // JButton addSim;
    // JButton changeSim;
    // JButton listObject;
    // JButton goToObject;
    // JButton action;
    JPanel title;
    JPanel buttonPanel;
    JLabel titleText;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);

    public SimMenu(Sim sim){
        this.sim = sim;

        frame = new JFrame(sim.getFullName() + " - Menu");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        title = new JPanel();
        title.setPreferredSize(new Dimension(500, 150));
        title.setBackground(Color.black);
        titleText = new JLabel("You are now in " + sim.getFirstName() + "'s house");
        titleText.setForeground(Color.white);
        titleText.setFont(titleFont);
        title.add(titleText);

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(500, 350));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        //buttonPanel.setBackground(Color.black);
        
        // start = new JButton("Start");
        // start.setPreferredSize(new Dimension(300, 100));
        // start.setFont(buttonFont);
        // start.setFocusPainted(false);
        // start.addActionListener(this);
        // //start.setBackground(Color.white);

        // help = new JButton("Help");
        // help.setPreferredSize(new Dimension(300, 100));
        // help.setFont(buttonFont);
        // help.setFocusPainted(false);
        // help.addActionListener(this);

        // exit = new JButton("Exit");
        // exit.setPreferredSize(new Dimension(300, 100));
        // exit.setFont(buttonFont);
        // exit.setFocusPainted(false);
        // exit.addActionListener(this);

        viewSimInfo = new JButton("View Sim Info");
        viewSimInfo.setPreferredSize(new Dimension(300, 100));
        viewSimInfo.setFont(buttonFont);
        viewSimInfo.setFocusPainted(false);
        viewSimInfo.addActionListener(this);

        viewCurrentLocation = new JButton("View Current Location");
        viewCurrentLocation.setPreferredSize(new Dimension(300, 100));
        viewCurrentLocation.setFont(buttonFont);
        viewCurrentLocation.setFocusPainted(false);
        viewCurrentLocation.addActionListener(this);

        viewInventory = new JButton("View Inventory");
        viewInventory.setPreferredSize(new Dimension(300, 100));
        viewInventory.setFont(buttonFont);
        viewInventory.setFocusPainted(false);
        viewInventory.addActionListener(this);

        upgradeHouse = new JButton("Upgrade House");
        upgradeHouse.setPreferredSize(new Dimension(300, 100));
        upgradeHouse.setFont(buttonFont);
        upgradeHouse.setFocusPainted(false);
        upgradeHouse.addActionListener(this);

        moveRoom = new JButton("Move Room");
        moveRoom.setPreferredSize(new Dimension(300, 100));
        moveRoom.setFont(buttonFont);
        moveRoom.setFocusPainted(false);
        moveRoom.addActionListener(this);

        // editRoom = new JButton("Edit Room");
        // editRoom.setPreferredSize(new Dimension(300, 100));
        // editRoom.setFont(buttonFont);
        // editRoom.setFocusPainted(false);
        // editRoom.addActionListener(this);

        // addSim = new JButton("Add Sim");
        // addSim.setPreferredSize(new Dimension(300, 100));
        // addSim.setFont(buttonFont);
        // addSim.setFocusPainted(false);
        // addSim.addActionListener(this);

        // changeSim = new JButton("Change Sim");
        // changeSim.setPreferredSize(new Dimension(300, 100));
        // changeSim.setFont(buttonFont);
        // changeSim.setFocusPainted(false);
        // changeSim.addActionListener(this);

        // listObject = new JButton("List Object");
        // listObject.setPreferredSize(new Dimension(300, 100));
        // listObject.setFont(buttonFont);
        // listObject.setFocusPainted(false);
        // listObject.addActionListener(this);

        // goToObject = new JButton("Go To Object");
        // goToObject.setPreferredSize(new Dimension(300, 100));
        // goToObject.setFont(buttonFont);
        // goToObject.setFocusPainted(false);
        // goToObject.addActionListener(this);

        // action = new JButton("Action");
        // action.setPreferredSize(new Dimension(300, 100));
        // action.setFont(buttonFont);
        // action.setFocusPainted(false);
        // action.addActionListener(this);

        // buttonPanel.add(start);
        // buttonPanel.add(help);
        // buttonPanel.add(exit);
        buttonPanel.add(viewSimInfo);
        buttonPanel.add(viewCurrentLocation);
        buttonPanel.add(viewInventory);
        buttonPanel.add(upgradeHouse);
        buttonPanel.add(moveRoom);
        // buttonPanel.add(editRoom);
        // buttonPanel.add(addSim);
        // buttonPanel.add(changeSim);
        // buttonPanel.add(listObject);
        // buttonPanel.add(goToObject);
        // buttonPanel.add(action);

        frame.add(title, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCurrentLocation){
            JOptionPane.showMessageDialog(null, sim.getRumah().currentLoc());
        }
        if (e.getSource() == upgradeHouse){
            int uang = sim.getUang();
            uang = sim.getRumah().upgradeRumah(uang);
            sim.setUang(uang);
        }
        if (e.getSource() == moveRoom){
            String[] rooms = sim.getRumah().getRoomNames();
            String room = (String) JOptionPane.showInputDialog(null, "Choose room", "Move Room", JOptionPane.QUESTION_MESSAGE, null, rooms, rooms[0]);
            sim.getRumah().moveRoom(room);
        }
    }
}