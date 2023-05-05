package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.*;
import Items.*;

public class RoomMap {
    RoomMap(Sim sim){
        MyFrame frame = new MyFrame("You are now in " + sim.getcurrentRumah().getOwner().getFirstName() + "'s house", sim.getRuangan().getNamaRuangan() + " Room");

        JPanel map = new JPanel();
        map.setLayout(new GridLayout(6,6));
        map.setBackground(Color.BLUE);
        map.setPreferredSize(new Dimension(600,600));
        frame.middlePanel.add(map);

        for (Object any: sim.getRuangan().toPropArray()){
            if (any != null){
                JButton prop = new JButton(any.getClass().getSimpleName());
                prop.setFont(new Font("Arial", Font.PLAIN, 10));
                prop.setPreferredSize(new Dimension(50,50));
                prop.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (any.getClass().getSimpleName().equals("MejaKursi")){
                            String[] actionNames = {"Main", "Makan", "Minum", "Berdoa"};
                            String selectedAction = (String) JOptionPane.showInputDialog(null, "Pilih aksi:", "Aksi Meja Kursi", JOptionPane.QUESTION_MESSAGE, null, actionNames, actionNames[0]);
                            switch (selectedAction){
                                case "Main":
                                    try {
                                        //try{
                                            int number = Integer.parseInt((String) JOptionPane.showInputDialog("Lama waktu main?: "));
                                            ((MejaKursi) any).main(number, sim);
                                            //sim.getKesejahteraan().isAlive();
                                        //} catch (DeadException dead){
                                            //JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                                            //new MainMenu();
                                            //World.getInstance().removeSim(sim);
                                        //}                                           
                                    } 
                                    catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Input harus berupa angka!", "Gagal", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;
                                case "Berdoa":
                                    ((MejaKursi) any).berdoa(sim);
                                    break;
                                case "Minum":
                                    try{    
                                        ((MejaKursi) any).minum(sim);
                                        sim.getKesejahteraan().isAlive();
                                    } catch (DeadException dead){
                                        JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                                        new MainMenu();
                                        World.getInstance().removeSim(sim);
                                    }  
                                    break;
                                default:
                                    ((MejaKursi) any).doAction(sim);
                                    break;
                            }
                        }
                        else if (any instanceof Toilet){
                            String[] actionNames = {"Buang Air", "Mandi"};
                            String selectedAction = (String) JOptionPane.showInputDialog(null, "Pilih aksi:", "Aksi Toilet", JOptionPane.QUESTION_MESSAGE, null, actionNames, actionNames[0]);
                            switch (selectedAction){
                                case "Mandi":
                                    try{
                                        ((Toilet) any).mandi(sim);
                                        sim.getKesejahteraan().isAlive();
                                    } catch (DeadException dead){
                                        JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                                        new MainMenu();
                                        World.getInstance().removeSim(sim);
                                    }
                                    break;
                                default:
                                    try{
                                        ((Toilet) any).doAction(sim);
                                        sim.getKesejahteraan().isAlive();
                                    } catch (DeadException dead){
                                        JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                                        new MainMenu();
                                        World.getInstance().removeSim(sim);
                                    }
                                    break;
                            }
                        }
                        else{
                            try{
                                ((NonMakanan) any).doAction(sim);
                                sim.getKesejahteraan().isAlive();
                            } catch (DeadException dead){
                                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                                new MainMenu();
                                World.getInstance().removeSim(sim);
                            }
                        }
                    }
                });
                map.add(prop);
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
        }
        
        if (sim.getcurrentRumah().getOwner() == sim){
            MyButton back = new MyButton("Back");
            back.setPreferredSize(new Dimension(200, 50));
            back.addActionListener(e -> {
                frame.dispose();
                new LandingPage(sim);
            });
            frame.bottomPanel.setLayout(new BorderLayout());
            frame.bottomPanel.add(back, BorderLayout.WEST);
        }
        else{
            MyButton goHome = new MyButton("Go Home");
            goHome.setPreferredSize(new Dimension(200, 50));
            goHome.addActionListener(e -> {
                sim.berkunjung(sim.getRumah());
                frame.dispose();
                new RoomMap(sim);
            });
            frame.bottomPanel.setLayout(new BorderLayout());
            frame.bottomPanel.add(goHome, BorderLayout.WEST);

            MyButton viewSimInfo = new MyButton("View Sim Info");
            viewSimInfo.setPreferredSize(new Dimension(200, 50));
            viewSimInfo.addActionListener(e -> {
                new SimInfo(sim);
            });
            frame.bottomPanel.add(viewSimInfo, BorderLayout.CENTER);
        }

        

        if (sim.getcurrentRumah() != sim.getRumah()){
            MyButton goHome = new MyButton("Go Home");
            goHome.setPreferredSize(new Dimension(200, 50));
            goHome.addActionListener(e -> {
                sim.setRumah(sim.getRumah());
                sim.setRuangan(sim.getRumah().searchRuangan("Kamar Utama"));
                frame.dispose();
                new RoomMap(sim);
            });
        }
        

        MyButton moveRoom = new MyButton("Move");
        moveRoom.setPreferredSize(new Dimension(200, 50));
        moveRoom.addActionListener(e -> {
            String[] rooms = sim.getRumah().getRoomNames();
            String room = (String) JOptionPane.showInputDialog(null, "Choose room", "Move Room", JOptionPane.QUESTION_MESSAGE, null, rooms, rooms[0]);
            Ruangan pindah = sim.getRumah().searchRuangan(room);
            sim.setRuangan(pindah);
            frame.dispose();
            new RoomMap(sim);
        });
        frame.bottomPanel.add(moveRoom, BorderLayout.EAST);

        frame.setVisible(true);
    }
}