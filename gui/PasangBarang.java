package gui;

import javax.swing.*;
import java.awt.*;

import src.*;
import Items.*;

public class PasangBarang {
    PasangBarang(Sim sim, NonMakanan item, Ruangan buffer){
        MyFrame frame = new MyFrame("You are now in " + sim.getFirstName() + "'s house", sim.getRuangan().getNamaRuangan() + " Room");
        frame.bottomPanel.setLayout(new FlowLayout());

        System.out.println("Sebelom pasang:" + buffer);

        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(600,600));
        frame.middlePanel.add(map);

        for (NonMakanan[] x : buffer.getMatriksPemetaan()){
            for (NonMakanan y : x){
                if (y == null){
                    JButton prop = new JButton();
                    prop.setPreferredSize(new Dimension(50,50));
                    prop.setOpaque(true);
                    prop.setBackground(Color.WHITE);
                    prop.setHorizontalAlignment(JLabel.CENTER);
                    prop.setVerticalAlignment(JLabel.CENTER);
                    prop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    prop.addActionListener(e -> {
                        final int x1 = map.getComponentZOrder(prop) / 6;
                        final int y1 = map.getComponentZOrder(prop) % 6;
                        buffer.memasangBarang(item,x1,y1,sim);
                        frame.dispose();
                        System.out.println("Buffer setelah pasang: " + buffer);
                        System.out.println("Current ruangan: " + sim.getcurrentRuangan());
                        new ConfirmPasang(sim, buffer, item);
                    });
                    map.add(prop);
                }
                else{
                    JLabel prop = new JLabel("Not Empty");
                    prop.setPreferredSize(new Dimension(50,50));
                    prop.setOpaque(true);
                    prop.setBackground(Color.RED);
                    prop.setHorizontalAlignment(JLabel.CENTER);
                    prop.setVerticalAlignment(JLabel.CENTER);
                    prop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    map.add(prop);
                }
            }
        }

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new LandingPage(sim);
        });
        frame.bottomPanel.add(back);

        frame.setVisible(true);
    }
}