package Items;
import java.util.*;

import src.*;
public abstract class NonMakanan implements Item, Actionable{
    protected int panjang; 
    protected int lebar; 
    protected int harga;
    protected int waktuPengantaran;
    protected int hariMulai;
    private int waktuMulai;
    public NonMakanan(int harga,int panjang, int lebar){
        this.harga = harga;
        this.lebar = lebar;
        this.panjang = panjang;
        this.waktuPengantaran =0;
        this.waktuMulai = 0;
        this.hariMulai=0;
    }
    public int getKekenyangan(){
        return 0;
    }
    public int getPanjang(){
        return panjang;
    }
    public int getLebar(){
        return lebar;
    }
    public int getHarga(){
        return harga;
    }
    public int getWaktuPengantaran(){
        return waktuPengantaran;
    }
    public void setPanjang(int panjang){
        this.panjang = panjang;
    }
    public void setLebar(int lebar){
        this.lebar = lebar;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public int getWaktuMulai(){
        return waktuMulai;
    }
    public int getHariMulai(){
        return hariMulai;
    }
    public void beliBarang(Sim sim){
        // Random random = new Random();
        // waktuPengantaran = (random.nextInt(4000) + 1000)*30;
        // System.out.format("Barang berhasil dibeli. Silakan tunggu selama %d detik.\n", waktuPengantaran); 
        // new Thread(() -> {
        //     try {
        //         sim.addToListOnDelivery(this); 
        //         waktuMulai = System.currentTimeMillis();
        //         Thread.sleep(3000);
        //         //Thread.sleep(waktuPengantaran);
        //         sim.deleteFromListOnDelivery(this);
        //         waktuMulai = 0;
        //     } catch (InterruptedException e) {
        //         System.out.println("Aksi terganggu!");
        //     }
        //     sim.getInventory().addItem(this, 1);
        // }).start();
        World world = World.getInstance();
        Random random = new Random();
        waktuPengantaran = (random.nextInt(4) + 1)*30;
        System.out.format("Barang berhasil dibeli. Silakan tunggu selama %d detik.\n", waktuPengantaran); 
        int finalTime = World.getInstance().getTime() + waktuPengantaran*1000;
        System.out.println(finalTime);
        System.out.println(World.getInstance().getTime());
        Runnable r = () -> {
            sim.addToListOnDelivery(this); 
            waktuMulai = world.getTime();
            hariMulai = world.getDay();
            while (World.getInstance().getTime() <=  finalTime){
                    try {
                        //System.out.format("Barang berhasil dibeli. Silakan tunggu selama %d detik.\n", waktuPengantaran); 
                        Thread.sleep(1000);
                        //Thread.sleep(waktuPengantaran*1000);
                    } catch (InterruptedException e) {
                        System.out.println("Aksi terganggu!");
                    }
            }
            sim.deleteFromListOnDelivery(this);
            waktuMulai = 0;
            hariMulai = 0;
            sim.getInventory().addItem(this, 1);
            System.out.println(finalTime);
            System.out.println(World.getInstance().getTime());
            sim.getInventory().printInventory();
            };
        Thread thread = new Thread(r);
        thread.start();
    }
    public abstract void printListAction();
}