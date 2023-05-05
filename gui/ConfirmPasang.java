package gui;

import javax.swing.*;
import java.awt.*;

import src.*;
import Items.*;

public class ConfirmPasang {
    MyFrame frame;
    public ConfirmPasang(Sim sim, Ruangan buffer, NonMakanan item){
        frame = new MyFrame("Are you sure about your placement?", "Press confirm/cancel.");
        frame.bottomPanel.setLayout(new FlowLayout());

        MyButton cancel = new MyButton("Cancel");
        cancel.setPreferredSize(new Dimension(200, 50));
        cancel.addActionListener(e ->
        {
            frame.dispose();
            sim.getInventory().addItem(item, 1);
            new LandingPage(sim);
        });
        frame.bottomPanel.add(cancel);


        MyButton confirm = new MyButton("Confirm");
        confirm.setPreferredSize(new Dimension(200, 50));
        confirm.addActionListener(e -> {
            for (int i=0; i<21; i++){
                for (int j=0; j<21; j++){
                    if (sim.getRumah().getDenahRumah()[i][j] == sim.getcurrentRuangan()){
                        buffer.setNamaRuangan(sim.getcurrentRuangan().getNamaRuangan());
                        sim.getRumah().getDenahRumah()[i][j] = buffer;
                        sim.setRuangan(buffer);
                    }
                }
            }
            frame.dispose();
            new LandingPage(sim);
        });
        frame.bottomPanel.add(confirm);

        frame.setVisible(true);

        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(600,600));
        frame.middlePanel.add(map);

        int diffCount = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (sim.getRuangan().getMatriksPemetaan()[i][j] != buffer.getMatriksPemetaan()[i][j]){
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
                // if (diffCount == 0){
                //     frame.middlePanel.remove(map);
                //     frame.middlePanel.add(new JLabel("No changes made."));
                // }
            }
        }
    }
}
