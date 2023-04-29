package Items;

import javax.swing.JOptionPane;
import Items.*;
import src.Sim;
import java.util.List;
import java.util.ArrayList;

public class MejaKursi extends NonMakanan {
    public MejaKursi(){
        super(50, 3, 3); //harga, panjang, lebar sudah ditetapkan
    }

    public void printListAction(){
        System.out.println("1. Main");
        System.out.println("2. Makan");
        System.out.println("3. Minum");
        System.out.println("4. Berdoa");
    };

    public void doAction(Object... args){
        List<String> currMasakanInv = new ArrayList<>();
        Sim sim = (Sim) args[0];
        for (Item item: sim.getInventory().getMap().keySet()){
            if(item instanceof Makanan){
                currMasakanInv.add(((Makanan) item).getNama());
            }
        }
        String[] arrCurrString= currMasakanInv.toArray(new String[0]);
        String namaMasakan = (String) JOptionPane.showInputDialog(null, "Masakan apa yang ingin dimakan?", "Makan", JOptionPane.QUESTION_MESSAGE, null, arrCurrString, arrCurrString[0]);
        sim.getInventory().removeItem(namaMasakan, 1);
        
        Thread t = new Thread(()->{
            try{
                    sim.setStatus("Sim sedang makan");
                    System.out.println("Sim sedang makan...");
                    Thread.sleep(10000); //1 detik main
                }
                catch(InterruptedException e){
                    System.out.println("Proses makan terganggu");
                }
            });
            t.start();
            try{
                t.join();
                sim.getKesejahteraan().setMood(1*2); //namabah mood waktu*2
                sim.getKesejahteraan().setHunger(1); //ngurang kenyang waktu
                System.out.println("Proses makan selesai");
            }catch(InterruptedException e){
                System.out.println("Proses makan terganggu");
            }
        }

    public void main(int waktu, Sim sim){//nerima waktu mau berapa lama
        sim.setStatus("Sim sedang main");
        System.out.println("Sim sedang main...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(waktu); //1 detik main
            }
            catch(InterruptedException e){
                System.out.println("Proses main terganggu");
            }
        });
        t.start();
        try{
            t.join();
            sim.getKesejahteraan().setMood(waktu*2); //namabah mood waktu*2
            sim.getKesejahteraan().setHunger(waktu); //ngurang kenyang waktu
            System.out.println("Proses main selesai");
        }catch(InterruptedException e){
            System.out.println("Proses main terganggu");
        }
    }
        
    public void berdoa(int waktu, Sim sim){
        sim.setStatus("Sim sedang berdoa");
        System.out.println("Sim sedang berdoa...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(waktu); //1 detik berdoa
            }
            catch(InterruptedException e){
                System.out.println("Proses berdoa terganggu");
            }
        });
        t.start();
        try{
            t.join();
            sim.getKesejahteraan().setMood(waktu*3); //namabah mood waktu*3
            sim.getKesejahteraan().setHunger(waktu); //ngurang kenyang sebanyak waktu
            System.out.println("Proses berdoa selesai");
        }catch(InterruptedException e){
            System.out.println("Proses berdoa terganggu");
        }
    }
    public void minum(Sim sim){
        sim.setStatus("Sim sedang minum");
        System.out.println("Sim sedang minum...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(1000); //1 detik minum
            }
            catch(InterruptedException e){
                System.out.println("Proses minum terganggu");
            }
        });
        t.start();
        try{
            t.join();
            sim.getKesejahteraan().setMood(1); //namabah mood 1
            sim.getKesejahteraan().setHunger(-1); //ngurang kenyang 2
            System.out.println("Proses minum selesai");
        }catch(InterruptedException e){
            System.out.println("Proses minum terganggu");
        }
    }
}
