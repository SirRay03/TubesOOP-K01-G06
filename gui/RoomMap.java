package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.*;
import Items.*;

public class RoomMap {
    RoomMap(Sim sim){
        String subtitle;
        if (sim.getcurrentRumah().getOwner() == sim){
            subtitle = sim.getRuangan().getNamaRuangan() + " Room";
        }
        else{
            subtitle = sim.getRuangan().getNamaRuangan() + " Room. Status: " + "Sedang berkunjung";
        }
        MyFrame frame = new MyFrame("You are now in " + sim.getcurrentRumah().getOwner().getFirstName() + "'s house", subtitle);

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
                            if (selectedAction == null) return;
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
                                            JOptionPane.showMessageDialog(null, "Input error!", "Gagal", JOptionPane.ERROR_MESSAGE);
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
                                case "Makan":
                                    ((MejaKursi) any).doAction(sim);                                         
                                default:
                                    JOptionPane.showMessageDialog(null, "Error!", "Gagal", JOptionPane.ERROR_MESSAGE);
                                    break;
                            }
                        }
                        else if (any instanceof Toilet){
                            String[] actionNames = {"Buang Air", "Mandi"};
                            String selectedAction = (String) JOptionPane.showInputDialog(null, "Pilih aksi:", "Aksi Toilet", JOptionPane.QUESTION_MESSAGE, null, actionNames, actionNames[0]);
                            if (selectedAction == null) return;
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
            back.setPreferredSize(new Dimension(300, 50));
            back.addActionListener(e -> {
                frame.dispose();
                new LandingPage(sim);
            });
            frame.bottomPanel.setLayout(new BorderLayout());
            frame.bottomPanel.add(back, BorderLayout.WEST);

            MyButton removeItem = new MyButton("Remove Item");
            removeItem.setPreferredSize(new Dimension(300, 50));
            removeItem.addActionListener(e -> {
                frame.dispose();
                new RemoveItem(sim);
            });
            frame.bottomPanel.add(removeItem, BorderLayout.EAST);
        }
        else{
            MyButton goHome = new MyButton("Go Home");
            goHome.setPreferredSize(new Dimension(300, 50));
            goHome.addActionListener(e -> {
                sim.berkunjung(sim.getRumah());
                frame.dispose();
                new RoomMap(sim);
            });
            frame.bottomPanel.setLayout(new BorderLayout());
            frame.bottomPanel.add(goHome, BorderLayout.WEST);

            MyButton viewSimInfo = new MyButton("View Sim Info");
            viewSimInfo.setPreferredSize(new Dimension(300, 50));
            viewSimInfo.addActionListener(e -> {
                new SimInfo(sim);
            });
            frame.bottomPanel.add(viewSimInfo, BorderLayout.EAST);
        }

        MyButton moveRoom = new MyButton("Move");
        moveRoom.setPreferredSize(new Dimension(200, 50));
        moveRoom.addActionListener(e -> {
            String[] rooms = sim.getRumah().getRoomNames();
            if (rooms.length == 0) {
                JOptionPane.showMessageDialog(null, "No other rooms available", "You only have one room", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else{
                String room = (String) JOptionPane.showInputDialog(null, "Choose room", "Move Room", JOptionPane.QUESTION_MESSAGE, null, rooms, rooms[0]);
                if (room == null) return;
                else if (room.equals("Under Construction")){
                    JOptionPane.showMessageDialog(null, "Room is under construction", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                else{
                    Ruangan pindah = sim.getRumah().searchRuangan(room);
                    sim.setRuangan(pindah);
                    frame.dispose();
                    new RoomMap(sim);
                }
            }
        });
        frame.bottomPanel.add(moveRoom, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}