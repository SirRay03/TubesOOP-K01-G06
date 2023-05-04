package Items;
import src.Sim;
public class Kaca extends NonMakanan {
    public Kaca(){
        super(10, 2, 1);
    }
    public String getNama(){
        return "Kaca";
    }
    public void printListAction(){
        System.out.println("1. Berkaca");
    };
    public void doAction(Object... args){//doaction kaca cuma butuh 1 aja, yaitu sim
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang berkaca");
        System.out.println("Sim sedang berkaca...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(5000); //1 detik berkaca
            }
            catch(InterruptedException e){
                System.out.println("Proses berkaca terganggu");
            }
        });
        t.start();
        try{
            t.join(); 
            sim.getKesejahteraan().setMood(5); //namabah mood 5
            sim.getKesejahteraan().setHunger(-3); //ngurang kenyang 3
            System.out.println("Proses berkaca selesai");
            sim.tambahWaktuBelumTidur(1);
            sim.tambahWaktuBelumBAB(1);
        }catch(InterruptedException e){
            System.out.println("Proses berkaca terganggu");
        }
    }
}

/**
 * RUN DI MAIN NYA GINI
 *      Kaca k1 = new Kaca();
 *      k1.berkaca();

 */