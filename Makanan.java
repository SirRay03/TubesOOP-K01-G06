import java.util.Random;

public abstract class Makanan implements Item{
    protected String nama;
    protected int kekenyangan;
    public Makanan(String nama, int kekenyangan){
        this.nama = nama;
        this.kekenyangan = kekenyangan;
    }
    public void beliBarang(Sim sim){
        Random random = new Random();
        int waktuPengantaran = (random.nextInt(4000) + 1000)*3000;
        System.out.format("Barang berhasil dibeli. Silakan tunggu selama %d detik.\n", waktuPengantaran);        
        new Thread(() -> {
            try {
                Thread.sleep(waktuPengantaran);
            } catch (InterruptedException e) {
                System.out.println("Aksi terganggu!");
            }
            sim.getInventory().tambahJumlahObjek(this, 1);
        }).start();
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
