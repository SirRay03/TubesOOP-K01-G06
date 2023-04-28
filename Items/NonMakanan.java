package Items;
import java.util.*;

import src.Actionable;
import src.Sim;
public abstract class NonMakanan implements Item, Actionable{
    protected int panjang; 
    protected int lebar; 
    protected int harga;
    protected long waktuPengantaran;
    private long waktuMulai;
    public NonMakanan(int harga,int panjang, int lebar){
        this.harga = harga;
        this.lebar = lebar;
        this.panjang = panjang;
        this.waktuPengantaran =0;
        this.waktuMulai = 0;
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
    public long getWaktuPengantaran(){
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
    public long getWaktuMulai(){
        return waktuMulai;
    };
    public void beliBarang(Sim sim){
        Random random = new Random();
        waktuPengantaran = (random.nextInt(4000) + 1000)*30;
        System.out.format("Barang berhasil dibeli. Silakan tunggu selama %d detik.\n", waktuPengantaran); 
        new Thread(() -> {
            try {
                sim.addToListOnDelivery(this); 
                waktuMulai = System.currentTimeMillis();
                Thread.sleep(waktuPengantaran);
                sim.deleteFromListOnDelivery(this);
                waktuMulai = 0;
            } catch (InterruptedException e) {
                System.out.println("Aksi terganggu!");
            }
            sim.getInventory().addItem(this, 1);
        }).start();
    }
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
            if (jenisNonMakanan == 1 && uang >= (insert harga kasur single)){
                Kasur singleBed = new Kasur(Kasur.tipeKasur.Single);
                singleBed.beliBarang();
            }
        }else if (jenis == 2){
            System.out.println("1. Nasi\n2. Kentang\n3. Ayam\n4. Sapi\n 5. Wortel\n6. Bayam\n7. Kacang\n8. Susu");            
            int jenisNonMakanan = scanner.nextInt();
            if (jenisNonMakanan ==  1 && uang >= (insert harga nasi)){
                BahanMakanan nasi = new BahanMakanan("nasi", 5, 5);
                nasi.beliBarang();
            }
        }
 */