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
    public long timerNoSleep;
    public long startKerja = System.currentTimeMillis();
    public long elapsedTimeKerja;
    public double secKerja;
    private long timerNoBab;
    private boolean isBab;
    private int durasiKerja;
    private int durasiBerkunjung;
    private int durasiOlahraga;
    

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
        isBab = false;
        timerNoSleep = 0;
        timerNoBab= 0;
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

    public Pekerjaan getPekerjaan() {
        return this.pekerjaan;
    }

    public Kesejahteraan getKesejahteraan() {
        return this.kesejahteraan;
    }

    public Inventory<Item> getInventory() {
        return inventory;
    }

    public long getTimerNoSleep () {
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

    public int getdurasiKerja(){
        return durasiKerja;
    }

    public int getdurasiBerkunjung(){
        return durasiBerkunjung;
    }

    public int getdurasiOlahraga(){
        return durasiOlahraga;
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

    public Rumah getcurrentRumah () {
        return currRumah;
    }

    public void setRumah (Rumah rumah) {
        this.currRumah = rumah;
    }

    public void setRuangan (Ruangan ruangan) {
        this.currRuangan = ruangan;
    }

    public Ruangan getcurrentRuangan() {
        return currRuangan;
    }

    // === METHOD ===

    public void tambahWaktuBelumTidur(long duration){
        this.timerNoSleep += duration; 
        // duration diambil dari durasi di method tidur
        /* if(getStatus().equals("Sim sedang tidur")){
            this.timerNoSleep += 0;
        }
        else if(getStatus().equals("Sim sedang kerja")){
            this.timerNoSleep += getdurasiKerja();
        }
        else if(getStatus().equals("Sim sedang olahraga")){
            this.timerNoSleep += getdurasiOlahraga();
        }
        else if(getStatus().equals("Sim sedang berkunjung")){
            this.timerNoSleep += getdurasiBerkunjung();
        }
        else if(getStatus().equals("Sim sedang makan")){
            this.timerNoSleep += mejakursi.getdurasiMakan();
        }
        else if (getStatus().equals("Sim sedang buang air")){
            this.timerNoSleep += toilet.getdurasiBuangAir();
        }   
        else if(getStatus().equals("Sim sedang masak")){
            this.timerNoSleep += kompor.getdurasiMasak();
        } */
    }

    public void addToListOnDelivery(Item item){
        listOnDelivery.add(item);
    }

    public void addToListUpgrade(Rumah rumah){
        listUpgrade.add(rumah);
    }

    public void resetTimerBelumTidurSetelahTidur(){
        timerNoSleep = 0;
    }

    public void resetWaktuTidurAfterNoSleep()
    {
        if (timerNoSleep >= 600000) // tidak tidur > 10 menit
        {
            System.out.println("Waktu Tidur Anda kurang! Sim terluka! Segeralah tidur");
            timerNoSleep = 0;
            kesejahteraan.setHealth(-5);
            kesejahteraan.setMood(-5);
        }
    }

    public void deleteFromListOnDelivery(Item item){
        listOnDelivery.remove(item);
    }

    public void deleteFromListUpgrade(Rumah rumah ){
        listUpgrade.remove(rumah);
    }

    public void resetTimerBelumBab () {
        if (timerNoBab > 240000 & isBab) {
            System.out.println("Anda belum BAB, Sim terluka! Segeralah buang air!");
            timerNoBab = 0;
            getKesejahteraan().setHealth(-5);
            getKesejahteraan().setMood(-5);
        }
    }

    public void tambahWaktuBelumBAB (long duration) {
        if (isBab) {
            timerNoBab += duration;
        }
        /* if (getStatus().equals("Sim sedang buang air")){
            this.timerNoSleep += 0;
        }  
        else if(getStatus().equals("Sim sedang tidur")){
            this.timerNoSleep += kasur.getdurasiTidur();
        }
        else if(getStatus().equals("Sim sedang kerja")){
            this.timerNoSleep += getdurasiKerja();
        }
        else if(getStatus().equals("Sim sedang olahraga")){
            this.timerNoSleep += getdurasiOlahraga();
        }
        else if(getStatus().equals("Sim sedang berkunjung")){
            this.timerNoSleep += getdurasiBerkunjung();
        }
        else if(getStatus().equals("Sim sedang makan")){
            this.timerNoSleep += mejakursi.getdurasiMakan();
        } 
        else if(getStatus().equals("Sim sedang masak")){
            this.timerNoSleep += kompor.getdurasiMasak();
        } */
    }

    public void resetTimerBabAfterBab() {
        timerNoBab = 0;
    }

    public void setStatusBab(boolean isBab){
        this.isBab = isBab;
    }
    public void berkunjung (Scanner scan) {
        setStatus("Sim sedang berkunjung");
        boolean isValid = false;
        int i = 0;
        while (!isValid)
        {
            try {
                System.out.println("Daftar rumah yang ada di World : ");
                for (int x = 0; x < 64; x++)
                {
                    for (int y = 0; y < 64; y++) 
                    {
                        if (World.getInstance().getMap()[x][y] != null) 
                        {
                            System.out.println((i+1) + ". " + World.getInstance().getSimList()[i].getFirstName());
                        }
                    }
                }
                System.out.print("Pilih rumah: ");
                //opsi = scan.nextLine(); // bingung nnt sim nya bakal milih dlm bentuk apa ??
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
                if (World.getInstance().getMap()[x][y] == null) 
                {
                    System.out.println("Tidak ada rumah di lokasi tersebut, tidak bisa dikunjungi!");
                }
                else if (World.getInstance().getMap()[x][y].getOwner().getFullName().equals(getFullName())){
                    System.out.println("Tidak bisa berkunjung ke rumah sendiri!");
                }
            }
        }
        //float waktuberkunjung = World.getInstance().getDistance(); // gatau cara masukkin parameter rumah1, rumah2ny gmn
        float waktuberkunjung = 30;
        int totalWaktuBerkunjung = (int) (waktuberkunjung * 10);
        int durasiBerkunjung = totalWaktuBerkunjung;
        Thread t = new Thread(()->{
        try{
                setRumah(getRumah());// get rumah sesuai opsi yang dipilih
                Thread.sleep(totalWaktuBerkunjung*1000); 
                getKesejahteraan().setMood(totalWaktuBerkunjung/30*10);
                getKesejahteraan().setHunger(-(totalWaktuBerkunjung/30*10)); 
                // World.getInstance().addWaktu (totalWaktuBerkjung); nambahin waktu di world karean aksi aktif 
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

    public void olahraga(int waktuOlahraga){
        setStatus("Sim sedang olahraga");
        boolean valid = false;
        //Validasi input
        while (!valid) 
        {
            try 
            {
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println("Input tidak valid. Masukkan input berupa angka!");
            }
        }
        while (waktuOlahraga % 20 != 0)
        {
            System.out.println("Input harus berupa kelipatan 20! Silakan input ulang!");
            valid = false;
            while (!valid)
            {
                try 
                {
                    System.out.print("Masukkan durasi olahraga (dalam detik dan kelipatan 20):");
                    valid = true;
                }
                catch (Exception e) 
                {
                    System.out.println("Input tidak valid. Masukkan input berupa angka!");
                }
            }
        }
        int durasiOlahraga = waktuOlahraga;
        Thread t = new Thread(()->{
        try{
                System.out.println("Sim sedang olahraga...");
                Thread.sleep(1000*durasiOlahraga); 
            }
            catch(InterruptedException e){
                System.out.println("Proses olahraga terganggu");
            }
        });
        t.start();
        try{
            t.join();
            getKesejahteraan().setMood(10* durasiOlahraga);
            getKesejahteraan().setHunger(-5* durasiOlahraga);
            getKesejahteraan().setHealth(5*durasiOlahraga);
            World.getInstance().addWaktu(durasiOlahraga*1000);
            // World.getInstance().checkSimTime(durasiOlahraga);
            tambahWaktuBelumTidur(durasiOlahraga*1000);
            tambahWaktuBelumBAB(durasiOlahraga*1000); 
            resetTimerBelumBab();
            resetWaktuTidurAfterNoSleep();
            System.out.println("Proses olahraga selesai");
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

    public void kerja(Pekerjaan profesi) throws DeadException{
        setStatus("Sim sedang bekerja");
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        double sec = 0;
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
        int durasiKerja = waktuKerja; // variabel buat durasi kerja
        while(waktuKerja%120 == 0){
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
                    //long  elapsedTime = System.currentTimeMillis() - start; //120000
                    //sec = sec + Math.floor(elapsedTime/1000); // 120 detik = 2 menit
                    //getGaji();
                    getKesejahteraan().setMood(-40);
                    getKesejahteraan().setHunger(-40);
                    World.getInstance().addWaktu(durasiKerja);
                    // World.getInstance().checkSimTime(durasiKerja);
                    tambahWaktuBelumTidur(waktuKerja);
                    tambahWaktuBelumBAB(waktuKerja); 
                    resetTimerBelumBab();
                    resetWaktuTidurAfterNoSleep();
                }catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }

                if (sec == 240.0){
                    setUang(pekerjaan.getGaji());
                }
            }
            else if (waktuKerja == 240){ // kerja 4 menit (langsung gajian)
                System.out.println("Sim sedang bekerja");
                Thread t = new Thread (()->{
                try{
                    Thread.sleep(240000); // 240 detik (1 siklus kerja)
                    //setUang(getGaji());
                    getKesejahteraan().setMood(-80);
                    getKesejahteraan().setHunger(-80);
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
                throw new DeadException();
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
