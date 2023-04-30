<<<<<<< Updated upstream
package gui;

import Items.*;
import src.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage implements ActionListener{

    Sim sim;
    JFrame frame;
    JButton viewSimInfo;
    JButton viewCurrentLocation;
    JButton viewInventory;
    JButton upgradeHouse;
    JButton moveRoom;
    JButton backToMain;
    JButton kerja;
    JButton berkunjung;
    JButton buyItem;
    JButton goToObject;
    JButton olahraga;
    JButton merenung;
    JPanel title;
    JLabel subtitle;
    JPanel buttonPanel;
    JLabel titleText;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);

    public HomePage(Sim sim){
        this.sim = sim;

        frame = new JFrame(sim.getFullName() + " - Menu");
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        title = new JPanel();
        title.setPreferredSize(new Dimension(500, 150));
        title.setBackground(Color.black);
        titleText = new JLabel("You are now in " + sim.getFirstName() + "'s house");
        titleText.setForeground(Color.white);
        titleText.setFont(titleFont);
        title.add(titleText);
        subtitle = new JLabel(sim.getRuangan().getNamaRuangan() + " Room");
        subtitle.setForeground(Color.white);
        subtitle.setFont(buttonFont);
        title.add(subtitle);

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(500, 350));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

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

        backToMain = new JButton("Back to Main Menu");
        backToMain.setPreferredSize(new Dimension(300, 100));
        backToMain.setFont(buttonFont);
        backToMain.setFocusPainted(false);
        backToMain.addActionListener(this);

        kerja = new JButton("Kerja");
        kerja.setPreferredSize(new Dimension(300, 100));
        kerja.setFont(buttonFont);
        kerja.setFocusPainted(false);
        kerja.addActionListener(this);

        berkunjung = new JButton("Berkunjung");
        berkunjung.setPreferredSize(new Dimension(300, 100));
        berkunjung.setFont(buttonFont);
        berkunjung.setFocusPainted(false);
        berkunjung.addActionListener(this);

        goToObject = new JButton("Go To Object");
        goToObject.setPreferredSize(new Dimension(300, 100));
        goToObject.setFont(buttonFont);
        goToObject.setFocusPainted(false);
        goToObject.addActionListener(this);

        buyItem = new JButton("Buy Item");
        buyItem.setPreferredSize(new Dimension(300, 100));
        buyItem.setFont(buttonFont);
        buyItem.setFocusPainted(false);
        buyItem.addActionListener(this);

        olahraga = new JButton("Olahraga");
        olahraga.setPreferredSize(new Dimension(300, 100));
        olahraga.setFont(buttonFont);
        olahraga.setFocusPainted(false);
        olahraga.addActionListener(this);

        merenung = new JButton("Merenung");
        merenung.setPreferredSize(new Dimension(300, 100));
        merenung.setFont(buttonFont);
        merenung.setFocusPainted(false);
        merenung.addActionListener(this);

        buttonPanel.add(viewSimInfo);
        buttonPanel.add(viewCurrentLocation);
        buttonPanel.add(viewInventory);
        buttonPanel.add(upgradeHouse);
        buttonPanel.add(moveRoom);
        buttonPanel.add(berkunjung);
        buttonPanel.add(buyItem);
        buttonPanel.add(goToObject);
        buttonPanel.add(olahraga);
        buttonPanel.add(merenung);
        buttonPanel.add(kerja);
        buttonPanel.add(backToMain);

        frame.add(title, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewSimInfo){
            JOptionPane.showMessageDialog(null, "Name: " + sim.getFullName() + "\nOccupation: " + sim.getPekerjaan().getProfesi() + "\nHealth: " + sim.getKesejahteraan().getHealth() + "\nHunger: " + sim.getKesejahteraan().getHunger() + "\nMood: " + sim.getKesejahteraan().getMood() + "\nMoney: " + sim.getUang());
        }
        if (e.getSource() == viewInventory){
            frame.dispose();
            new ViewInventory(sim);
        }
        if (e.getSource() == viewCurrentLocation){
            JOptionPane.showMessageDialog(null, "Current Location: " + sim.getRuangan().getNamaRuangan());
        }
        if (e.getSource() == upgradeHouse){
            int uang = sim.getUang();
            uang = sim.getRumah().upgradeRumah(sim, uang);
            sim.setUang(uang);
        }
        if (e.getSource() == moveRoom){
            String[] rooms = sim.getRumah().getRoomNames();
            String room = (String) JOptionPane.showInputDialog(null, "Choose room", "Move Room", JOptionPane.QUESTION_MESSAGE, null, rooms, rooms[0]);
            Ruangan pindah = sim.getRumah().searchRuangan(room);
            sim.setRuangan(pindah);
            frame.dispose();
            new HomePage(sim);
        }
        if (e.getSource() == backToMain){
            frame.dispose();
            new MainMenu();
        }
        if (e.getSource() == kerja){
            sim.kerja(sim.getPekerjaan());
        }
        if (e.getSource() == berkunjung){
            frame.dispose();
            new BerkunjungGUI(sim);
        }
        if (e.getSource() == goToObject){
            String[] objects = sim.getRuangan().getObjekNames();
            String object = (String) JOptionPane.showInputDialog(null, "Choose object", "Go To Object", JOptionPane.QUESTION_MESSAGE, null, objects, objects[0]);
            NonMakanan obj = sim.getRuangan().searchObjek(object);
            obj.doAction(sim);
        }
        if (e.getSource() == buyItem){
            frame.dispose();
            new BuyItem(sim);
        }
        if (e.getSource() == olahraga){
            sim.olahraga();
        }
        if (e.getSource() == merenung){
            sim.merenung();
        }
    }
