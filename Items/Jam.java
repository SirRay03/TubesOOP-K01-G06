package Items;

import javax.swing.*;

import src.*;

public class Jam extends NonMakanan {
    public Jam(){
        super(10, 1, 1);
    }
    public String getNama(){
        return "Jam";
    }
    public void printListAction(){
        System.out.println("1. Melihat Jam");
    };

    public void doAction(Object... args){
        World world = World.getInstance();
        Sim sim =(Sim) args[0];

        int hour;
        int minute;
        int second;
        int duration;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        minute = (720000 - world.getTime()%720000) / 60000;
        second =  ((720000 - world.getTime()%720000) % 60000)/1000;
        panel.add(new JLabel("SISA WAKTU HARI INI ADALAH " + minute + " MENIT " + second +" DETIK."));

        panel.add(new JLabel("SISA WAKTU PENGIRIMAN ITEM"));
        if(sim.getListOnDelivery().isEmpty()){
            panel.add(new JLabel("Tidak ada barang dalam pengiriman"));
        }
        else{
            for(Item a : sim.getListOnDelivery()){
                if(a instanceof NonMakanan){    
                    NonMakanan nonMakanan = (NonMakanan) a;
                    duration = (nonMakanan.getWaktuPengantaran()*1000 - (world.getTime() - nonMakanan.getWaktuMulai()))/1000;
                    hour = duration/3600;
                    minute = (duration - hour*3600) / 60;
                    second = (duration - hour*3600) % 60; 
                    if (nonMakanan instanceof Kasur || nonMakanan instanceof Kompor){
                        panel.add(new JLabel(nonMakanan.getNama().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK."));
                    }
                    else{
                        panel.add(new JLabel(nonMakanan.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK."));
                    }
                } 
                else if(a instanceof BahanMakanan){
                    BahanMakanan bahanMakanan = (BahanMakanan) a;
                    duration = (bahanMakanan.getWaktuPengantaran()*1000  - (world.getTime() - bahanMakanan.getWaktuMulai()))/1000;
                    hour = duration/3600;
                    minute = (duration - hour*3600) / 60;
                    second = (duration - hour*3600) % 60;    
                    panel.add(new JLabel(bahanMakanan.getNama().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second +" DETIK."));
                }       
            }
        }
        panel.add(new JLabel("SISA WAKTU UPGRADE RUMAH"));
        if(sim.getListUpgrade().isEmpty()){
            panel.add(new JLabel("Tidak ada rumah yang sedang diupgrade"));
        }
        else{
            for(Rumah rumah : sim.getListUpgrade()){
                duration = (rumah.getWaktuUpgrade()  - (World.getInstance().getTime() - rumah.getWaktuMulai()))/1000;
                hour = duration/3600;
                panel.add(new JLabel("SISA WAKTU" + rumah.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + ((duration-hour*3600)/60) + " MENIT " + ((duration-hour*3600)%60) + " DETIK."));
            }
        }
        JOptionPane.showMessageDialog(null, panel, "Jam", JOptionPane.INFORMATION_MESSAGE);
    }
}