package src;
import java.util.*;
import Items.*;


public class Sim {
    // deklarasi atribut
    private String firstName;
    private String lastName;
    //private String pekerjaan;
    private Pekerjaan pekerjaan;
    private int uang;
    private Kesejahteraan kesejahteraan;
    private String status; 
    private Point point;
    private Inventory<Item> inventory; 
    private Rumah currRumah;
    private Ruangan currRuangan;
    private List<Item> listOnDelivery;
    private List<Rumah> listUpgrade;
    public int timerNoSleep;
    public long startKerja = System.currentTimeMillis();
    public long elapsedTimeKerja;
    public double secKerja;

    /**
     * Konstruktor
     * @param namalengkap
     */
    public Sim (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.pekerjaan = getRandomPekerjaan();
        this.pekerjaan = new Pekerjaan();
        this.uang = 100000;
        this.kesejahteraan = new Kesejahteraan();
        this.point = new Point(0,0);
        this.inventory = new Inventory<Item>();
        this.status = "idle";
        this.listOnDelivery = new ArrayList<>();
        this.listUpgrade = new ArrayList<>(); 
        this.timerNoSleep = 0;
        this.currRumah = null;
        this.currRuangan = null;
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

    public List<Rumah> getListUpgrade(){
            return listUpgrade;
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

    public void setPekerjaan(Pekerjaan pekerjaan){
        this.pekerjaan = pekerjaan;
    }

    public void setPoint(Point point) {
       this.point = point;
    }

    public void setRumah (Rumah rumah) {
        this.currRumah = rumah;
    }

    public void setRuangan (Ruangan ruangan) {
        this.currRuangan = ruangan;
    }

    // === METHOD ===

    public void addTimerBelumTidur(int duration){
        this.timerNoSleep += duration; // duration diambil dari durasi di method tidur
    }

    public void addToListOnDelivery(Item item){
        listOnDelivery.add(item);
    }

    public void addToListUpgrade(Rumah rumah){
        listUpgrade.add(rumah);
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

    public void deleteFromListUpgrade(Rumah rumah ){
        listUpgrade.remove(rumah);
    }

    public void berkunjung (Scanner scan) {
        boolean isValid = false;
        String opsi ;
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
                else if (World.getMap()[x][y].getOwner().getFullName().equals(getFullName())){
                    System.out.println("Tidak bisa berkunjung ke rumah sendiri!");
                }
            }
        }
        float waktuberkunjung = World.getDistance(); // gatau cara masukkin parameter rumah1, rumah2ny gmn
        int totalWaktuBerkunjung = (int) (waktuberkunjung * 10);
        Thread t = new Thread(()->{
        try{
                setRumah(getRumah());// get rumah sesuai opsi yang dipilih
                Thread.sleep(totalWaktuBerkunjung*1000); 
                getKesejahteraan().setMood(totalWaktuBerkunjung/30*10);
                getKesejahteraan().setHunger(-(totalWaktuBerkunjung/30*10)); 
                // World.addWaktu (totalWaktuBerkjung); nambahin waktu di world karean aksi aktif 
                System.out.println("Proses berkunjung selesai");
            }
            catch(InterruptedException e){
                System.out.println("Proses berkunjung terganggu");
            }
        });
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            System.out.println("Proses berkunjung terganggu");
        }
    }

    public void selesaiBerkjung () {
        setRumah(currRumah);
    }