=======
package gui;

import Items.*;
import src.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage implements ActionListener{

    Sim sim;
    JFrame frame;
    JButton viewSimInfo;
    JButton viewCurrentLocation;
    JButton viewInventory;
    JButton upgradeHouse;
    JButton moveRoom;
    JButton backToMain;
    JButton kerja;
    JButton berkunjung;
    JButton buyItem;
    JButton goToObject;
    JButton olahraga;
    JButton merenung;
    JPanel title;
    JLabel subtitle;
    JPanel buttonPanel;
    JLabel titleText;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);

    public HomePage(Sim sim){
        this.sim = sim;

        frame = new JFrame(sim.getFullName() + " - Menu");
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        title = new JPanel();
        title.setPreferredSize(new Dimension(500, 150));
        title.setBackground(Color.black);
        titleText = new JLabel("You are now in " + sim.getFirstName() + "'s house");
        titleText.setForeground(Color.white);
        titleText.setFont(titleFont);
        title.add(titleText);
        subtitle = new JLabel(sim.getRuangan().getNamaRuangan() + " Room");
        subtitle.setForeground(Color.white);
        subtitle.setFont(buttonFont);
        title.add(subtitle);

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(500, 350));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // viewSimInfo = new JButton("View Sim Info");
        // viewSimInfo.setPreferredSize(new Dimension(300, 100));
        // viewSimInfo.setFont(buttonFont);
        // viewSimInfo.setFocusPainted(false);
        // viewSimInfo.addActionListener(this);

        // viewCurrentLocation = new JButton("View Current Location");
        // viewCurrentLocation.setPreferredSize(new Dimension(300, 100));
        // viewCurrentLocation.setFont(buttonFont);
        // viewCurrentLocation.setFocusPainted(false);
        // viewCurrentLocation.addActionListener(this);

        // viewInventory = new JButton("View Inventory");
        // viewInventory.setPreferredSize(new Dimension(300, 100));
        // viewInventory.setFont(buttonFont);
        // viewInventory.setFocusPainted(false);
        // viewInventory.addActionListener(this);

        // upgradeHouse = new JButton("Upgrade House");
        // upgradeHouse.setPreferredSize(new Dimension(300, 100));
        // upgradeHouse.setFont(buttonFont);
        // upgradeHouse.setFocusPainted(false);
        // upgradeHouse.addActionListener(this);

        // moveRoom = new JButton("Move Room");
        // moveRoom.setPreferredSize(new Dimension(300, 100));
        // moveRoom.setFont(buttonFont);
        // moveRoom.setFocusPainted(false);
        // moveRoom.addActionListener(this);

        // backToMain = new JButton("Back to Main Menu");
        // backToMain.setPreferredSize(new Dimension(300, 100));
        // backToMain.setFont(buttonFont);
        // backToMain.setFocusPainted(false);
        // backToMain.addActionListener(this);

        // kerja = new JButton("Kerja");
        // kerja.setPreferredSize(new Dimension(300, 100));
        // kerja.setFont(buttonFont);
        // kerja.setFocusPainted(false);
        // kerja.addActionListener(this);

        berkunjung = new JButton("Berkunjung");
        berkunjung.setPreferredSize(new Dimension(300, 100));
        berkunjung.setFont(buttonFont);
        berkunjung.setFocusPainted(false);
        berkunjung.addActionListener(this);

        // goToObject = new JButton("Go To Object");
        // goToObject.setPreferredSize(new Dimension(300, 100));
        // goToObject.setFont(buttonFont);
        // goToObject.setFocusPainted(false);
        // goToObject.addActionListener(this);

        // buyItem = new JButton("Buy Item");
        // buyItem.setPreferredSize(new Dimension(300, 100));
        // buyItem.setFont(buttonFont);
        // buyItem.setFocusPainted(false);
        // buyItem.addActionListener(this);

        // olahraga = new JButton("Olahraga");
        // olahraga.setPreferredSize(new Dimension(300, 100));
        // olahraga.setFont(buttonFont);
        // olahraga.setFocusPainted(false);
        // olahraga.addActionListener(this);

        // merenung = new JButton("Merenung");
        // merenung.setPreferredSize(new Dimension(300, 100));
        // merenung.setFont(buttonFont);
        // merenung.setFocusPainted(false);
        // merenung.addActionListener(this);

        buttonPanel.add(viewSimInfo);
        buttonPanel.add(viewCurrentLocation);
        buttonPanel.add(viewInventory);
        buttonPanel.add(upgradeHouse);
        buttonPanel.add(moveRoom);
        buttonPanel.add(berkunjung);
        buttonPanel.add(buyItem);
        buttonPanel.add(goToObject);
        buttonPanel.add(olahraga);
        buttonPanel.add(merenung);
        buttonPanel.add(kerja);
        buttonPanel.add(backToMain);

        frame.add(title, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewSimInfo){
            JOptionPane.showMessageDialog(null, "Name: " + sim.getFullName() + "\nOccupation: " + sim.getPekerjaan().getProfesi() + "\nHealth: " + sim.getKesejahteraan().getHealth() + "\nHunger: " + sim.getKesejahteraan().getHunger() + "\nMood: " + sim.getKesejahteraan().getMood() + "\nMoney: " + sim.getUang());
        }
        if (e.getSource() == viewInventory){
            frame.dispose();
            new ViewInventory(sim);
        }
        if (e.getSource() == viewCurrentLocation){
            JOptionPane.showMessageDialog(null, "Current Location: " + sim.getRuangan().getNamaRuangan());
        }
        if (e.getSource() == upgradeHouse){
            int uang = sim.getUang();
            uang = sim.getRumah().upgradeRumah(sim, uang);
            sim.setUang(uang);
        }
        if (e.getSource() == moveRoom){
            String[] rooms = sim.getRumah().getRoomNames();
            String room = (String) JOptionPane.showInputDialog(null, "Choose room", "Move Room", JOptionPane.QUESTION_MESSAGE, null, rooms, rooms[0]);
            Ruangan pindah = sim.getRumah().searchRuangan(room);
            sim.setRuangan(pindah);
            frame.dispose();
            new HomePage(sim);
        }
        if (e.getSource() == backToMain){
            frame.dispose();
            new MainMenu();
        }
        // if (e.getSource() == kerja){
        //     sim.kerja(sim.getPekerjaan());
        // }
        if (e.getSource() == berkunjung){
            frame.dispose();
            new BerkunjungGUI(sim);
        }
        if (e.getSource() == goToObject){
            String[] objects = sim.getRuangan().getObjekNames();
            String object = (String) JOptionPane.showInputDialog(null, "Choose object", "Go To Object", JOptionPane.QUESTION_MESSAGE, null, objects, objects[0]);
            NonMakanan obj = sim.getRuangan().searchObjek(object);
            obj.doAction(sim);
        }
        if (e.getSource() == buyItem){
            frame.dispose();
            new BuyItem(sim);
        }
        if (e.getSource() == olahraga){
            sim.olahraga();
        }
        if (e.getSource() == merenung){
            sim.merenung();
        }
    }
>>>>>>> Stashed changes
}