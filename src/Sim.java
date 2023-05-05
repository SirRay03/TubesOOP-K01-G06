package src;
import java.util.*;
import javax.swing.*;
import Items.*;
import gui.MainMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;


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
    private Rumah ownRumah;
    private Rumah currRumah;
    private Ruangan currRuangan;
    private List<Item> listOnDelivery;
    private List<Rumah> listUpgrade;
    public int timerNoSleep;
    public long startKerja = System.currentTimeMillis();
    public long elapsedTimeKerja;
    public double secKerja;
    private int timerNoBab;
    private boolean isBab;
    private boolean isGantiKerja;
    private int durasiKerja;
    private int durasiBerkunjung;
    private int durasiOlahraga; 
    private int timerAfterChangeOccupation;
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
        isGantiKerja =false;
        timerNoSleep = 0;
        timerNoBab= 0;
        timerAfterChangeOccupation=999999999;
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

    public int getTimerAfterGantiKerja(){
        return this.timerAfterChangeOccupation;
    }

    public Rumah getRumah(){
        return this.ownRumah;
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

    public Ruangan getcurrentRuangan() {
        return currRuangan;
    }

    public Rumah getcurrentRumah() {
        return currRumah;
    }
    public boolean getisGantiKerja(){
        return this.isGantiKerja;
    }

    // === SETTER ===

    public synchronized void setUang(int uang) {
            this.uang = this.uang + uang;
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

    public void setRumah(Rumah rumah) {
        this.ownRumah = rumah;
    }

    public void setCurrentRumah (Rumah rumah) {
        this.currRumah = rumah;
    }

    public void setRuangan (Ruangan ruangan) {
        this.currRuangan = ruangan;
    }

    public void setDurasiKerja(int durasi){
        this.durasiKerja += durasi;
    }

    public void setTimerGantiKerja(int duration){
        if(isGantiKerja){
            this.timerAfterChangeOccupation += duration;
        }
        else{
            this.timerAfterChangeOccupation =0;
        }
    }

    // === METHOD ===

    

    public void tambahWaktuBelumTidur(int duration){
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
            try{
                kesejahteraan.setHealth(-5);
                kesejahteraan.setMood(-5);
                kesejahteraan.isAlive();
            } catch (DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                    World.getInstance().removeSim(this);
            }
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

    public void tambahWaktuBelumBAB (int duration) {
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
    public void setisGantiKerja(boolean status){
            this.isGantiKerja = status;
    }

    public void berkunjung (Rumah dikunjung) {
        currRuangan = dikunjung.getDenahRumah()[11][11];
        int x1 = currRumah.getHAddress();
        int y1 = currRumah.getVAddress();
        int x2 = dikunjung.getHAddress();
        int y2 = dikunjung.getVAddress();
        int waktuberkunjung = World.getInstance().getDistance(x1, y1, x2, y2);
        int confirm = (int) JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin berkunjung ke rumah ini? Proses ini akan memakan waktu " + waktuberkunjung + " detik.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.out.println("Proses berkunjung dimulai");
            Thread t = new Thread(()->{
            try{
                    currRumah = dikunjung;// get rumah sesuai opsi yang dipilih
                    Thread.sleep(waktuberkunjung*1000); //totalWaktuBerkunjung*1000
                    World.getInstance().addWaktu(waktuberkunjung*1000);
                    setTimerGantiKerja(waktuberkunjung*1000);
                    System.out.println(waktuberkunjung); 
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
        else{
            System.out.println("Proses berkunjung dibatalkan");
        }
    }

    public void pulang () {
        int x1 = currRumah.getHAddress();
        int y1 = currRumah.getVAddress();
        int x2 = ownRumah.getHAddress();
        int y2 = ownRumah.getVAddress();
        float waktuPulang = World.getInstance().getDistance(x1, x2, y1, y2);
        int totalWaktuPulang = ((int) waktuPulang);
        Thread t = new Thread(()->{
        try{
                setCurrentRumah(ownRumah);
                Thread.sleep(totalWaktuPulang*1000); 
                World.getInstance().addWaktu(totalWaktuPulang); 
                setTimerGantiKerja(totalWaktuPulang*1000);
                System.out.println("Berhasil Pulang! Kamu sedang berada di rumah kamu sendiri");
            }
            catch(InterruptedException e){
                System.out.println("Proses pulang terganggu, tidak bisa pulang!");
            }
        });
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            System.out.println("Proses pulang terganggu, tidak bisa pulang!");
        }
    }

    public void tambahDurasiBerkunjung (int duration) {
        if (currRumah != ownRumah) {
            durasiBerkunjung += duration ;
            if (durasiBerkunjung >= 30000) {
                 getKesejahteraan().setMood(10);
                 getKesejahteraan().setHunger(-10);
                 durasiBerkunjung -= 30000;
            }
        }
    }

    public void olahraga(int waktuOlahraga){
        setStatus("Sim sedang olahraga");
        Thread t = new Thread(()->{
        try{
                System.out.println("Sim sedang olahraga...");
                Thread.sleep(3000); //1000*durasiOlahraga
            }
            catch(InterruptedException e){
                System.out.println("Proses olahraga terganggu");
            }
        });
        t.start();
        try{
            t.join();
            getKesejahteraan().setMood(10* waktuOlahraga/20);
            getKesejahteraan().setHunger(-5*waktuOlahraga/20);
            getKesejahteraan().setHealth(5*waktuOlahraga/20);
            World.getInstance().addWaktu(waktuOlahraga*1000);
            // World.getInstance().checkSimTime(durasiOlahraga);
            tambahWaktuBelumTidur(waktuOlahraga*1000);
            tambahWaktuBelumBAB(waktuOlahraga*1000); 
            setTimerGantiKerja(waktuOlahraga*1000);
            resetTimerBelumBab();
            resetWaktuTidurAfterNoSleep();
            tambahDurasiBerkunjung(waktuOlahraga);
            System.out.println("Proses olahraga selesai");
        }catch(InterruptedException e){
            System.out.println("Proses olahraga terganggu");
        }
        try{
        this.kesejahteraan.isAlive();
        } catch (DeadException e){
            //simnya mati, ga bisa ngapa2in
           /*  for (int i = 0; i < simList.length; i++) {
                if (simList[i] != null && simList[i].getNyawa() == 0) {
                    simList[i] = null;
                    simCount--;
                } */
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

    public void kerja(){
        if(getTimerAfterGantiKerja() < 720000){
            JOptionPane.showMessageDialog(null, "Kamu baru saja ganti kerja, tunggu 1 hari lagi untuk ganti kerja lagi", "Gagal Berangkat Kerja", JOptionPane.ERROR_MESSAGE);
        }
        else{
            setisGantiKerja(false);
            setStatus("Sim sedang bekerja");

            JPanel panel = new JPanel(new BorderLayout());
            panel.setPreferredSize(new Dimension(500, 100));
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 240, 0);
            slider.setMajorTickSpacing(120);
            slider.setMinorTickSpacing(120);
            slider.setSnapToTicks(true);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            panel.add(slider, BorderLayout.CENTER);
            JOptionPane.showOptionDialog(null, panel, "Select duration", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
            int durasiKerja = slider.getValue();

            double totalKerja = 0;
             System.out.println(durasiKerja);
                if(durasiKerja == 120){ // kerja 2 menit (belom gajian)
                    System.out.println("Sim sedang bekerja...");
                    Thread t = new Thread (()->{
                    try{
                        Thread.sleep(3000); // 120 detik (1 siklus kerja)
                    } catch(InterruptedException e){
                        System.out.println("Proses bekerja terganggu");
                    }
                    });
                    t.start();
                    try{
                        t.join();
                        System.out.println("Proses bekerja selesai");
                        getKesejahteraan().setMood(-40);
                        getKesejahteraan().setHunger(-40);
                        World.getInstance().addWaktu(durasiKerja);
                        setDurasiKerja(1000);
                        // World.getInstance().checkSimTime(durasiKerja);
                        tambahWaktuBelumTidur(durasiKerja);
                        tambahWaktuBelumBAB(durasiKerja); 
                        resetTimerBelumBab();
                        resetWaktuTidurAfterNoSleep();
                        tambahDurasiBerkunjung(durasiKerja);
                        totalKerja += durasiKerja;
                        //gajian();
                    }catch(InterruptedException e){
                        System.out.println("Proses bekerja terganggu");
                    }

                    /* if (sec == 240.0){
                        setUang(pekerjaan.getGaji());
                    } */
                }
                else if (durasiKerja == 240){ // kerja 4 menit (langsung gajian)
                    System.out.println("Sim sedang bekerja");
                    Thread t = new Thread (()->{
                    try{
                        Thread.sleep(3000); // 240 detik (1 siklus kerja) cit dulu
                        //setUang(getGaji());
                        setDurasiKerja(240);
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
                        World.getInstance().addWaktu(durasiKerja);
                        setDurasiKerja(120);
                        // World.getInstance().checkSimTime(durasiKerja);
                        tambahWaktuBelumTidur(durasiKerja);
                        tambahWaktuBelumBAB(durasiKerja); 
                        resetTimerBelumBab();
                        resetWaktuTidurAfterNoSleep();
                        tambahDurasiBerkunjung(durasiKerja);
                        totalKerja += durasiKerja;
                        //gajian();
                    }catch(InterruptedException e){
                        System.out.println("Proses bekerja terganggu");
                    }
                }
                if(getdurasiKerja() >= 240){
                    setUang(pekerjaan.getGaji());
                }
        }
    }
    /* public void gajian(){
        /* elapsedTimeKerja = System.currentTimeMillis() - startKerja;
        secKerja = Math.floor(elapsedTimeKerja/1000); */
        /* if(getdurasiKerja() > 240.0){
            setUang(pekerjaan.getGaji());
        } */
    //} */
     public void GantiPekerjaan(){
        if (getdurasiKerja()<720){
            JOptionPane.showMessageDialog(null, "Kerjanya kurang lama", "Ganti Pekerjaan", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String[] fullList = {"Dokter", "Badut Sulap", "Programmer", "Polisi", "Koki"};
            String[] listKerja = new String[fullList.length-1];
            int i = 0;
            for (String s: fullList){
                if (!(s.equals(pekerjaan.getProfesi()))){
                    listKerja[i] = s;
                }
            }
            String profesiBaru = (String) JOptionPane.showInputDialog(null, "Pilih pekerjaan baru", "Ganti Pekerjaan", JOptionPane.QUESTION_MESSAGE, null, listKerja, listKerja[0]);
            setisGantiKerja(true);
            /* if(profesiBaru == "Dokter"){
                setUang(-25);
                pekerjaan.setPekerjaan("Dokter");
                setDurasiKerja(-getdurasiKerja());
                System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);

            }
            else if(profesiBaru == "Programmer"){
                setUang(-23);
                pekerjaan.setPekerjaan("Programmer");
                setDurasiKerja(-getdurasiKerja());
                System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
            }
            else if(profesiBaru == "Badut Sulap"){
                setUang(-8);
                pekerjaan.setPekerjaan("Badut Sulap");
                setDurasiKerja(-getdurasiKerja());
                System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
            }
            else if(profesiBaru == "Polisi"){
                setUang(-18);
                pekerjaan.setPekerjaan("Polisi");
                setDurasiKerja(-getdurasiKerja());
                System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
            }
        
            else if(profesiBaru == "Koki"){
                setUang(-10);
                pekerjaan.setPekerjaan("Koki");
                setDurasiKerja(-getdurasiKerja());
                System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
            }
            else{
                System.out.println("Gagal mengganti pekerjaan");
            } */
            switch(profesiBaru){
                case "Dokter":
                    setUang(-25);
                    pekerjaan.setPekerjaan("Dokter");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
                case "Koki":
                    setUang(-10);
                    pekerjaan.setPekerjaan("Koki");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
                case "Badut Sulap":
                    setUang(-8);
                    pekerjaan.setPekerjaan("Badut Sulap");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
                case "Programmer":
                    setUang(-23);
                    pekerjaan.setPekerjaan("Programmer");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
                case "Polisi":
                    setUang(-18);
                    pekerjaan.setPekerjaan("Polisi");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
            }
            timerAfterChangeOccupation = 0;
        }
        
}
    }