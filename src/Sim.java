package src;
import java.util.*;
import javax.swing.*;
import Items.*;
import gui.*;

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
    private Inventory<Item> inventory;
    private Rumah ownRumah;
    private Rumah currRumah;
    private Ruangan currRuangan;
    private List<Item> listOnDelivery;
    private List<Rumah> listUpgrade;
    public int timerNoSleep;
    public long elapsedTimeKerja;
    private int timerNoBab;
    private boolean isBab;
    private boolean isGantiKerja;
    private int durasiKerja;
    private int durasiKerjaKhusus;
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
        this.pekerjaan = new Pekerjaan();
        this.uang = 100;
        this.kesejahteraan = new Kesejahteraan();
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
        timerAfterChangeOccupation=999999;
        durasiKerja = 0;
        durasiKerjaKhusus = 0;
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

    public Pekerjaan getPekerjaan() {
        return this.pekerjaan;
    }

    public int getUang() {
        return this.uang;
    }

    public Kesejahteraan getKesejahteraan() {
        return this.kesejahteraan;
    }

    public String getStatus() {
        return this.status;
    }

    public Inventory<Item> getInventory() {
        return inventory;
    }

    public Rumah getRumah(){
        return this.ownRumah;
    }

    public List<Item> getListOnDelivery(){
            return listOnDelivery;
    }

    public List<Rumah> getListUpgrade(){
            return listUpgrade;
    }

    public long getTimerNoSleep () {
        return timerNoSleep;
    }

    public int getTimerAfterGantiKerja(){
        return this.timerAfterChangeOccupation;
    }

    public Ruangan getRuangan(){
        return this.currRuangan;
    }

    public int getdurasiKerja(){
        return durasiKerja;
    }

    public int getdurasiKerjaKhusus(){
        return durasiKerjaKhusus;
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

    public void setDurasiKerjaKhusus(int durasi){
        this.durasiKerjaKhusus += durasi;
    }

    public void setTimerGantiKerja(int duration){
        if(isGantiKerja){
            this.timerAfterChangeOccupation += duration;
        }
    }

    public void setStatusBab(boolean isBab){
        this.isBab = isBab;
    }
    public void setisGantiKerja(boolean status){
            this.isGantiKerja = status;
    }

    public void resetTimerGantiKerja(){
        this.timerAfterChangeOccupation = 0;
    }

    // === METHOD ===

    

    public void tambahWaktuBelumTidur(int duration){
        this.timerNoSleep += duration; 
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
            JOptionPane.showMessageDialog(null, "Waktu Tidur Anda kurang! Sim terluka! Segeralah tidur", "Sim terluka", JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Anda belum BAB, Sim terluka! Segeralah buang air!", "Sim terluka", JOptionPane.WARNING_MESSAGE);
            System.out.println("Anda belum BAB, Sim terluka! Segeralah buang air!");
            int kelipatan = timerNoBab / 240000; 
            System.out.println(5*kelipatan);
            System.out.println(timerNoBab);
            try{
                kesejahteraan.setHealth(-5*kelipatan);
                kesejahteraan.setMood(-5*kelipatan);
                kesejahteraan.isAlive();
            } catch (DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                World.getInstance().removeSim(this);
                new MainMenu();
            }
            timerNoBab =0;
        }
    }
    public String merenung(){
        System.out.println("Tanyakan sesuatu untuk direnungkan! Kamu akan mendapatkan jawaban acak.");
        Random random = new Random();
        int pilihanJawaban = (random.nextInt(10));
        try{
                kesejahteraan.setMood(3);
                kesejahteraan.setHunger(-2);
                kesejahteraan.isAlive();
                World.getInstance().addWaktu(1000);
            } catch( DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(this);
            }
        tambahWaktuBelumTidur(1000);
        tambahWaktuBelumBAB(1000); 
        resetTimerBelumBab();
        resetWaktuTidurAfterNoSleep();
        switch(pilihanJawaban){
            case 0:
                return "Semua akan baik-baik saja!";
            case 1:
                return "Lakukan lebih baik!";
            case 2:
                return "Semangat!";
            case 3:
                return "Tidak perlu overthinking";
            case 4:
                return "Just do it!";
            case 5:
                return "Ayo, kamu pasti bisa!";
            case 6:
                return "Yakin? Coba pikir lagi";
            case 7:
                return  "Hal itu terlalu rumit untuk direnungkan";
            case 8:
                return "Hal yang sangat baik untuk direnungkan";
            case 9:
                return "Itu ide yang sangat baik!";
            default:
                return "Merenunglah kembali!";
            }
        }
    
    public void tambahWaktuBelumBAB (int duration) {
        if (isBab) {
            timerNoBab += duration;
        }
    }

    public void resetTimerBabAfterBab() {
        timerNoBab = 0;
    }

    public void berkunjung (Rumah dikunjung) {
        setStatus("Sim sedang berkunjung");
        currRuangan = dikunjung.getDenahRumah()[11][11];
        int x1 = currRumah.getHAddress();
        int y1 = currRumah.getVAddress();
        int x2 = dikunjung.getHAddress();
        int y2 = dikunjung.getVAddress();
        int waktuberkunjung = World.getInstance().getDistance(x1, y1, x2, y2);
        int confirm = (int) JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin berkunjung ke rumah ini? Proses ini akan memakan waktu " + waktuberkunjung + " detik.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Proses berkunjung dimulai. Peta rumah yang dikunjungi akan langsung ditampilkan ketika sim sudah sampai!");
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

    /* public void pulang () {
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
 */
    public void tambahDurasiBerkunjung (int duration) {
        try{
            if (currRumah != ownRumah) {
                durasiBerkunjung += duration ;
                if (durasiBerkunjung >= 30000) {
                    getKesejahteraan().setMood(10);
                    getKesejahteraan().setHunger(-10);
                    durasiBerkunjung -= 30000;
                }
            }
            kesejahteraan.isAlive();
        } catch( DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(this);
            }
    }

    public void olahraga(){
        setStatus("Sim sedang olahraga");
        MyOverlay overlay = new MyOverlay("Your sim is now exercising!", "You should go exercise too", status);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(500, 100));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 300, 0);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider, BorderLayout.CENTER);

        int option = JOptionPane.showOptionDialog(null, panel, "Select duration (in seconds)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
            try{
            int waktuOlahraga = slider.getValue();
            Thread t = new Thread(()->{
                try{
                        System.out.println("Sim sedang olahraga...");
                        Thread.sleep(waktuOlahraga*1000);
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
                getKesejahteraan().setMood(10* waktuOlahraga/20);
                getKesejahteraan().setHunger(-5*waktuOlahraga/20);
                getKesejahteraan().setHealth(5*waktuOlahraga/20);
                World.getInstance().addWaktu(waktuOlahraga*1000);
                tambahWaktuBelumTidur(waktuOlahraga*1000);
                tambahWaktuBelumBAB(waktuOlahraga*1000); 
                setTimerGantiKerja(waktuOlahraga*1000);
                resetTimerBelumBab();
                resetWaktuTidurAfterNoSleep();
                tambahDurasiBerkunjung(waktuOlahraga);
                System.out.println("Proses olahraga selesai");
                setStatus("Idle");
                kesejahteraan.isAlive();
            } catch (DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(this);
            }
        }
        else{
            overlay.dispose();
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
            int userinput =  JOptionPane.showOptionDialog(null, panel, "Select duration (in seconds)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
            int durasiKerja = slider.getValue();
            
            durasiKerjaKhusus += slider.getValue();

                if(durasiKerja == 120 && userinput == JOptionPane.OK_OPTION){ 
                    JOptionPane.showMessageDialog(null, "Sim is now working", "Working", JOptionPane.INFORMATION_MESSAGE);
                    Thread t = new Thread (()->{
                    try{
                        Thread.sleep(120000); 
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
                        World.getInstance().addWaktu(durasiKerja*1000);
                        setDurasiKerja(120); 
                        setDurasiKerjaKhusus(120);
                        tambahWaktuBelumTidur(durasiKerja);
                        tambahWaktuBelumBAB(durasiKerja); 
                        resetTimerBelumBab();
                        resetWaktuTidurAfterNoSleep();
                        tambahDurasiBerkunjung(durasiKerja);
                        System.out.println(getdurasiKerja());
                    }catch(InterruptedException e){
                        System.out.println("Proses bekerja terganggu");
                    }
                }
                else if (durasiKerja == 240 && userinput == JOptionPane.OK_OPTION){ 
                    JOptionPane.showMessageDialog(null, "Sim is now working", "Working", JOptionPane.INFORMATION_MESSAGE);
                    Thread t = new Thread (()->{
                    try{
                        Thread.sleep(240000); 
                        setDurasiKerja(240);
                        setDurasiKerjaKhusus(240);
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
                        World.getInstance().addWaktu(durasiKerja*1000);
                        tambahWaktuBelumTidur(durasiKerja);
                        tambahWaktuBelumBAB(durasiKerja); 
                        resetTimerBelumBab();
                        resetWaktuTidurAfterNoSleep();
                        //gajian();
                    }catch(InterruptedException e){
                        System.out.println("Proses bekerja terganggu");
                    }
                    tambahDurasiBerkunjung(durasiKerja);
                }else{
                    JOptionPane.showMessageDialog(null, "Action Cancelled", "Work", JOptionPane.INFORMATION_MESSAGE);
                }
                if(getdurasiKerja() >= 240){
                    setUang(pekerjaan.getGaji());
                    setDurasiKerja(-getdurasiKerja());
                }
        }
    }

    public void GantiPekerjaan(){
        System.out.println(getTimerAfterGantiKerja());
        if (durasiKerjaKhusus<720){
            JOptionPane.showMessageDialog(null, "Kerjanya kurang lama", "Ganti Pekerjaan", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String[] fullList = {"Dokter", "Badut Sulap", "Programmer", "Polisi", "Koki"};
            String[] listKerja = new String[fullList.length-1];
            int i = 0;
            for (String s: fullList){
                if (!(s.equals(pekerjaan.getProfesi()))){
                    listKerja[i] = s;
                    i++;
                }
            }
            String profesiBaru = (String) JOptionPane.showInputDialog(null, "Pilih pekerjaan baru", "Ganti Pekerjaan", JOptionPane.QUESTION_MESSAGE, null, listKerja, listKerja[0]);
            setisGantiKerja(true);
            
            switch(profesiBaru){
                case "Dokter":
                    setUang(-25);
                    resetTimerGantiKerja();
                    pekerjaan.setPekerjaan("Dokter");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
                case "Koki":
                    setUang(-10);
                    resetTimerGantiKerja();
                    pekerjaan.setPekerjaan("Koki");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
                case "Badut Sulap":
                    setUang(-8);
                    resetTimerGantiKerja();
                    pekerjaan.setPekerjaan("Badut Sulap");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
                case "Programmer":
                    setUang(-23);
                    resetTimerGantiKerja();
                    pekerjaan.setPekerjaan("Programmer");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
                case "Polisi":
                    setUang(-18);
                    resetTimerGantiKerja();
                    pekerjaan.setPekerjaan("Polisi");
                    setDurasiKerja(-getdurasiKerja());
                    System.out.println("Pekerjaan berhasil diganti menjadi"+ this.pekerjaan);
                    break;
            }
           setDurasiKerjaKhusus(-getdurasiKerjaKhusus());
           resetTimerGantiKerja();
        }
        
    }
}