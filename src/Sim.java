package src;
import java.util.*;

import Items.*;

public class Sim {
    // deklarasi atribut
    private String firstName;
    private String lastName;
    private Pekerjaan pekerjaan;
    private int uang;
    private Kesejahteraan kesejahteraan;
    private String status; 
    private Point point;
    private Inventory<Item> inventory; 
    private Rumah currRumah;
    private Ruangan currRuangan;
    private List<Item> listOnDelivery;
    public int timerNoSleep;

    /**
     * Konstruktor
     * @param namalengkap
     */
    public Sim (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pekerjaan = new Pekerjaan();
        this.uang = 100000;
        this.kesejahteraan = new Kesejahteraan();
        this.point = new Point(0,0);
        this.inventory = new Inventory<Item>();
        this.status = "idle";
        this.listOnDelivery = new ArrayList<>();
        this.timerNoSleep = 0;
        this.currRumah = null;
        // //NANTI APUS
        // Kaca kaca = new Kaca();
        // BahanMakanan nasi = new BahanMakanan("Nasi", 5, 5);
        // BahanMakanan ayam = new BahanMakanan("Ayam", 8, 10);
        // Kasur queenBed = new Kasur(Kasur.tipeKasur.Queen);
        // //BELI BARANG
        // kaca.beliBarang(this);
        // nasi.beliBarang(this);
    }

    // === GETTER ===
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public int getUang() {
        return this.uang;
    }

    public String getStatus() {
        return this.status;
    }

    public List<Item> getListOnDelivery(){
            return listOnDelivery;
    }

    // private String getRandomPekerjaan() {
    //     String[] pekerjaan = {"Programmer", "Dokter", "Penulis", "Guru", "Insinyur", "Akuntan"};
    //     int randomIndex = new Random().nextInt(pekerjaan.length);
    //     return pekerjaan[randomIndex];
    // }

    public Pekerjaan getPekerjaan() {
        return this.pekerjaan;
    }

    public Kesejahteraan getKesejahteraan() {
        return this.kesejahteraan;
    }

    public Inventory<Item> getInventory() {
        return inventory;
    }

    public int getTimerNoSleep () {
        return timerNoSleep;
    }

    public Rumah getRumah(){
        return this.currRumah;
    }

    public Ruangan getRuangan(){
        return this.currRuangan;
    }

    public Point getPoint() {
        return this.point;
    }

    // === SETTER ===

    public void setUang(int uang) {
            this.uang = uang;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // public void setPekerjaan(String pekerjaan){
    //     this.pekerjaan = pekerjaan;
    // }

    public void setPoint(Point point) {
       this.point = point;
    }

    public void setRumah (Rumah rumah) {
        this.currRumah = rumah;
    }

    public void pindahRuangan (Ruangan ruangan) {
        this.currRuangan = ruangan;
    }

    // === METHOD ===

    public void addTimerBelumTidur(int duration){
        this.timerNoSleep += duration; // duration diambil dari durasi di method tidur
    }

    public void addToListOnDelivery(Item item){
        listOnDelivery.add(item);
    }

    public void resetTimerBelumTidurAfterSleep(){
        timerNoSleep = 0;
    }

    public void resetTimerNoSleepAfterNoSleep(Sim sim)
    {
        if (timerNoSleep >= 600)
        {
            System.out.println("Waktu Tidur Anda kurang! Harus segera tidur");
            timerNoSleep = 0;
            sim.kesejahteraan.setHealth(-5);
            sim.kesejahteraan.setMood(-5);
        }
    }

    public void deleteFromListOnDelivery(Item item){
        listOnDelivery.remove(item);
    }

    public void berkunjung() {
        boolean isValid = false;
        String opsi = "";
        int i = 0;
        while (!isValid)
        {
            try {
                System.out.println("Daftar rumah yang ada di World : ");
                for (int x = 0; x < 64; x++)
                {
                    for (int y = 0; y < 64; y++) 
                    {
                        if (World.getMap()[x][y] != null) 
                        {
                            System.out.println((i+1) + ". " + World.getMap()[x][y].getFullName());
                        }
                    }
                }
                System.out.print("Pilih rumah: ");
                opsi = scan.nextLine(); // bingung nnt sim nya bakal milih dlm bentuk apa ??
                isValid = true;
            }
            catch (Exception e) {
                System.out.println("Input invalid, silahkan input angka!");
                scan.nextLine();
            }
        }
        for (int x = 0; x < 64; x++)
        {
            for (int y = 0; y < 64; y++) 
            {
                if (World.getMap()[x][y] == null) 
                {
                    System.out.println("Tidak ada rumah di lokasi tersebut, tidak bisa dikunjungi!");
                }
                else if (World.getMap()[x][y].getFullName().equals(getFullName())){
                    System.out.println("Tidak bisa berkunjung ke rumah sendiri!");
                }
            }
        }
    }

    //     float waktuberkunjung = World.getDistance(); // gatau cara masukkin parameter rumah1, rumah2ny gmn
    //     int totalWaktuBerkunjung = (int) (waktuberkunjung * 10);
    //     Thread t = new Thread(()->{
    //     try{
    //             setRumah(getRumah());// get rumah sesuai opsi yang dipilih
    //             Thread.sleep(totalWaktuBerkunjung*1000); 
    //             getKesejahteraan().setMood(totalWaktuBerkunjung/30*10);
    //             getKesejahteraan().setHunger(-(totalWaktuBerkunjung/30*10)); 
    //             // World.addWaktu (totalWaktuBerkjung); nambahin waktu di world karean aksi aktif 
    //             System.out.println("Proses berkunjung selesai");
    //         }
    //         catch(InterruptedException e){
    //             System.out.println("Proses berkunjung terganggu");
    //         }
    //     });
    //     t.start();
    //     try{
    //         t.join();
    //     }catch(InterruptedException e){
    //         System.out.println("Proses berkunjung terganggu");
    //     }
    // }

    // public void selesaiBerkjung () {
    //     setRumah(currRumah);
    // }
}
