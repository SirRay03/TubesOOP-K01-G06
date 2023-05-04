package gui;

import javax.swing.*;
import java.awt.*;

import src.*;
import Items.*;

public class ConfirmPasang {
    MyFrame frame;
    public ConfirmPasang(Sim sim, NonMakanan[][] before){
        frame = new MyFrame("Are you sure about your placement?", "Press confirm/cancel.");
        frame.bottomPanel.setLayout(new FlowLayout());

        NonMakanan[][] after = sim.getRuangan().getMatriksPemetaan();

        MyButton confirm = new MyButton("Confirm");
        confirm.addActionListener(e -> {
            frame.dispose();
        });

        MyButton cancel = new MyButton("Cancel");
        cancel.addActionListener(e -> {
            sim.getRuangan().setMatriksPemetaan(before);
            frame.dispose();
        });

        frame.setVisible(true);

        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(600,600));
        frame.middlePanel.add(map);

        int diffCount = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (before[i][j] != after[i][j]){
                    JLabel prop = new JLabel();
                    prop.setPreferredSize(new Dimension(50,50));
                    prop.setOpaque(true);
                    prop.setBackground(Color.GREEN);
                    prop.setHorizontalAlignment(JLabel.CENTER);
                    prop.setVerticalAlignment(JLabel.CENTER);
                    prop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    map.add(prop);
                    diffCount++;
                }
                else{
                    JLabel prop = new JLabel();
                    prop.setPreferredSize(new Dimension(50,50));
                    prop.setOpaque(true);
                    prop.setBackground(Color.WHITE);
                    prop.setHorizontalAlignment(JLabel.CENTER);
                    prop.setVerticalAlignment(JLabel.CENTER);
                    prop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    map.add(prop);
                }
                if (diffCount == 0){
                    frame.middlePanel.remove(map);
                    frame.middlePanel.add(new JLabel("No changes made."));
                }
            }
        }
    }
}
