package essentials;
import java.util.*;

import Items.Item;

public class Sim {
    // deklarasi atribut
    private String firstName;
    private String lastName;
    private String pekerjaan;
    private int uang;
    private Kesejahteraan kesejahteraan;
    private String status; 
    private Point point;
    private Inventory<Item> inventory; 
    private Rumah currentRumah;
    private Ruangan currentRuangan;
    private List<Item> listOnDelivery;
    public int timerNoSleep;

    /**
     * Konstruktor
     * @param namalengkap
     */
    public Sim (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pekerjaan = getRandomPekerjaan();
        this.uang = 100000;
        this.kesejahteraan = new Kesejahteraan();
        this.point = new Point(0,0);
        this.inventory = new Inventory<Item>();
        this.status = "idle";
        this.listOnDelivery = new ArrayList<>();
        this.timerNoSleep = 0;
        Thread t = new Thread(()->{
        try{
                Thread.sleep(600000); 
                getKesejahteraan().setMood(-5);
                getKesejahteraan().setHealth(-5);
            }
            catch(InterruptedException e){
                System.out.println("Proses berkaca terganggu");
            }
        });
        t.start();
    }
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

    public void setUang(int uang) {
        this.uang = uang;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public List<Item> getListOnDelivery(){
        return listOnDelivery;
    }
    public void addToListOnDelivery(Item item){
        listOnDelivery.add(item);
    }
    public void deleteFromListOnDelivery(Item item){
        listOnDelivery.remove(item);
    }
    private String getRandomPekerjaan() {
        String[] pekerjaan = {"Programmer", "Dokter", "Penulis", "Guru", "Insinyur", "Akuntan"};
        int randomIndex = new Random().nextInt(pekerjaan.length);
        return pekerjaan[randomIndex];
    }
    
    public String getPekerjaan() {
        return this.pekerjaan;
    }

    public void setPekerjaan(String pekerjaan){
        this.pekerjaan = pekerjaan;
    }

    public Kesejahteraan getKesejahteraan() {
        return this.kesejahteraan;
    }

    public Point getPoint() {
        return this.point;
    }

    public void setPoint(Point point) {
       this.point = point;
    }

    public Rumah getcurrentRumah () {
        return currentRumah;
    }

    public void setRumah (Rumah rumah) {
        this.currentRumah = rumah;
    }

    public Ruangan getcurrentRuangan() {
        return currentRuangan;
    }

    public void pindahRuangan (Ruangan ruangan)
    {
        this.currentRuangan = ruangan;
    }

    public Inventory<Item> getInventory() {
        return inventory;
    }

    public int getTimerNoSleep () {
        return timerNoSleep;
    }

    public void addTimerBelumTidur(int duration)
    {
        this.timerNoSleep += duration; // duration diambil dari durasi di method tidur
    }

    public void resetTimerBelumTidurAfterSleep()
    {
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

    public void viewCurrentLocation () {
        System.out.println("lalala"); // msh bingung cara nampilin satu2
    }
    public void ngobrol(Sim sim){
        this.kesejahteraan.setHunger(-10);
        this.kesejahteraan.setHealth(15);
        this.kesejahteraan.setMood(15);
        sim.kesejahteraan.setHunger(-10);
        sim.kesejahteraan.setHealth(15);
        sim.kesejahteraan.setMood(15);
        this.setRumah(sim.getcurrentRumah());
        this.pindahRuangan(sim.getcurrentRuangan());
        this.setPoint(sim.getPoint());
        //set waktunya belum 
    }

    public int getPosisiX() {
        return this.point.getX();
    }

    public int getPosisiY() {
        return this.point.getY();
    }

    public void setPosisiX(int x) {
        this.point.setX(x);
    }

    public void setPosisiY(int y) {
        this.point.setY(y);
    }
}
