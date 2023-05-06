package Items;
import src.Sim;
import src.*;
import gui.*;
import gui.MyOverlay;
import java.awt.Color;

import javax.swing.JOptionPane;
public class Kaca extends NonMakanan {
    private static int ngacaCount = 0;

    public Kaca(){
        super(10, 2, 1);
    }
    public String getNama(){
        return "Kaca";
    }
    public void printListAction(){
        System.out.println("1. Berkaca");
    }

    public void doAction(Object... args){
        String message;
        Sim sim = (Sim) args[0];
        ngacaCount++;
        if (ngacaCount < 4){
            message = "(You)r sim is looking at themselves in the mirror";
        }
        else {
            message = "Really?? this is the " + ngacaCount + "th time you've done this.";
        }
        sim.setStatus("Sim sedang berkaca");
        MyOverlay frame = new MyOverlay(message, "I don't know what that tells me about you, but I think you're somewhat of a narcissist.", sim.getStatus());
        frame.interactionBar.setBackground(Color.BLACK);
        frame.middlePanel.setBackground(Color.BLACK);
        JOptionPane.showMessageDialog(null, "Your sim (and you) is now looking at themselves in the mirror", "Berkaca", JOptionPane.INFORMATION_MESSAGE);
        Thread t = new Thread(()->{
        try{
                Thread.sleep(5000); //5 detik berkaca
            }
            catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, "You have cancelled this action.", "Berkaca", JOptionPane.ERROR_MESSAGE);
            }
        });
        t.start();
        try{
            t.join();
            try{ 
                sim.getKesejahteraan().setMood(5); //namabah mood 5
                sim.getKesejahteraan().setHunger(-3); //ngurang kenyang 3
                JOptionPane.showMessageDialog(null, "Your sim is now done looking at themselves in the mirror. Maybe you should not just reflect on you looks but also on your attitude", "Berkaca", JOptionPane.INFORMATION_MESSAGE);
                sim.tambahWaktuBelumTidur(5000);
                sim.tambahWaktuBelumBAB(5000);
                sim.setTimerGantiKerja(5000);
                sim.resetTimerBelumBab();
                sim.resetWaktuTidurAfterNoSleep();
                sim.tambahDurasiBerkunjung(5000);
                sim.getKesejahteraan().isAlive();
                frame.close();
            }
            catch( DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(sim);
            }
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "You have cancelled this action.", "Berkaca", JOptionPane.ERROR_MESSAGE);
            sim.setStatus("Idle");
            frame.close();
        }
    }
}