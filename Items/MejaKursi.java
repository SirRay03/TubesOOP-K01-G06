package Items;

import gui.*;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import src.*;

public class MejaKursi extends NonMakanan {

    private int durasiMakan;

    public MejaKursi(){
        super(50, 3, 3); //harga, panjang, lebar sudah ditetapkan
    }
    public String getNama(){
        return "Meja Kursi";
    }
    public int getdurasiMakan(){
        return durasiMakan;
    }

    public void printListAction(){
        System.out.println("1. Live Streaming");
        System.out.println("2. Makan");
        System.out.println("3. Minum");
        System.out.println("4. Berdoa");
    };

    public void doAction(Object... args){
        List<String> currMasakanInv = new ArrayList<>();
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang makan");
        MyOverlay frame = new MyOverlay(sim.getFirstName() + " is now eating!", "Devouring digital food data...", sim.getStatus());
        if (sim.getInventory().getMap().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You don't have any food in your inventory!", "Makan", JOptionPane.INFORMATION_MESSAGE);
            frame.close();
            return;
        }
        for (Item item: sim.getInventory().getMap().keySet()){
            if(item instanceof Makanan){
                currMasakanInv.add(((Makanan) item).getNama());
            }
        }
        String[] arrCurrString = currMasakanInv.toArray(new String[0]);
        String namaMasakan = (String) JOptionPane.showInputDialog(null, "Apa yang ingin dimakan", "Makan", JOptionPane.QUESTION_MESSAGE, null, arrCurrString, arrCurrString[0]);
        if (namaMasakan == null) {
            JOptionPane.showMessageDialog(null, "You have cancelled this action.", "Makan", JOptionPane.INFORMATION_MESSAGE);
            frame.close();
        } else {
            int durasiMakan = 30;
            JOptionPane.showMessageDialog(null, "Your sim is now eating for " + durasiMakan + " seconds!. Don't panic if the screen is frozen. Just press Ok and we'll notify you when it's done!", "Makan", JOptionPane.INFORMATION_MESSAGE);
            Thread t = new Thread(()->{
            try{
                    System.out.println("Sim sedang makan...");
                    Thread.sleep(durasiMakan*1000); //durasiMakan*1000
                }
                catch(InterruptedException e){
                    System.out.println("Proses makan terganggu");
                    frame.close();
                }
            });
            t.start();
            try{
                t.join();
                try{
                    sim.getKesejahteraan().setHunger(((Makanan) sim.getInventory().getItem(namaMasakan, 1)).getKekenyangan());
                    World.getInstance().addWaktu(durasiMakan*1000);
                    sim.tambahWaktuBelumTidur(durasiMakan*1000);
                    sim.tambahWaktuBelumBAB(durasiMakan*1000);
                    sim.setTimerGantiKerja(durasiMakan*1000);
                    sim.setStatusBab(true);
                    sim.resetTimerBelumBab();
                    sim.resetWaktuTidurAfterNoSleep();
                    sim.tambahDurasiBerkunjung(durasiMakan);
                    JOptionPane.showMessageDialog(null, "Your sim has finished eating!", "Makan", JOptionPane.INFORMATION_MESSAGE);
                    frame.close();
                    sim.getKesejahteraan().isAlive();
                }
                catch( DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(sim);
            }
            }catch(InterruptedException e){
                System.out.println("Proses makan terganggu");
                sim.setStatus("Idle");
                frame.close();
            }
            }
        
        }

