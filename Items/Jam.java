package Items;

import src.*;

public class Jam extends NonMakanan {
    public Jam(){
        super(10, 1, 1);
    }
    public void printListAction(){
        System.out.println("1. Melihat Jam");
    };
    public void doAction(Object... args){
        //implementation code goes here
        //Object... args artinya dia bisa nerima banyak argumen
        //akses argumen nya satu2, baru cast jadi yg sesuai
        //misal: doAction(Sim sima, String contoh)
        //brarti cara akses parameter pertama nya : Sim sima = (Sim) args[0]
        //brarti cara akses parameter kedua nya : String contoh = (String) args[1]
        World world = World.getInstance();
        Sim sim =(Sim) args[0];

        int hour;
        int minute;
        int second;
        int duration;
        int day;

        minute = (720000 - world.getTime()) / 60000;
        second =  (720000 - world.getTime()) % 60000;
        System.out.println("SISA WAKTU HARI INI ADALAH " + minute + " MENIT " + second +" DETIK.");

        System.out.println("SISA WAKTU PENGIRIMAN ITEM");
        if(sim.getListOnDelivery().isEmpty()){
            System.out.println("Tidak ada barang dalam pengiriman");
        }
        else{
            for(Item a : sim.getListOnDelivery()){
                if(a instanceof NonMakanan){
                    NonMakanan nonMakanan = (NonMakanan) a;
                    day = world.getDay() - nonMakanan.getHariMulai();
                    duration = ((day*720000 + world.getTime()) + nonMakanan.getWaktuPengantaran() * 1000 - nonMakanan.getWaktuMulai())/1000;
                    hour = duration/3600;
                    minute = (duration - hour*3600) / 60;
                    second = (duration - hour*3600) % 60;   
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
                    day = world.getDay() - bahanMakanan.getHariMulai();
                    duration = ((day*720000 + world.getTime()) + bahanMakanan.getWaktuPengantaran()*1000 - bahanMakanan.getWaktuMulai())/1000;
                    hour = duration/3600;
                    minute = (duration - hour*3600) / 60;
                    second = (duration - hour*3600) % 60;                    
                    System.out.println(bahanMakanan.getNama().toUpperCase() + " ADALAH " + hour + " JAM " + + minute + " MENIT " + second +" DETIK.");
                }
            
        }
        
    }
    System.out.println("SISA WAKTU UPGRADE RUMAH");
    if(sim.getListUpgrade().isEmpty()){
        System.out.println("Tidak ada rumah yang sedang diupgrade");
    }
    else{
        for(Rumah rumah : sim.getListUpgrade()){
            day = world.getDay() - rumah.getHariMulai();
            duration = ((day*720000 + world.getTime()) +rumah.getWaktuUpgrade() - rumah.getWaktuMulai())/1000;
            hour = duration/3600;
            minute = (duration - hour*3600) / 60;
            second = (duration - hour*3600) % 60;  
            System.out.println("Sisa Waktu " + rumah.getClass().getSimpleName().toUpperCase() + " ADALAH " + hour + " JAM " + minute + " MENIT " + second + " DETIK.");
        }
    }
    }
}