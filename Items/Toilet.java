package Items;
import src.Sim;
public class Toilet extends NonMakanan {
    public Toilet(){
        super(50, 1, 1);
    }
    public void mandi(Sim sim){
        sim.setStatus("Sim sedang mandi");
        System.out.println("Sim sedang mandi...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(10000); 
                System.out.println("Proses mandi selesai");
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
        System.out.println("Sim sedang buang air...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(10000); 
                System.out.println("Proses buang air selesai");
            }
            catch(InterruptedException e){
                System.out.println("Proses buang air terganggu");
            }
        });
        t.start();
        try{
            t.join();
            sim.getKesejahteraan().setMood(10);
            sim.getKesejahteraan().setHunger(-20); 
        }catch(InterruptedException e){
            System.out.println("Proses buang air terganggu");
        }
    }
    }
