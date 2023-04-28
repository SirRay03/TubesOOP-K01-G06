package objects;
import java.lang.Math;

import essentials.Sim;
public class Kompor extends NonMakanan {
    public enum tipeKompor{
        Gas(100, 2, 1),
        Listrik(200, 1, 1);

        private int panjang;
        private int lebar; 
        private int harga;

        tipeKompor(int harga, int panjang, int lebar){
            this.harga = harga;
            this.lebar = lebar;
            this.panjang = panjang;
        }
    }

    public Kompor(tipeKompor tipe){
        super(tipe.harga, tipe.panjang, tipe.lebar);
    }

    public void doAction(Object... args){//memasak(Sim sim, String namaMasakan)
        Sim sim = (Sim) args[0];
        String namaMasakan = (String) args[1];
        MasakanBuilder builder = new MasakanBuilder();
        builder.setNama(namaMasakan);
        switch(namaMasakan){
            case "Nasi Ayam":
                builder.setKekenyangan(16);
                builder.setNasi((BahanMakanan) sim.getInventory().getItemBahanMakanan("nasi", 1)); //butuh getter nasi dari inventory
                builder.setKentang((BahanMakanan) sim.getInventory().getItemBahanMakanan("kentang", 1)); //butuh getter ayam dari inventory
                break;
            case "Nasi Kari":
                builder.setKekenyangan(30);
                builder.setNasi((BahanMakanan) sim.getInventory().getItemBahanMakanan("nasi", 1)); //butuh getter nasi dari inventory
                builder.setKentang((BahanMakanan) sim.getInventory().getItemBahanMakanan("kentang", 1)); //butuh getter dari inventory
                builder.setWortel((BahanMakanan) sim.getInventory().getItemBahanMakanan("wortel", 1)); //butuh getter dari inventory
                builder.setSapi((BahanMakanan) sim.getInventory().getItemBahanMakanan("sapi", 1));//butuh getter dari inventory
                break;
            case "Susu Kacang":
                builder.setKekenyangan(5);
                builder.setSusu((BahanMakanan) sim.getInventory().getItemBahanMakanan("susu", 1)); //butuh getter nasi dari inventory
                builder.setKacang((BahanMakanan) sim.getInventory().getItemBahanMakanan("kacang", 1)); //butuh getter dari inventory
                break;
            case "Tumis Sayur":
                builder.setKekenyangan(5);
                builder.setWortel((BahanMakanan) sim.getInventory().getItemBahanMakanan("wortel", 1)); //butuh getter dari inventory
                builder.setBayam((BahanMakanan) sim.getInventory().getItemBahanMakanan("bayam", 1)); //butuh getter dari inventory
                break;
            case "Bistik":
                builder.setKekenyangan(22);
                builder.setKentang((BahanMakanan) sim.getInventory().getItemBahanMakanan("kentang", 1)); //butuh getter dari inventory
                builder.setSapi((BahanMakanan) sim.getInventory().getItemBahanMakanan("sapi", 1));//butuh getter dari inventory
            default:
                builder.setKekenyangan(16);
                builder.setNasi((BahanMakanan) sim.getInventory().getItemBahanMakanan("nasi", 1)); //butuh getter nasi dari inventory
                builder.setKentang((BahanMakanan) sim.getInventory().getItemBahanMakanan("kentang", 1)); //butuh getter ayam dari inventory
        }
        Masakan masakan = builder.build();
        sim.setStatus("Sim sedang memasak");
        System.out.println("Sim sedang memasak...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(builder.getKekenyangan()*1500); 
                sim.getKesejahteraan().setMood(10); //namabah mood 10
                System.out.println("Proses memasak selesai");
            }
            catch(InterruptedException e){
                System.out.println("Proses memasak terganggu");
            }
        });
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            System.out.println("Proses memasak terganggu");
        }
        sim.getInventory().addItem(masakan, 1); //ini masukin ke inventory

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
