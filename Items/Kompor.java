package Items;

import javax.swing.JOptionPane;

import gui.*;
import src.Sim;
import src.World;
public class Kompor extends NonMakanan {
    private String nama;

    public enum tipeKompor{
        Sedang("Kompor Gas", 100, 2, 1),
        Kecil("Kompor Listrik", 200, 1, 1);

        private String nama;
        private int panjang;
        private int lebar; 
        private int harga;

        tipeKompor(String nama, int harga, int panjang, int lebar){
            this.nama = nama;
            this.harga = harga;
            this.lebar = lebar;
            this.panjang = panjang;
        }
    }

    public Kompor(tipeKompor tipe){
        super(tipe.harga, tipe.panjang, tipe.lebar);
        this.nama = tipe.nama;
    }
    
    public String getNama(){
        return this.nama;
    }

    public void printListAction(){
        System.out.println("1. Memasak");
    };

    public void doAction(Object... args){//memasak(Sim sim, String namaMasakan)
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang memasak");
        MyOverlay frame = new MyOverlay(sim.getFirstName() + " is now cooking!", "Call them Walter White because they be cookin' some addictive stuff..." , sim.getStatus());
        String[] cookBook = {"Nasi Ayam", "Nasi Kari", "Susu Kacang", "Tumis Sayur", "Bistik"};
        String namaMasakan = (String) JOptionPane.showInputDialog(null, "Makanan apa yang ingin dimasak?", "Masak", JOptionPane.QUESTION_MESSAGE, null, cookBook, cookBook[0]);
        MasakanBuilder builder = new MasakanBuilder();
        boolean cukup = false;
        if (namaMasakan == null) {
            JOptionPane.showMessageDialog(null, "You have cancelled this action.", "Masak", JOptionPane.INFORMATION_MESSAGE);
            frame.close();
        } else {
        switch(namaMasakan){
            case "Nasi Ayam":
                if (sim.getInventory().checkerItemBahanMakanan("Nasi", 1) || sim.getInventory().checkerItemBahanMakanan("Ayam", 1)){
                    JOptionPane.showMessageDialog(null, "Bahan makanan tidak cukup", "Gagal", JOptionPane.ERROR_MESSAGE);
                }else{
                    builder.setNama(namaMasakan);
                    builder.setKekenyangan(16);
                    builder.setNasi((BahanMakanan) sim.getInventory().getItem("Nasi", 1)); //butuh getter nasi dari inventory
                    builder.setAyam((BahanMakanan) sim.getInventory().getItem("Ayam", 1)); //butuh getter ayam dari inventory
                    cukup = true;
                }
                break;
            case "Nasi Kari":
            if (sim.getInventory().checkerItemBahanMakanan("Nasi", 1) || sim.getInventory().checkerItemBahanMakanan("Kentang", 1) || sim.getInventory().checkerItemBahanMakanan("Wortel", 1) || sim.getInventory().checkerItemBahanMakanan("Sapi", 1)){
                JOptionPane.showMessageDialog(null, "Bahan makanan tidak cukup", "Gagal", JOptionPane.ERROR_MESSAGE);
            }else{
                builder.setNama(namaMasakan);
                builder.setKekenyangan(30);
                builder.setNasi((BahanMakanan) sim.getInventory().getItem("Nasi", 1)); //butuh getter nasi dari inventory
                builder.setKentang((BahanMakanan) sim.getInventory().getItem("Kentang", 1)); //butuh getter dari inventory
                builder.setWortel((BahanMakanan) sim.getInventory().getItem("Wortel", 1)); //butuh getter dari inventory
                builder.setSapi((BahanMakanan) sim.getInventory().getItem("Sapi", 1));//butuh getter dari inventory
                cukup = true;
            }
            break;
            case "Susu Kacang":
            if (sim.getInventory().checkerItemBahanMakanan("Susu", 1) || sim.getInventory().checkerItemBahanMakanan("Kacang", 1)){
                JOptionPane.showMessageDialog(null, "Bahan makanan tidak cukup", "Gagal", JOptionPane.ERROR_MESSAGE);
            }else{
                builder.setNama(namaMasakan);
                builder.setKekenyangan(5);
                builder.setSusu((BahanMakanan) sim.getInventory().getItem("Susu", 1)); //butuh getter nasi dari inventory
                builder.setKacang((BahanMakanan) sim.getInventory().getItem("Kacang", 1)); //butuh getter dari inventory
                cukup = true;
            }
                break;
            case "Tumis Sayur":
            if (sim.getInventory().checkerItemBahanMakanan("Wortel", 1) || sim.getInventory().checkerItemBahanMakanan("Bayam", 1)){
                JOptionPane.showMessageDialog(null, "Bahan makanan tidak cukup", "Gagal", JOptionPane.ERROR_MESSAGE);
            }else{
                builder.setNama(namaMasakan);
                builder.setKekenyangan(5);
                builder.setWortel((BahanMakanan) sim.getInventory().getItem("Wortel", 1)); //butuh getter dari inventory
                builder.setBayam((BahanMakanan) sim.getInventory().getItem("Bayam", 1)); //butuh getter dari inventory
                cukup = true;
            }
                break;
            case "Bistik":
            if (sim.getInventory().checkerItemBahanMakanan("Kentang", 1) || sim.getInventory().checkerItemBahanMakanan("Sapi", 1)){
                JOptionPane.showMessageDialog(null, "Bahan makanan tidak cukup", "Gagal", JOptionPane.ERROR_MESSAGE);
            }else{
                builder.setNama(namaMasakan);
                builder.setKekenyangan(22);
                builder.setKentang((BahanMakanan) sim.getInventory().getItem("Kentang", 1)); //butuh getter dari inventory
                builder.setSapi((BahanMakanan) sim.getInventory().getItem("Sapi", 1));//butuh getter dari inventory
                cukup = true;
            }
                break;
        }
        }
        int durasiMasak = (int)Math.round(builder.getKekenyangan()*1.5);
        if (cukup){
            Masakan masakan = builder.build();
            JOptionPane.showMessageDialog(null, "Your sim is now cooking " + namaMasakan + " for " + durasiMasak + " seconds!. Don't panic if the screen is frozen. Just press Ok and we'll notify you when it's done!", "Masak", JOptionPane.INFORMATION_MESSAGE);
            Thread t = new Thread(()->{
            try{
                    Thread.sleep(builder.getKekenyangan()*1500); 
                }
                catch(InterruptedException e){
                    JOptionPane.showMessageDialog(null, "Proses memasak terganggu", "Gagal", JOptionPane.ERROR_MESSAGE);
                    frame.close();
                }
            });
            t.start();
            try{
                t.join();
                sim.getKesejahteraan().setMood(10); //namabah mood 10
                World.getInstance().addWaktu(durasiMasak);
                sim.tambahWaktuBelumTidur(durasiMasak);
                sim.tambahWaktuBelumBAB(durasiMasak); 
                sim.setTimerGantiKerja(durasiMasak);
                sim.resetTimerBelumBab();
                sim.resetWaktuTidurAfterNoSleep();
                sim.tambahDurasiBerkunjung(durasiMasak);
                JOptionPane.showMessageDialog(null, "Your sim is done cooking " + namaMasakan + "!", "Masak", JOptionPane.INFORMATION_MESSAGE);
                frame.close();
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, "Proses memasak terganggu", "Gagal", JOptionPane.ERROR_MESSAGE);
                frame.close();
            }
            sim.getInventory().addItem(masakan, 1); //ini masukin ke inventory
        }
        else{
            frame.close();
        }
    }
}
/**
 * CARA RUN DI MAIN*
LIAT CARA DI KASUR.JAVA
Cara MASAK
        Kompor k1 = new Kompor(Kompor.tipeKompor.Gas);
        if (insert validasi kecukupan inventory)
        k1.memasak(sim, "Nasi Ayam");
 */