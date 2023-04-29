package gui;
import javax.swing.*;

import Items.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import src.*;

public class BuyItem {
    JFrame frame;
    JPanel title;
    JButton back;
    JLabel titleText;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
    JPanel makanan;
    JPanel nonMakanan;
    JPanel makananButton;
    JPanel nonMakananButton;
    JLabel makananText;
    JLabel nonMakananText;

    private class MakananDB{
        private Map<String, Integer> items;
        
        public MakananDB(){
            items = new HashMap<>();
            items.put("Nasi", 5);
            items.put("Kentang", 3);
            items.put("Ayam", 10);
            items.put("Sapi", 12);
            items.put("Wortel", 3);
            items.put("Bayam", 3);
            items.put("Kacang", 2);
            items.put("Susu", 2);
        }
    }

    private class NonMakananDB{
        private Map<String, Integer> items;

        public NonMakananDB(){
            items = new HashMap<>();
            items.put("Jam", 10);
            items.put("Kaca", 75);
            items.put("Kasur Single", 50);
            items.put("Kasur Queen Size", 100);
            items.put("Kasur King Size", 150);
            items.put("Kertas", 5);
            items.put("Kompor Gas", 100);
            items.put("Kompor Listrik", 200);
            items.put("MejaKursi", 50);
            items.put("Toilet", 50);
        }
    }

    BuyItem(Sim sim){
        MakananDB arrMakanan = new MakananDB();
        NonMakananDB arrNonMakanan = new NonMakananDB();

        frame = new JFrame();
        frame.setTitle("SimPlicity 5 - Buy Items");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,1000);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        title = new JPanel();
        title.setPreferredSize(new Dimension(1500, 300));
        title.setBackground(Color.black);
        titleText = new JLabel("Welcome to Nook's Cranny");
        titleText.setForeground(Color.white);
        titleText.setFont(titleFont);
        title.add(titleText);

        makanan = new JPanel();
        makanan.setPreferredSize(new Dimension(1500, 100));
        makanan.setBackground(Color.green);
        makananText = new JLabel("Makanan");
        makananText.setForeground(Color.black);
        makananText.setFont(titleFont);
        makanan.add(makananText);

        makananButton = new JPanel();
        makananButton.setPreferredSize(new Dimension(1500, 300));
        makananButton.setBackground(Color.green);
        makananButton.setLayout(new GridLayout(2, 4));
        for (Map.Entry<String, Integer> map : arrMakanan.items.entrySet()){
            JButton tombol;
            tombol = new JButton(map.getKey() + ", $" + map.getValue());
            tombol.setActionCommand(map.getKey());
            tombol.setPreferredSize(new Dimension(300, 100));
            tombol.setFont(buttonFont);
            makananButton.add(tombol);
            tombol.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if (sim.getUang() >= map.getValue()){
                        switch (e.getActionCommand()){
                        case "Nasi":
                            BahanMakanan Nasi = new BahanMakanan("Nasi", 5, 5);
                            Nasi.beliBarang(sim);
                            break;
                        case "Kentang":
                            BahanMakanan Kentang = new BahanMakanan("Kentang", 4, 3);
                            Kentang.beliBarang(sim);
                            break;
                        case "Ayam":
                            BahanMakanan Ayam = new BahanMakanan("Ayam", 8, 10);
                            Ayam.beliBarang(sim);
                            break;
                        case "Sapi":
                            BahanMakanan Sapi = new BahanMakanan("Sapi", 8, 10);
                            Sapi.beliBarang(sim);
                            break;
                        case "Wortel":
                            BahanMakanan Wortel = new BahanMakanan("Wortel", 8, 10);
                            Wortel.beliBarang(sim);
                            break;
                        case "Bayam":
                            BahanMakanan Bayam = new BahanMakanan("Bayam", 8, 10);
                            Bayam.beliBarang(sim);
                            break;
                        case "Kacang":
                            BahanMakanan Kacang = new BahanMakanan("Kacang", 8, 10);
                            Kacang.beliBarang(sim);
                            break;
                        case "Susu":
                            BahanMakanan Susu = new BahanMakanan("Susu", 8, 10);
                            Susu.beliBarang(sim);
                            break;
                        }   
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Maaf, uang anda tidak cukup! Anda butuh $" + (map.getValue()-sim.getUang()) + " lagi untuk membeli " + map.getKey() + "!", "Uang tidak cukup", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

        nonMakanan = new JPanel();
        nonMakanan.setPreferredSize(new Dimension(1500, 100));
        nonMakanan.setBackground(Color.blue);
        nonMakananText = new JLabel("Non-Makanan");
        nonMakananText.setForeground(Color.black);
        nonMakananText.setFont(titleFont);
        nonMakanan.add(nonMakananText);

        nonMakananButton = new JPanel();
        nonMakananButton.setPreferredSize(new Dimension(1500, 300));
        nonMakananButton.setBackground(Color.blue);
        nonMakananButton.setLayout(new GridLayout(2, 4));
        for (Map.Entry<String, Integer> map : arrNonMakanan.items.entrySet()){
            JButton tombol;
            tombol = new JButton(map.getKey() + ", $" + map.getValue());
            tombol.setActionCommand(map.getKey());
            tombol.setToolTipText("Harga: $" + map.getValue());
            tombol.setPreferredSize(new Dimension(300, 100));
            tombol.setFont(buttonFont);
            nonMakananButton.add(tombol);
            tombol.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if (sim.getUang() >= map.getValue()){
                        switch (e.getActionCommand()){
                        case "Jam":
                            Jam jam = new Jam();
                            jam.beliBarang(sim);
                            break;
                        case "Kaca":
                            Kaca kaca = new Kaca();
                            kaca.beliBarang(sim);
                            break;
                        case "Kasur King Size":
                            Kasur kasurKing = new Kasur(Kasur.tipeKasur.King);
                            kasurKing.beliBarang(sim);
                            break;
                        case "Kasur Queen Size":
                            Kasur kasurQueen = new Kasur(Kasur.tipeKasur.Queen);
                            kasurQueen.beliBarang(sim);
                            break;
                        case "Kasur Single Size":
                            Kasur kasurSingle = new Kasur(Kasur.tipeKasur.Single);
                            kasurSingle.beliBarang(sim);
                            break;
                        case "Kertas"://kertas kompor meja toilet
                            Kertas kertas = new Kertas();
                            kertas.beliBarang(sim);
                            break;
                        case "Kompor Gas":
                            Kompor komporGas = new Kompor(Kompor.tipeKompor.Gas);
                            komporGas.beliBarang(sim);
                            break;
                        case "MejaKursi":
                            MejaKursi mejaKursi = new MejaKursi();
                            mejaKursi.beliBarang(sim);
                            break;
                        case "Toilet":
                            Toilet toilet = new Toilet();
                            toilet.beliBarang(sim);
                            break;
                    }
                    }else{
                         JOptionPane.showMessageDialog(null, "Maaf, uang anda tidak cukup! Anda butuh $" + (map.getValue()-sim.getUang()) + " lagi untuk membeli " + map.getKey() + "!", "Uang tidak cukup", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

        back = new JButton("Back");
        back.setPreferredSize(new Dimension(300, 100));
        back.setFont(buttonFont);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new HomePage(sim);
            }
        });

        frame.add(title);
        frame.add(makanan);
        frame.add(makananButton);
        frame.add(nonMakanan);
        frame.add(nonMakananButton);
        title.add(back);
        frame.setVisible(true);
    }
}
