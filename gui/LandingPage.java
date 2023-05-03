package gui;

import java.awt.event.*;
import javax.swing.*;

import src.*;

public class LandingPage {
    String[] welcome = {"Hi there, ", "Welcome, ", "Willkomen, ", "Annyeong, ", "Bonjour, ", "Hola, ", "Ciao, ", "Konnichiwa, ", "Ni hao, ", "Sawasdee, ", "Namaste, ", "Merhaba, ", "Salam, ", "Szia, ", "Sveiki, ", "Saluton, ", "Hej, ", "Hallo, ", "Hei, ", "Ahoj, ", "Hoi, ", "Halo, "};
    int random = (int)(Math.random() * 22);

    LandingPage(Sim sim){
        MyFrame frame = new MyFrame("Sim Interaction Menu", welcome[random] + sim.getFirstName() + "!");

        MyButton viewSimInfo = new MyButton("View Sim Info");
        viewSimInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SimInfo(sim);
            }
        });
        frame.middlePanel.add(viewSimInfo);

        MyButton goToWorld = new MyButton("Go to House");
        goToWorld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new RoomMap(sim);
            }
        });
        frame.middlePanel.add(goToWorld);

        MyButton goToInventory = new MyButton("Go to Inventory");
        goToInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ViewInventory(sim);
            }
        });
        frame.middlePanel.add(goToInventory);

        MyButton buyItem = new MyButton("Buy Item");
        buyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new BuyItem(sim);
            }
        });
        frame.middlePanel.add(buyItem);

        MyButton exercise = new MyButton("Exercise");
        exercise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = (int) JOptionPane.showConfirmDialog(null, "Are you sure you want to exercise?", "Exercise", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    new OverlayOlahraga(sim);
                } else {
                    JOptionPane.showMessageDialog(null, "You have cancelled the exercise.", "Exercise", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.middlePanel.add(exercise);

        MyButton goToWork = new MyButton("Go to Work");
        goToWork.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new WorkOverlay(sim);
                int confirm = (int) JOptionPane.showConfirmDialog(null, "Are you sure you want to go to work?", "Work", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "This feature is coming soon.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
                    try {
						sim.kerja();
					} catch (DeadException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } else {
                    JOptionPane.showMessageDialog(null, "You have cancelled going to work.", "Work", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.middlePanel.add(goToWork);

        MyButton daydream = new MyButton("Daydream");
        daydream.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //OverlayDaydream overlayDaydream = new OverlayDaydream();
                int confirm = (int) JOptionPane.showConfirmDialog(null, "Are you sure you want to daydream?", "Daydream", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    new OverlayMerenung(sim);
                } else {
                    JOptionPane.showMessageDialog(null, "You have cancelled daydreaming.", "Daydream", JOptionPane.INFORMATION_MESSAGE);
                    //overlayDaydream.frame.close();
                }
            }
        });
        frame.middlePanel.add(daydream);

        MyButton upgradeHouse = new MyButton("Upgrade House");
        upgradeHouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int uang = sim.getUang();
                uang = sim.getRumah().upgradeRumah(sim, uang);
                sim.setUang(uang);
            }
        });
        frame.middlePanel.add(upgradeHouse);
        
        MyButton goToHouse = new MyButton("Go to House");
        goToHouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new RoomMap(sim);
            }
        });

        MyButton berkunjung = new MyButton("Berkunjung");
        berkunjung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new BerkunjungGUI(sim);
            }
        });
        frame.middlePanel.add(berkunjung);

        MyButton returnToMain = new MyButton("Return to Main Menu");
        returnToMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });
        frame.middlePanel.add(returnToMain);
    }
}