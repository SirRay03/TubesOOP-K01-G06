import java.util.*;

public class Kertas extends NonMakanan {
    public Kertas(){
        super(1, 1, 1);
    }
    public void doAction(Object... args){//menulis memang bukan aksi aktif jd ga makan wKtu
        //implementation code goes hereSystem.out.println("Masukkan kata atau kalimat yang ingin ditulis:");
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang menulis");
        System.out.println("Masukkan kalimat yang ingin ditulis...");
        Scanner scan = new Scanner(System.in);
        // String input
        String tulisan = scan.nextLine();
        // Output input by user
        System.out.println(tulisan);
        sim.getKesejahteraan().setMood(1); //namabah mood 1
        sim.getKesejahteraan().setHunger(-1); //ngurang kenyang 1
        scan.close();
    }
}
