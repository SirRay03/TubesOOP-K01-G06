package Items;
import java.lang.Math;
import java.sql.Time;

import src.Sim;

public class MejaKursi extends NonMakanan {
    public MejaKursi(){
        super(50, 3, 3); //harga, panjang, lebar sudah ditetapkan
    }
    public void doAction(Object... args){
        //implementation code goes here
        //Object... args artinya dia bisa nerima banyak argumen
        //akses argumen nya satu2, baru cast jadi yg sesuai
        //misal: doAction(Sim sima, String contoh)
        //brarti cara akses parameter pertama nya : Sim sima = (Sim) args[0]
        //brarti cara akses parameter kedua nya : String contoh = (String) args[1]
    }
    public void makan(){
        //implementation code goes here
    }
    public void main(int waktu, Sim sim){//nerima waktu mau berapa lama
        sim.setStatus("Sim sedang main");
        System.out.println("Sim sedang main...");
        Thread t = new Thread(()->{
        try{
                Thread.sleep(waktu); //1 detik main
                sim.getKesejahteraan().setMood(waktu*2); //namabah mood waktu*2
                sim.getKesejahteraan().setHunger(waktu); //ngurang kenyang waktu
                System.out.println("Proses main selesai");
            }
            catch(InterruptedException e){
                System.out.println("Proses main terganggu");
            }
        });
        t.start();
        try{
            t.join();
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
                sim.getKesejahteraan().setMood(waktu*3); //namabah mood waktu*3
                sim.getKesejahteraan().setHunger(waktu); //ngurang kenyang sebanyak waktu
                System.out.println("Proses berdoa selesai");
            }
            catch(InterruptedException e){
                System.out.println("Proses berdoa terganggu");
            }
        });
        t.start();
        try{
            t.join();
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
                sim.getKesejahteraan().setMood(1); //namabah mood 1
                sim.getKesejahteraan().setHunger(-1); //ngurang kenyang 2
                System.out.println("Proses minum selesai");
            }
            catch(InterruptedException e){
                System.out.println("Proses minum terganggu");
            }
        });
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            System.out.println("Proses minum terganggu");
        }
    }
}
