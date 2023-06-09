package Items;
import java.util.*;
import javax.swing.*;

import src.*;

public abstract class Makanan implements Item{
    protected String nama;
    protected int kekenyangan;
    private int waktuPengantaran;
    private int waktuMulai;
    private int hariMulai;

    public Makanan(String nama, int kekenyangan){
        this.nama = nama;
        this.kekenyangan = kekenyangan;
        this.waktuPengantaran = 0;
        this.waktuMulai = 0;
        this.hariMulai = 0;
    }
    public int getKekenyangan(){
        return kekenyangan;
    }
    public int getWaktuPengantaran(){
        return waktuPengantaran;
    }
    public int getWaktuMulai(){
        return waktuMulai;
    }
    public int getHariMulai(){
        return hariMulai;
    }
    public void beliBarang(Sim sim){
        World world = World.getInstance();
        Random random = new Random();

        waktuPengantaran = (random.nextInt(4) + 1)*30;
        System.out.format("Barang berhasil dibeli. Silakan tunggu selama %d detik.\n", waktuPengantaran);
        int finalTime = World.getInstance().getTime() + waktuPengantaran*1000;
        JOptionPane.showMessageDialog(null, "Barang berhasil dibeli. Silakan tunggu selama " + waktuPengantaran + " detik.", "Pembelian Sedang diproses", JOptionPane.INFORMATION_MESSAGE);
        Runnable r = () -> {
            sim.addToListOnDelivery(this); 
            hariMulai = world.getDay();
            waktuMulai = world.getTime();
            while (World.getInstance().getTime() <  finalTime){
                    try {
                        //System.out.format("Barang berhasil dibeli. Silakan tunggu selama %d detik.\n", waktuPengantaran); 
                        Thread.sleep(1000);
                        //Thread.sleep(waktuPengantaran*1000);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null,"Kurir nyasar, barang tidak sampai", "Kurir Nyasar", JOptionPane.ERROR_MESSAGE);
                    }
            } 
            sim.deleteFromListOnDelivery(this);
            waktuMulai = 0;
            hariMulai = 0;
            sim.getInventory().addItem(this, 1); 
            JOptionPane.showMessageDialog(null, ((BahanMakanan) this).getNama() + " Telah Sampai", "Pengiriman Selesai", JOptionPane.INFORMATION_MESSAGE); 
            };
        Thread thread = new Thread(r);
        thread.start();
    }
    public String getNama(){
        return this.nama;
    }

/**
 * MAIN BELI BARANG
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kategori barang apa yang ingin dibeli?");
        System.out.println("1. Non-Makanan");
        System.out.println("2. Bahan Makanan");
        int jenis = scanner.nextInt();
        if (jenis == 1){
            System.out.println("1. Kasur Single\n2. Kasur Queen Size\n3. Kasur King Size\n4. Toilet\n 5. Kompor Gas\n6. Kompor Listrik\n7. Meja dan Kursi\n8. Jam");
            int jenisNonMakanan = scanner.nextInt();
            if (jenisNonMakanan == 1 && kondisi uang cukup){
                Kasur singleBed = new Kasur(Kasur.tipeKasur.Single);
                singleBed.beliBarang();
            }
        }else if (jenis == 2){
            System.out.println("1. Nasi\n2. Kentang\n3. Ayam\n4. Sapi\n 5. Wortel\n6. Bayam\n7. Kacang\n8. Susu");            
            int jenisNonMakanan = scanner.nextInt();
            if (jenisNonMakanan == 1){
                BahanMakanan nasi = new BahanMakanan("nasi", 5, 5);
                nasi.beliBarang();
            }
        }
 */
}
