package Items;
import src.*;
public class Toilet extends NonMakanan {
    public Toilet(){
        super(50, 1, 1);
    }
    public void printListAction(){
        System.out.println("1. Mandi");
        System.out.println("2. Buang Air");
    };
    
    public void mandi(Sim sim){
        sim.setStatus("Sim sedang mandi");
        System.out.println("Sim sedang mandi...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(10000); 
                
            }
            catch(InterruptedException e){
                System.out.println("Proses mandi terganggu");
            }
        });
        t.start();
        try{
            t.join();
            sim.getKesejahteraan().setMood(10);
            sim.getKesejahteraan().setHunger(-5); 
            System.out.println("Proses mandi selesai");
        }catch(InterruptedException e){
            System.out.println("Proses mandi terganggu");
        }
    }

    public void doAction(Object... args){
        //implementation code goes here
        //Object... args artinya dia bisa nerima banyak argumen
        //akses argumen nya satu2, baru cast jadi yg sesuai
        //misal: doAction(Sim sima, String contoh)
        //brarti cara akses parameter pertama nya : Sim sima = (Sim) args[0]
        //brarti cara akses parameter kedua nya : String contoh = (String) args[1]
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang buang air");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000); // waktu buang air 10 detik
                    System.out.println("Proses buang air selesai");
                    sim.getKesejahteraan().setHunger(-20);
                    sim.getKesejahteraan().setMood(10);
                    World.getInstance().addWaktu(10);
                    sim.setStatusBab(false);
                    sim.resetTimerBabAfterBab();
                    //World.checkAllSimTimer(10, scan);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        System.out.println("Sim sedang buang air...");
        thread.start();
    }
    }
