import java.util.*;

public class BahanMakanan extends Makanan implements Item {
    private int harga;
    private long waktuPengantaran;
    private long waktuMulai;
    public BahanMakanan(String nama, int kekenyangan, int harga){
        super(nama, kekenyangan);
        this.harga = harga;
        this.waktuPengantaran = 0;
        this.waktuMulai = 0;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public int getHarga(){
        return harga;
    }
    public String getNama(){
        return nama;
    }
    public long getWaktuPengantaran(){
        return waktuPengantaran;
    }
    public long getWaktuMulai(){
        return waktuMulai;
    };
    public void beliBarang(Sim sim){
        Random random = new Random();
        waktuPengantaran = (random.nextInt(4000) + 1000)*3000;
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
