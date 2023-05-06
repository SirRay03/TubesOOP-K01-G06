package Items;
import src.*;
import gui.*;
import javax.swing.*;
import java.awt.*;
public class Toilet extends NonMakanan {

    public Toilet(){
        super(50, 1, 1);
    }

    public String getNama(){
        return "Toilet";
    }

    public void printListAction(){
        System.out.println("1. Mandi");
        System.out.println("2. Buang Air");
    };
    
    public void mandi(Sim sim){
        sim.setStatus("Sim sedang mandi");
        MyOverlay frame = new MyOverlay("Your sim will now take a shower, in the toilet (somehow)", "I'll censor this so you can't see anything.", sim.getStatus());
        frame.interactionBar.setBackground(Color.BLACK);
        frame.middlePanel.setBackground(Color.BLACK);
        JOptionPane.showMessageDialog(null, "Please go away!! -" + sim.getFullName(), "In the toilet", JOptionPane.INFORMATION_MESSAGE);
        Thread t = new Thread(()->{
        try{
                Thread.sleep(10000); 
                
            }
            catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, "Shower interrupted because someone forgot to pay the bills", "Mandi", JOptionPane.ERROR_MESSAGE);
            }
        });
        t.start();
        try{
            t.join();
            JOptionPane.showMessageDialog(null, "Your sim is now done showering", "Mandi", JOptionPane.INFORMATION_MESSAGE);
            sim.getKesejahteraan().setMood(10);
            sim.getKesejahteraan().setHunger(-5);
            World.getInstance().addWaktu(10000);
            sim.tambahDurasiBerkunjung(10000);
            sim.setTimerGantiKerja(10000);
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "Shower interrupted because someone forgot to pay the bills", "Mandi", JOptionPane.ERROR_MESSAGE);
        }
        sim.setStatus("Idle");
        frame.close();
    }

    public void doAction(Object... args){
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang buang air");
        MyOverlay frame = new MyOverlay("What are you doing looking at someone in the toilet???", "Go away, you weirdo! I'll censor this so you can't see anything!", sim.getStatus());
        frame.interactionBar.setBackground(Color.BLACK);
        frame.middlePanel.setBackground(Color.BLACK);
        JOptionPane.showMessageDialog(null, "Please go away!! -" + sim.getFullName(), "In the toilet", JOptionPane.INFORMATION_MESSAGE);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000); // waktu buang air 10 detik
                    sim.getKesejahteraan().setHunger(-20);
                    sim.getKesejahteraan().setMood(10);
                    sim.setTimerGantiKerja(10000);
                    World.getInstance().addWaktu(10000);
                    sim.setStatusBab(false);
                    sim.resetTimerBabAfterBab();
                    sim.tambahDurasiBerkunjung(10000);
                    //World.checkAllSimTimer(10, scan);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        thread.start();
        try{
            thread.join();
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "Great, now I've lost the mood to do it and it's all because of you!", "In the toilet", JOptionPane.INFORMATION_MESSAGE);
        }
        sim.setStatus("Idle");
        frame.close();
    }
}
