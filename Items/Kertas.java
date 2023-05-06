package Items;

import javax.swing.JOptionPane;

import gui.*;
import src.*;

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
    public void doAction(Object... args){
        //implementation code goes hereSystem.out.println("Masukkan kata atau kalimat yang ingin ditulis:");
        Sim sim = (Sim) args[0];
        try{
            sim.setStatus("Sim sedang menulis");
            new OverlayKertas(sim, sim.getStatus());
            sim.getKesejahteraan().setMood(1); //namabah mood 1
            sim.getKesejahteraan().setHunger(-1); //ngurang kenyang 1
            sim.getKesejahteraan().isAlive();
        }catch( DeadException dead){
            JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
            new MainMenu();
            World.getInstance().removeSim(sim);
        }
    }
}
