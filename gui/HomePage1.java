package gui;

import java.awt.event.*;

import src.*;

public class HomePage1 {
    String[] welcome = {"Hi there, ", "Welcome, ", "Willkomen, ", "Annyeong, ", "Bonjour, ", "Hola, ", "Ciao, ", "Konnichiwa, ", "Ni hao, ", "Sawasdee, ", "Namaste, ", "Merhaba, ", "Salam, ", "Szia, ", "Sveiki, ", "Saluton, ", "Hej, ", "Hallo, ", "Hei, ", "Ahoj, ", "Hoi, ", "Halo, "};
    int random = (int)(Math.random() * 22);

    HomePage1(Sim sim){
        MyFrame frame = new MyFrame("Sim Interaction Menu", welcome[random] + sim.getFirstName() + "!");

        MyButton goToWorld = new MyButton("Go to World");
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
    }
}
