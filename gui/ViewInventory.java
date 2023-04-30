package gui;

import src.*;
import javax.swing.*;
import Items.*;
import java.awt.*;

public class ViewInventory {
    MyFrame frame;

    // JPanel title;
    // JButton back;
    // JLabel titleText;
    // Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    // Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
    // JPanel makanan;
    // JPanel nonMakanan;
    // JLabel makananText;
    // JLabel nonMakananText;

    ViewInventory(Sim sim){
        frame = new MyFrame(sim.getFullName() + "'s - Inventory", "You can view all the items you have here");

        JPanel makananTitle = new JPanel();
        makananTitle.setPreferredSize(new Dimension(1500, 75));
        makananTitle.setBackground(Color.green);
        JLabel makananTitleText = new JLabel("Makanan");
        makananTitleText.setForeground(Color.black);
        makananTitleText.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        makananTitle.add(makananTitleText);
        frame.middlePanel.add(makananTitle);

        JPanel makanan = new JPanel();
        makanan.setLayout(new GridLayout(2,7));
        makanan.setPreferredSize(new Dimension(1500, 300));
        makanan.setBackground(Color.green);
        for (Item item: sim.getInventory().getMap().keySet()){
            if(item instanceof Makanan){
                JButton tombol;
                tombol = new JButton(((Makanan) item).getNama() + " x" + sim.getInventory().getMap().get(item));
                tombol.setPreferredSize(new Dimension(300, 100));
                tombol.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                tombol.setFocusPainted(false);
                tombol.setBackground(Color.white);
                makanan.add(tombol);
            }
        }
        frame.middlePanel.add(makanan);

        JPanel nonMakananTitle = new JPanel();
        nonMakananTitle.setPreferredSize(new Dimension(1500, 75));
        nonMakananTitle.setBackground(Color.blue);
        JLabel nonMakananTitleText = new JLabel("Non-Makanan");
        nonMakananTitleText.setForeground(Color.black);
        nonMakananTitleText.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        nonMakananTitle.add(nonMakananTitleText);
        frame.middlePanel.add(nonMakananTitle);

        JPanel nonMakanan = new JPanel();
        nonMakanan.setLayout(new GridLayout(2,7));
        nonMakanan.setPreferredSize(new Dimension(1500, 300));
        nonMakanan.setBackground(Color.blue);
        for (Item item: sim.getInventory().getMap().keySet()){
            if(!(item instanceof Makanan)){
                JButton tombol;
                tombol = new JButton(item.getClass().getSimpleName() + " x" + sim.getInventory().getMap().get(item));
                tombol.setPreferredSize(new Dimension(300, 100));
                tombol.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                tombol.setFocusPainted(false);
                tombol.setBackground(Color.white);
                nonMakanan.add(tombol);
            }
        }
        frame.middlePanel.add(nonMakanan);

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new HomePage1(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        frame.setVisible(true);

        // frame = new JFrame();
        // frame.setTitle("SimPlicity 5 - Inventory");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(800,600);
        // frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // title = new JPanel();
        // title.setPreferredSize(new Dimension(1000, 300));
        // title.setBackground(Color.black);
        // titleText = new JLabel("Inventory");
        // titleText.setForeground(Color.white);
        // titleText.setFont(titleFont);
        // title.add(titleText);

        // makanan = new JPanel();
        // makanan.setPreferredSize(new Dimension(1000, 300));
        // makanan.setBackground(Color.green);
        // makananText = new JLabel("Makanan");
        // makananText.setForeground(Color.black);
        // makananText.setFont(titleFont);
        // makanan.add(makananText);    
        // for (Item item: sim.getInventory().getMap().keySet()){
        //     if(item instanceof Makanan){
        //         JButton tombol;
        //         tombol = new JButton(((Makanan) item).getNama() + " x" + sim.getInventory().getMap().get(item));
        //         tombol.setPreferredSize(new Dimension(300, 100));
        //         tombol.setFont(buttonFont);
        //         makanan.add(tombol);
        //     }
        // }

        // nonMakanan = new JPanel();
        // nonMakanan.setPreferredSize(new Dimension(1000, 300));
        // nonMakanan.setBackground(Color.blue);
        // nonMakananText = new JLabel("Non-Makanan");
        // nonMakananText.setForeground(Color.black);
        // nonMakananText.setFont(titleFont);
        // nonMakanan.add(nonMakananText);
        // for (Item item: sim.getInventory().getMap().keySet()){
        //     if (!(item instanceof Makanan)){
        //         JButton tombolNonMakanan;
        //         tombolNonMakanan = new JButton(item.getClass().getSimpleName() + " x" + sim.getInventory().getMap().get(item));
        //         tombolNonMakanan.setPreferredSize(new Dimension(300, 100));
        //         tombolNonMakanan.setFont(buttonFont);
        //         nonMakanan.add(tombolNonMakanan);
        //     }

        // }

        // back = new JButton("Back");
        // back.setPreferredSize(new Dimension(300, 100));
        // back.setFont(buttonFont);
        // back.addActionListener(e -> {
        //     frame.dispose();
        //     new HomePage(sim);
        // });

        // frame.add(title);
        // frame.add(makanan);
        // frame.add(nonMakanan);
        // frame.add(back);
        // frame.setVisible(true);
    }
}
