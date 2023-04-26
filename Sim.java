import java.util.*;

public class Sim {
    // deklarasi atribut
    private String firstName;
    private String lastName;
    private String pekerjaan;
    private int uang;
    Kesejahteraan kesejahteraan;
    private String status; 
    private Point point;
    private Inventory<Item> inventory; 
    private Rumah currentRumah;
    private Ruangan currentRuangan;

    /**
     * Konstruktor
     * @param namalengkap
     */
    public Sim (String namaLengkap) {
        String[] name = namaLengkap.split(" ");
        this.firstName = name[0];
        this.lastName = name[1];
        this.pekerjaan = getRandomPekerjaan();
        this.uang = 100;
        this.kesejahteraan = new Kesejahteraan();
        this.point = new Point(0,0);
        this.inventory = new Inventory<Item> ();
        this.status = "-";
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
    public int getMoney() {
        return this.uang;
    }

    public void setMoney(int uang) {
        this.uang = uang;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String getRandomPekerjaan() {
        String[] pekerjaan = {"Programmer", "Dokter", "Penulis", "Guru", "Insinyur", "Akuntan"};
        int randomIndex = new Random().nextInt(pekerjaan.length);
        return pekerjaan[randomIndex];
    }
    
    public String getPekerjaan() {
        return this.pekerjaan;
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

    public void viewCurrentLocation () {
        System.out.println("lalala"); // msh bingung cara nampilin satu2
    }

    public void ngobrol(Sim sim){
        this.kesejahteraan.setHunger(-10);
        this.kesejahteraan.setHealth(15);
        this.kesejahteraan.setMood(15);
        this.kesejahteraan.setHunger(-10);
        this.kesejahteraan.setHealth(15);
        this.kesejahteraan.setMood(15);
        this.setRumah(this.getcurrentRumah());
        this.pindahRuangan(this.getcurrentRuangan());
        this.setPoint(sim.getPoint());
        //set waktunya belum 
    }

    public void ViewSimInfo() {
        System.out.println("Nama sim : " + getFullName());
        System.out.println("Pekerjaan sim : " + getPekerjaan());
        System.out.println("Kesejahteraan sim : " + getKesejahteraan());
        System.out.println("Jumlah uang sim : " + getMoney());
    }
}