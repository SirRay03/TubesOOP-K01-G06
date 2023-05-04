package Items;

import javax.swing.JOptionPane;

import src.Sim;
import src.World;
public class Kompor extends NonMakanan {
    private String nama;

    public enum tipeKompor{
        Sedang("Gas", 100, 2, 1),
        Kecil("Listrik", 200, 1, 1);

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
        String[] cookBook = {"Nasi Ayam", "Nasi Kari", "Susu Kacang", "Tumis Sayur", "Bistik"};
        String namaMasakan = (String) JOptionPane.showInputDialog(null, "Makanan apa yang ingin dimasak?", "Masak", JOptionPane.QUESTION_MESSAGE, null, cookBook, cookBook[0]);
        MasakanBuilder builder = new MasakanBuilder();
        boolean cukup = false;
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
        int durasiMasak = (int)Math.round(builder.getKekenyangan()*1.5);
        if (cukup){
            Masakan masakan = builder.build();
            sim.setStatus("Sim sedang memasak");
            System.out.println("Sim sedang memasak...");
            Thread t = new Thread(()->{
            try{
                    Thread.sleep(builder.getKekenyangan()*1500); 
                }
                catch(InterruptedException e){
                    System.out.println("Proses memasak terganggu");
                }
            });
            t.start();
            try{
                t.join();
                sim.getKesejahteraan().setMood(10); //namabah mood 10
                World.getInstance().addWaktu(durasiMasak);
                sim.tambahWaktuBelumTidur(durasiMasak);
                sim.tambahWaktuBelumBAB(durasiMasak); 
                sim.resetTimerBelumBab();
                sim.resetWaktuTidurAfterNoSleep();
                System.out.println("Proses memasak selesai");
            }catch(InterruptedException e){
                System.out.println("Proses memasak terganggu");
            }
            sim.getInventory().addItem(masakan, 1); //ini masukin ke inventory
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