package gui;

import src.*;
import javax.swing.*;
import Items.*;
import java.awt.*;
import java.io.IOError;

public class ViewInventory {
    MyFrame frame;
    JButton tombol;

    ViewInventory(Sim sim){
        frame = new MyFrame(sim.getFullName() + "'s - Inventory", "You can view all the items you have here");

        JPanel makananTitle = new JPanel();
        makananTitle.setPreferredSize(new Dimension(1200, 75));
        makananTitle.setBackground(Color.green);
        JLabel makananTitleText = new JLabel("Makanan");
        makananTitleText.setForeground(Color.black);
        makananTitleText.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        makananTitle.add(makananTitleText);
        frame.middlePanel.add(makananTitle);

        JPanel makanan = new JPanel();
        makanan.setLayout(new GridLayout(2,7));
        makanan.setPreferredSize(new Dimension(1200, 200));
        makanan.setBackground(Color.green);
        LoadMakananInventory(sim, makanan);
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
        nonMakanan.setLayout(new GridLayout(2,7));
        nonMakanan.setPreferredSize(new Dimension(1200, 200));
        nonMakanan.setBackground(Color.blue);
        LoadInventory(sim, nonMakanan);
        frame.middlePanel.add(nonMakanan);

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new LandingPage(sim);
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        frame.setVisible(true);
    }

    private void LoadMakananInventory(Sim sim, JPanel makanan) throws IOError {
        try{
            for (Item item: sim.getInventory().getMap().keySet()){
                if(item instanceof Makanan){
                    JButton tombol;
                    tombol = new JButton(((Makanan) item).getNama() + " x" + sim.getInventory().getMap().get(item));
                    tombol.setPreferredSize(new Dimension(150, 100));
                    tombol.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    tombol.setFocusPainted(false);
                    makanan.add(tombol);
                }
            }
        } catch(Exception Ex) {
            System.out.println("Error, inventory Makanan kosong");
        }
    }

    private Ruangan createBuffer(Sim sim){
        Ruangan buffer = new Ruangan("buffer");
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                buffer.getMatriksPemetaan()[i][j] = sim.getRuangan().getMatriksPemetaan()[i][j];
            }
        }
        return buffer;
    }

    private void LoadInventory(Sim sim, JPanel nonMakanan) throws IOError {
        try {
            for (Item item: sim.getInventory().getMap().keySet()){
                if(item instanceof NonMakanan){
                    if (item instanceof Kasur || item instanceof Kompor){
                        tombol = new JButton(((NonMakanan)item).getNama() + " x" + sim.getInventory().getMap().get(item));
                        tombol.setPreferredSize(new Dimension(150, 100));
                        tombol.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        tombol.setFocusPainted(false);
                        tombol.setBackground(Color.white);
                        nonMakanan.add(tombol);
                    }
                    else{
                        tombol = new JButton(item.getClass().getSimpleName() + " x" + sim.getInventory().getMap().get(item));
                        tombol.setPreferredSize(new Dimension(150, 100));
                        tombol.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        tombol.setFocusPainted(false);
                        tombol.setBackground(Color.white);
                        nonMakanan.add(tombol);
                    }
                    tombol.addActionListener(e -> {
                        Ruangan buffer = createBuffer(sim);
                        new PasangBarang(sim, (NonMakanan) item, buffer);
                        frame.dispose();
                    });
                }
            }
        } catch (Exception e) {
            System.out.println("Error, inventory Non Makanan kosong");
        }
    }
}
