package Items;
import java.util.Scanner;

import src.Sim;
import src.World;
//import gui.SleepOverlay;
//import src.World2;

public class Kasur extends NonMakanan {
    
    private String nama;
    private int duration;

    public enum tipeKasur{
        Kecil("Single",50, 4, 1),
        Sedang("Queen",100, 4, 2),
        Besar("King",150, 5, 2);

        private String nama;
        private int panjang; //buat select kata barengan pake ctrl+d
        private int lebar; 
        private int harga;

        tipeKasur(String nama, int harga, int panjang, int lebar){
            this.nama = nama;
            this.harga = harga;
            this.lebar = lebar;
            this.panjang = panjang;
        }
    }

    public Kasur(tipeKasur tipe){
        super(tipe.harga, tipe.panjang, tipe.lebar);
        this.nama = tipe.nama;
    }

    public String getNama(){
        return nama;
    }

    public int getdurasiTidur(){
        return duration;
    }

    public void printListAction(){
        System.out.println("1. Tidur");
    };

    public void doAction(Object... args){
        //implementation code goes here
        //Object... args artinya dia bisa nerima banyak argumen
        //akses argumen nya satu2, baru cast jadi yg sesuai
        //misal: doAction(Sim sima, String contoh)
        //brarti cara akses parameter pertama nya : Sim sima = (Sim) args[0]
        //brarti cara akses parameter kedua nya : String contoh = (String) args[1]
        Sim sim = (Sim) args[0];
        sim.setStatus("Sim sedang tidur");
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int duration = 1;
        while (!valid) 
        {
            try 
            {
                System.out.print("Masukkan durasi tidur (dalem detik dan kelipatan 240): ");
                duration = scan.nextInt();
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println("Input tidak valid. Masukkan input berupa angka!");
                scan.nextLine();
            }
        }
        while (duration % 240 != 0)
        {
            System.out.println("Input harus berupa kelipatan 240! Silakan input ulang!");
            valid = false;
            while (!valid)
            {
                try 
                {
                    System.out.print("Masukkan durasi tidur (dalem detik dan kelipatan 240):");
                    duration = scan.nextInt();
                    valid = true;
                }
                catch (Exception e) 
                {
                    System.out.println("Input tidak valid. Masukkan input berupa angka!");
                    scan.nextLine();
                }
            }
        }
        int totalDurasi = duration;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(totalDurasi * 1000);
                    sim.tambahWaktuBelumBAB(totalDurasi);
                    World.getInstance().addWaktu(totalDurasi);
                    // World.getInstance().checkSimTime(totalDurasi);
                    sim.resetTimerBelumBab();
                } catch (InterruptedException e) {
                    System.out.println("Proses tidur terganggu");
                }
            }
        });
        System.out.println("Sedang tidur...");
        thread.start();
        scan.close();
        try{
            thread.join();
            sim.getKesejahteraan().setHealth(30 * (totalDurasi / 240));
            sim.getKesejahteraan().setHealth(30 * (totalDurasi / 240));
            System.out.println("Tidur selesai!");
        }catch(InterruptedException e){
            System.out.println("Proses tidur terganggu");
        }
    }
}

/**

 * CARA RUN DI MAIN*
 public class Main{
    public static void main(String[] args){
        Kasur largeBed = new Kasur(Kasur.tipeKasur.Queen);
        int largeBedPrice = largeBed.getHarga();
        int largeBedLength = largeBed.getPanjang();
        int largeBedWidth = largeBed.getLebar();
        System.out.println("Large Bed Price: " + largeBedPrice);
        System.out.println("Large Bed Length: " + largeBedLength);
        System.out.println("Large Bed Width: " + largeBedWidth);
}
}
 */
