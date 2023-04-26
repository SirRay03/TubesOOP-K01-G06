import java.util.*;
import java.util.random.*;

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

    public Inventory getInventory() {
        return inventory;
    }

    public void viewCurrentLocation () {
        System.out.println("lalala"); // msh bingung cara nampilin satu2
    }

    public void merenung(Sim sim){
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
    }

    public void ViewSimInfo() {
        System.out.println("Nama sim : " + getFullName());
        System.out.println("Pekerjaan sim : " + getPekerjaan());
        System.out.println("Kesejahteraan sim : " + getKesejahteraan());
        System.out.println("Jumlah uang sim : " + getMoney());
    }
}