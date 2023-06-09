package Items;
import javax.swing.*;
import java.awt.*;

import src.Sim;
import src.World;
import gui.*;
//import src.World2;

public class Kasur extends NonMakanan {
    
    private String nama;
    private int duration;

    public enum tipeKasur{
        Kecil("Kasur Single",50, 4, 1),
        Sedang("Kasur Queen",100, 4, 2),
        Besar("Kasur King",150, 5, 2);

        private String nama;
        private int panjang; //buat select kata barengan pake ctrl+d
        private int lebar; 
        private int harga;

        tipeKasur(String nama, int harga, int panjang, int lebar){
            this.nama = nama;
            this.harga = harga;
            this.lebar = lebar;
            this.panjang = panjang;
        }
    }

    public Kasur(tipeKasur tipe){
        super(tipe.harga, tipe.panjang, tipe.lebar);
        this.nama = tipe.nama;
    }

    public String getNama(){
        return nama;
    }

    public int getdurasiTidur(){
        return duration;
    }

    public void printListAction(){
        System.out.println("1. Tidur");
    };

    public void doAction(Object... args){
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang tidur");

        MyOverlay frame = new MyOverlay("Your sim is now sleeping zzz...", "Do not panic if the app looks like it's not responding. It's just your sim sleeping.", sim.getStatus());
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(500, 100));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 60, 0);
        slider.setMajorTickSpacing(4);
        slider.setMinorTickSpacing(4);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider, BorderLayout.CENTER);

        int option = JOptionPane.showOptionDialog(null, panel, "Select duration (in seconds)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
            duration = (slider.getValue())*60;
        } else {
            duration = 0;
            frame.dispose();
            return;
        }

        JOptionPane.showMessageDialog(null, "Your sim is now sleeping for " + slider.getValue() + " minutes!. Don't panic if the screen is frozen. Just press Ok and we'll notify you when it's done!", "Makan", JOptionPane.INFORMATION_MESSAGE);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(duration*1000); //duration * 1000

                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, "Tidur terganggu");
                    sim.setStatus("Idle");
                    frame.close();
                }
            }
        });    
        thread.start();
        try{
            thread.join();
            sim.getKesejahteraan().setHealth(20 * (duration / 240));
            sim.getKesejahteraan().setMood(30 * (duration / 240));
            JOptionPane.showMessageDialog(null, "Tidur selesai!", "Tidur", JOptionPane.INFORMATION_MESSAGE);
            World.getInstance().addWaktu(duration*1000);
            sim.tambahWaktuBelumBAB(duration*1000);
            sim.setTimerGantiKerja(duration*1000);
            sim.resetTimerBelumBab();
            sim.resetTimerBelumTidurSetelahTidur();
            sim.tambahDurasiBerkunjung(duration);
            frame.dispose();
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "Tidur terganggu");
            frame.dispose();
        }
    }
}