    /*
     *     public String[] getRoomNames(){
        String[] roomNames = new String[roomCount];
        int i = 0;
        for (int j = 0; j < 21; j++){
            for (int k = 0; k < 21; k++){
                if (denahRumah[j][k] != null){
                    roomNames[i] = denahRumah[j][k].getNamaRuangan();
                    i++;
                }
            }
        }
        return roomNames;
    }
     */
    public void merenung(){

        System.out.println("Tanyakan sesuatu untuk direnungkan! Kamu akan mendapatkan jawaban acak.");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Random random = new Random();
        int pilihanJawaban = (random.nextInt(10));
        switch(pilihanJawaban){
            case 0:
                System.out.println("Semua akan baik-baik saja!");
                break;
            case 1:
                System.out.println("Lakukan lebih baik!");
                break;
            case 2:
                System.out.println("Semangat!");
                break;
            case 3:
                System.out.println("Tidak perlu overthinking");
                break;
            case 4:
                System.out.println("Just do it!");
                break;
            case 5:
                System.out.println("Ayo, kamu pasti bisa!");
                break;
            case 6:
                System.out.println("Yakin? Coba pikir lagi");
                break;
            case 7:
                System.out.println("Hal itu terlalu rumit untuk direnungkan");
                break;
            case 8:
                System.out.println("Hal yang sangat baik untuk direnungkan");
                break;
            case 9:
                System.out.println("Itu ide yang sangat baik!");
                break;
            default:
                System.out.println("Merenunglah kembali!");
            }
            scan.close();
    }
    public void olahraga(){
        setStatus("Sim sedang olahraga");
        System.out.println("Sim sedang olahraga...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(20000); 
                getKesejahteraan().setMood(10);
                getKesejahteraan().setHunger(-5);
                getKesejahteraan().setHealth(5); 
                System.out.println("Proses olahraga selesai");
            }
            catch(InterruptedException e){
                System.out.println("Proses olahraga terganggu");
            }
        });
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            System.out.println("Proses olahraga terganggu");
        }
    }

    public void goToObject(String objek){
        boolean notFound = true;
        for(NonMakanan nonMakanan : currRuangan.getListObjek()){
            if(notFound){
                if(nonMakanan.toString().equals(objek)){
                    if(nonMakanan instanceof Jam){
                        Jam jam = (Jam) nonMakanan;
                        jam.printListAction();
                    }
                    else if(nonMakanan instanceof Kaca){
                        Kaca kaca = (Kaca) nonMakanan;
                        kaca.printListAction();
                    }
                    else if(nonMakanan instanceof Kasur){
                        Kasur kasur = (Kasur) nonMakanan;
                        kasur.printListAction();
                    }
                    else if(nonMakanan instanceof Kertas){
                        Kertas kertas = (Kertas) nonMakanan;
                        kertas.printListAction();
                    }
                    else if(nonMakanan instanceof MejaKursi){
                        MejaKursi mejaKursi = (MejaKursi) nonMakanan;
                        mejaKursi.printListAction();
                    }
                    else if(nonMakanan instanceof Toilet){
                        Toilet toilet = (Toilet) nonMakanan;
                        toilet.printListAction();
                    }
                    else if(nonMakanan instanceof Kompor){
                        Kompor kompor = (Kompor) nonMakanan;
                        kompor.printListAction();
                    }
                    notFound = false;
                }
            }
        }
    }

    public void kerja(Pekerjaan profesi){
        setStatus("Sim sedang bekerja");
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int waktuKerja = 0;
        while(!valid){
            try{
                System.out.print("Masukkan durasi kerja: ");
                waktuKerja = scan.nextInt();
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println("Input tidak valid. Masukkan input berupa angka!");
                scan.nextLine();
            }
        }
        while(waktuKerja % 120 != 0){
            System.out.println("Input harus berupa kelipatan 120!");
            valid = false;
            while (!valid)
            {
                try 
                {
                    System.out.print("Masukkan durasi kerja (dalem detik dan kelipatan 240):");
                    waktuKerja = scan.nextInt();
                    valid = true;
                }
                catch (Exception e) 
                {
                    System.out.println("Input tidak valid. Masukkan input berupa angka!");
                    scan.nextLine();
                }
            }
        }
        if(waktuKerja%120 == 0){
            if(waktuKerja == 120){ // kerja 2 menit (belom gajian)
                System.out.println("Sim sedang bekerja...");
                Thread t = new Thread (()->{
                try{
                    Thread.sleep(120000); // 120 detik (1 siklus kerja)
                } catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }
                });
                t.start();
                try{
                    t.join();
                    getKesejahteraan().setMood(-40);
                    getKesejahteraan().setHunger(-40);
                    System.out.println("Proses bekerja selesai");
                    gajian();
                }catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }
                gajian();
            }
            else if (waktuKerja == 240){ // kerja 4 menit (langsung gajian)
                System.out.println("Sim sedang bekerja");
                Thread t = new Thread (()->{
                try{
                    Thread.sleep(240000); // 240 detik (1 siklus kerja)
                } catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }
                });
                t.start();
                try{
                    t.join();
                    System.out.println("Proses bekerja selesai");
                    getKesejahteraan().setMood(-80);
                    getKesejahteraan().setHunger(-80);
                    gajian();
                }catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }
            }
            else if(waktuKerja > 240){ //360
                System.out.println("Sim akan langsung mati");
            }
        }
        scan.close();
    }
    public void gajian(){
        elapsedTimeKerja = System.currentTimeMillis() - startKerja;
        secKerja = Math.floor(elapsedTimeKerja/1000);
        if(secKerja > 240.0){
            setUang(pekerjaan.getGaji());
        }
    }

    
}

