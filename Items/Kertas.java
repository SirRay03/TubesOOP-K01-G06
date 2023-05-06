package Items;

import gui.OverlayKertas;
import src.Sim;

public class Kertas extends NonMakanan {
    public Kertas(){
        super(1, 1, 1);
    }
    public String getNama(){
        return "Kertas";
    }
    public void printListAction(){
        System.out.println("1. Menulis");
    };
    public void doAction(Object... args){//menulis memang bukan aksi aktif jd ga makan wKtu
        //implementation code goes hereSystem.out.println("Masukkan kata atau kalimat yang ingin ditulis:");
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang menulis");
        new OverlayKertas(sim, sim.getStatus());
        sim.getKesejahteraan().setMood(1); //namabah mood 1
        sim.getKesejahteraan().setHunger(-1); //ngurang kenyang 1
    }
}
