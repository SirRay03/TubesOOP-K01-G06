package objects;
import java.util.concurrent.TimeUnit;

import essentials.Sim;
import essentials.World;

public class Jam extends NonMakanan {
    public Jam(){
        super(10, 1, 1);
    }
    public void doAction(Object... args){
        //implementation code goes here
        //Object... args artinya dia bisa nerima banyak argumen
        //akses argumen nya satu2, baru cast jadi yg sesuai
        //misal: doAction(Sim sima, String contoh)
        //brarti cara akses parameter pertama nya : Sim sima = (Sim) args[0]
        //brarti cara akses parameter kedua nya : String contoh = (String) args[1]
        World world = (World) args[0]; 
        Sim sim =(Sim) args[1];

        long hour;
        long minute;
        long second;
        long duration;

        duration = world.getTime();
        hour = TimeUnit.MILLISECONDS.toHours(duration);
        minute = TimeUnit.MILLISECONDS.toMinutes(duration - TimeUnit.HOURS.toMillis(hour));
        second =  TimeUnit.MILLISECONDS.toSeconds(duration - TimeUnit.HOURS.toMillis(hour) - TimeUnit.MINUTES.toMillis(minute));
        System.out.println("SISA WAKTU HARI INI ADALAH " + minute + " MENIT " + second +" second.");

        System.out.println("SISA WAKTU PENGIRIMAN ITEM");
        if(sim.getListOnDelivery().isEmpty()){
            System.out.println("Tidak ada barang dalam pengiriman");
        }
        else{
            for(Item a : sim.getListOnDelivery()){
                if(a instanceof NonMakanan){
                    NonMakanan nonMakanan = (NonMakanan) a;
                    duration = nonMakanan.getWaktuPengantaran() - (System.currentTimeMillis() - nonMakanan.getWaktuMulai());
                    hour = TimeUnit.MILLISECONDS.toHours(duration);
                    minute = TimeUnit.MILLISECONDS.toMinutes(duration - TimeUnit.HOURS.toMillis(hour));
                    second =  TimeUnit.MILLISECONDS.toSeconds(duration - TimeUnit.HOURS.toMillis(hour) - TimeUnit.MINUTES.toMillis(minute));
                    if(nonMakanan instanceof Jam){
                        Jam jam = (Jam) nonMakanan;
                        System.out.println(jam.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK.");
                    }
                    else if(nonMakanan instanceof Kaca){
                        Kaca kaca = (Kaca) nonMakanan;
                        System.out.println(kaca.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK.");
                    }
                    else if(nonMakanan instanceof Kasur){
                        Kasur kasur = (Kasur) nonMakanan;
                        System.out.println(kasur.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK.");
                    }
                    else if(nonMakanan instanceof Kertas){
                        Kertas kertas = (Kertas) nonMakanan;
                        System.out.println(kertas.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK.");
                    }
                    else if(nonMakanan instanceof MejaKursi){
                        MejaKursi mejaKursi = (MejaKursi) nonMakanan;
                        System.out.println(mejaKursi.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK.");
                    }
                    else if(nonMakanan instanceof Toilet){
                        Toilet toilet = (Toilet) nonMakanan;
                        System.out.println(toilet.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK.");
                    }
                    else if(nonMakanan instanceof Kompor){
                        Kompor kompor = (Kompor) nonMakanan;
                        System.out.println(kompor.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK.");
                    }
                } 
                else if(a instanceof BahanMakanan){
                    BahanMakanan bahanMakanan = (BahanMakanan) a;
                    duration = bahanMakanan.getWaktuPengantaran() - (System.currentTimeMillis() - bahanMakanan.getWaktuMulai());
                    hour = TimeUnit.MILLISECONDS.toHours(duration);
                    minute = TimeUnit.MILLISECONDS.toMinutes(duration - TimeUnit.HOURS.toMillis(hour));
                    second =  TimeUnit.MILLISECONDS.toSeconds(duration - TimeUnit.HOURS.toMillis(hour) - TimeUnit.MINUTES.toMillis(minute));
                    System.out.println(bahanMakanan.getNama().toUpperCase() + " ADALAH " + hour + " JAM " + + minute + " MENIT " + second +" DETIK.");
                }
            
        }
        
    }
}
