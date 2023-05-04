package gui;

import javax.swing.*;
import java.awt.*;

import src.*;
import Items.*;

public class PasangBarang {
    PasangBarang(Sim sim, NonMakanan item){
        MyFrame frame = new MyFrame("You are now in " + sim.getFirstName() + "'s house", sim.getRuangan().getNamaRuangan() + " Room");
        frame.bottomPanel.setLayout(new FlowLayout());

        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(600,600));
        frame.middlePanel.add(map);

        // NonMakanan[] items = sim.getRuangan().toPropArray();
        NonMakanan[][] before = sim.getRuangan().getMatriksPemetaan();

        for (NonMakanan[] x : sim.getRuangan().getMatriksPemetaan()){
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
                        sim.getRuangan().memasangBarang(item,x1,y1,sim);
                        frame.dispose();
                        new ConfirmPasang(sim, before);
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

        // for (Object any: items){
        //     if (any == null){
        //         JLabel prop = new JLabel("Empty");
        //         prop.setPreferredSize(new Dimension(50,50));
        //         prop.setOpaque(true);
        //         prop.setBackground(Color.WHITE);
        //         prop.setHorizontalAlignment(JLabel.CENTER);
        //         prop.setVerticalAlignment(JLabel.CENTER);
        //         prop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //         map.add(prop);
        //     }
        //     else{
        //         JLabel prop = new JLabel("Not Empty");
        //         prop.setPreferredSize(new Dimension(50,50));
        //         prop.setOpaque(true);
        //         prop.setBackground(Color.RED);
        //         prop.setHorizontalAlignment(JLabel.CENTER);
        //         prop.setVerticalAlignment(JLabel.CENTER);
        //         prop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //         map.add(prop);
        //     }
        // }
        
        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new LandingPage(sim);
        });
        frame.bottomPanel.add(back);

        // JTextField x = new JTextField();
        // x.setPreferredSize(new Dimension(100, 50));
        // x.setHorizontalAlignment(JTextField.CENTER);
        // x.setText("X-Position");
        // frame.bottomPanel.add(x);

        // JTextField y = new JTextField();
        // y.setPreferredSize(new Dimension(100, 50));
        // y.setHorizontalAlignment(JTextField.CENTER);
        // y.setText("Y-Position");
        // frame.bottomPanel.add(y);

        // MyButton moveRoom = new MyButton("Submit!");
        // moveRoom.setPreferredSize(new Dimension(200, 50));
        // moveRoom.addActionListener(e -> {
        //     sim.getRuangan().memasangBarang(item,Integer.parseInt(x.getText()),Integer.parseInt(y.getText()),sim);
        // });
        // frame.bottomPanel.add(moveRoom, BorderLayout.EAST);

        frame.setVisible(true);
    }
}