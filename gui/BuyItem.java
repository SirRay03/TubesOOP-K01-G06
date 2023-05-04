package gui;
import javax.swing.*;

import Items.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import src.*;

public class BuyItem {
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
            items.put("Kasur Queen", 100);
            items.put("Kasur King", 150);
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

        MyFrame frame = new MyFrame("Welcome to Nook's Cranny", "Give up all of your money to the almighty Tom Nook!");

        JPanel makananTitle = new JPanel();
        makananTitle.setPreferredSize(new Dimension(1200, 75));
        makananTitle.setBackground(Color.green);
        JLabel makananTitleText = new JLabel("Makanan");
        makananTitleText.setForeground(Color.black);
        makananTitleText.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        makananTitle.add(makananTitleText);
        frame.middlePanel.add(makananTitle);

        JPanel makanan = new JPanel();
        makanan.setLayout(new GridLayout(2, 7));
        makanan.setPreferredSize(new Dimension(1200, 200));
        makanan.setBackground(Color.green);
        for (Map.Entry<String,Integer> item : arrMakanan.items.entrySet()){
            MyButton tombol = new MyButton(item.getKey() + ", $" + item.getValue());
            tombol.setActionCommand(item.getKey());
            tombol.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if (sim.getUang() >= item.getValue()){
                        sim.setUang(sim.getUang() - item.getValue());
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
                        JOptionPane.showMessageDialog(null, "Maaf, uang anda tidak cukup! Anda butuh $" + (item.getValue()-sim.getUang()) + " lagi untuk membeli " + item.getKey() + "!", "Uang tidak cukup", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            makanan.add(tombol);
        }
        frame.middlePanel.add(makanan);

        JPanel nonMakananTitle = new JPanel();
        nonMakananTitle.setPreferredSize(new Dimension(1200, 75));
        nonMakananTitle.setBackground(Color.blue);
        JLabel nonMakananTitleText = new JLabel("Non-Makanan");
        nonMakananTitleText.setForeground(Color.black);
        nonMakananTitleText.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        nonMakananTitle.add(nonMakananTitleText);
        frame.middlePanel.add(nonMakananTitle);

        JPanel nonMakanan = new JPanel();
        nonMakanan.setLayout(new GridLayout(2, 7));
        nonMakanan.setPreferredSize(new Dimension(1200, 200));
        nonMakanan.setBackground(Color.blue);
        for (Map.Entry<String, Integer> map : arrNonMakanan.items.entrySet()){
            MyButton button = new MyButton(map.getKey() + ", $" + map.getValue());
            button.setActionCommand(map.getKey());
            button.setToolTipText("Harga: $" + map.getValue());
            button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (sim.getUang() >= map.getValue()){
                    sim.setUang(sim.getUang() - map.getValue());
                    switch (e.getActionCommand()){
                    case "Jam":
                        Jam jam = new Jam();
                        jam.beliBarang(sim);
                        break;
                    case "Kaca":
                        Kaca kaca = new Kaca();
                        kaca.beliBarang(sim);
                        break;
                    case "Kasur King":
                        Kasur kasurKing = new Kasur(Kasur.tipeKasur.Besar);
                        kasurKing.beliBarang(sim);
                        break;
                    case "Kasur Queen":
                        Kasur kasurQueen = new Kasur(Kasur.tipeKasur.Sedang);
                        kasurQueen.beliBarang(sim);
                        break;
                    case "Kasur Single":
                        Kasur kasurSingle = new Kasur(Kasur.tipeKasur.Kecil);
                        kasurSingle.beliBarang(sim);
                        break;
                    case "Kertas"://kertas kompor meja toilet
                        Kertas kertas = new Kertas();
                        kertas.beliBarang(sim);
                        break;
                    case "Kompor Gas":
                        Kompor komporGas = new Kompor(Kompor.tipeKompor.Sedang);
                        komporGas.beliBarang(sim);
                        break;
                    case "Kompor Listrik":
                        Kompor komporListrik = new Kompor(Kompor.tipeKompor.Kecil);
                        komporListrik.beliBarang(sim);
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
            nonMakanan.add(button);
        }
        frame.middlePanel.add(nonMakanan);

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new LandingPage(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);
    }
}


