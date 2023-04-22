import java.util.*;

public class Sim {
    // deklarasi atribut
    private String firstName;
    private String lastName;
    private String pekerjaan;
    private int uang;
    private Kesejahteraan kesejahteraan;
    private String status; 
    private Point point;
    private Inventory inventory; 

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
        this.inventory = new Inventory();
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

    public Point getLocation() {
        return this.point;
    }
}