    public void liveStreaming(int waktu, Sim sim){//nerima waktu mau berapa lama
        sim.setStatus("Sim sedang live streaming");
        System.out.println("Sim sedang live streaming");
        MyOverlay frame = new MyOverlay(sim.getFirstName() + " is now playing!", "Playing with digital toys...", sim.getStatus());
        JOptionPane.showMessageDialog(null, "Sim is Playing", "In the MejaKursi", JOptionPane.INFORMATION_MESSAGE);
        Thread t = new Thread(()->{
        try{
                Thread.sleep(waktu*1000); //1 detik main waktu*1000
            }
            catch(InterruptedException e){
                System.out.println("Proses live streaming terganggu");
                sim.setStatus("Idle");
                frame.close();
            }
        });
        t.start();
        try{
            t.join();
            try{
                sim.getKesejahteraan().setMood(waktu);
                sim.getKesejahteraan().setHunger(-waktu);
                sim.setUang(waktu*2); 
                System.out.println("Proses live streaming selesai");
                sim.setStatus("Idle");
                frame.close();
                World.getInstance().addWaktu(waktu*1000);
                // World.getInstance().checkSimTime(waktu);
                sim.tambahWaktuBelumTidur(waktu*1000);
                sim.tambahWaktuBelumBAB(waktu*1000); 
                sim.setTimerGantiKerja(waktu*1000);
                sim.resetTimerBelumBab();
                sim.resetWaktuTidurAfterNoSleep();
                sim.tambahDurasiBerkunjung(waktu*1000);
                sim.getKesejahteraan().isAlive();
            }catch( DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(sim);
            }
        }catch(InterruptedException e){
            System.out.println("Proses Live Streaming terganggu");
            sim.setStatus("Idle");
            frame.close();
        }
    }
        
    public void berdoa(Sim sim){
        sim.setStatus("Sim sedang berdoa");
        MyOverlay frame = new MyOverlay(sim.getFirstName() + " is now praying!", "Praying to digital gods...", sim.getStatus());
        System.out.println("Sim sedang berdoa...");
        JOptionPane.showMessageDialog(null, "Sim is now praying", "In MejaKursi", JOptionPane.INFORMATION_MESSAGE);
        Thread t = new Thread(()->{
        try{
                Thread.sleep(10000); //1 detik berdoa
            }
            catch(InterruptedException e){
                System.out.println("Proses berdoa terganggu");
                sim.setStatus("Idle");
                frame.close();
            }
        });
        t.start();
        try{
            t.join();
            try{
                sim.getKesejahteraan().setMood(10*3); //namabah mood 10*3
                sim.getKesejahteraan().setHunger(10); //ngurang kenyang sebanyak waktu
                sim.tambahWaktuBelumTidur(10000);
                sim.tambahWaktuBelumBAB(10000); 
                sim.setTimerGantiKerja(10000);
                sim.resetTimerBelumBab();
                sim.resetWaktuTidurAfterNoSleep();
                sim.tambahDurasiBerkunjung(10000);
                System.out.println("Proses berdoa selesai");
                sim.setStatus("Idle");
                frame.close();
                sim.getKesejahteraan().isAlive();
            }
            catch( DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(sim);
            }
        }catch(InterruptedException e){
            System.out.println("Proses berdoa terganggu");
            sim.setStatus("Idle");
            frame.close();
        }
    }
    public void minum(Sim sim){
        sim.setStatus("Sim sedang minum");
        MyOverlay frame = new MyOverlay(sim.getFirstName() + " is now drinking!", "Drinking digital water...", sim.getStatus());
        System.out.println("Sim sedang minum...");
        JOptionPane.showMessageDialog(null, "Sim is now drinking", "In MejaKursi", JOptionPane.INFORMATION_MESSAGE);
        Thread t = new Thread(()->{
        try{
                Thread.sleep(1000); //1 detik minum
            }
            catch(InterruptedException e){
                System.out.println("Proses minum terganggu");
                sim.setStatus("Idle");
            }
        });
        t.start();
        try{
            t.join();
            try{
                sim.getKesejahteraan().setMood(1); //namabah mood 1
                sim.getKesejahteraan().setHunger(-1); //ngurang kenyang 2
                sim.tambahWaktuBelumTidur(1000);
                sim.tambahWaktuBelumBAB(1000); 
                sim.setTimerGantiKerja(1000);
                sim.resetTimerBelumBab();
                sim.resetWaktuTidurAfterNoSleep();
                sim.tambahDurasiBerkunjung(1000);
                System.out.println("Proses minum selesai");
                sim.setStatus("Idle");
                frame.close();
                sim.getKesejahteraan().isAlive();
            }
            catch( DeadException dead){
                JOptionPane.showMessageDialog(null, dead.getMessage(), "Sim telah mati", JOptionPane.ERROR_MESSAGE);
                new MainMenu();
                World.getInstance().removeSim(sim);
            }
        }catch(InterruptedException e){
            System.out.println("Proses minum terganggu");
            sim.setStatus("Idle");
        }
    }
}
