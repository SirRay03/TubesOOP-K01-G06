import java.util.ArrayList;
import java.util.List;

 public class Pekerjaan {
    private Sim sim;
     private int gajiBadutSulap = 15;
    private int gajiKoki = 30;
    private int gajiPolisi = 35;
    private int gajiProgrammer = 45;
    private int gajiDokter = 50; 
    public int waktuKerja;
    public long elapsedTime;
    public long start = System.currentTimeMillis();
    public double sec = 0.0;
    public String profesi;


    public Pekerjaan(){
        this.profesi = sim.getPekerjaan();
    }

    public int getGajiBadutSulap(){
        return this.gajiBadutSulap;
    }
    public int getgajiKoki(){
        return this.gajiKoki;
    }
    public int getgajiProgrammer(){
        return this.gajiProgrammer;
    }
    public int getgajiPolisi(){
        return gajiPolisi;
    }
    public int getgajiDokter(){
        return gajiDokter;
    }

    public void setGaji(String profesi){
        if(profesi.equals("Badut Sulap")){
            sim.setUang(getGajiBadutSulap());
        }
        else if(profesi.equals("Koki")){
            sim.setUang(getgajiKoki());
        }
        else if(profesi.equals("Polisi")){
            sim.setUang(getgajiPolisi());
        }
        else if(profesi.equals("Programmer")){
            sim.setUang(getgajiProgrammer());
        }
        else if(profesi.equals("Dokter")){
            sim.setUang(getgajiDokter());
        }
    }

    public void kerja(int waktuKerja, String profesi){
        //Validasi input waktu sebesar kelipatan 120
        if(waktuKerja%120 != 0){
            System.out.println("Masukkan waktu dalam kelipatan 120!");
        }
        else{
            if(waktuKerja == 120){ // kerja 2 menit (belom gajian)
                System.out.println("Sim sedang bekerja ...");
                Thread t = new Thread (()->{
                try{
                    Thread.sleep(120000); // 120 detik (1 siklus kerja)
                    elapsedTime = System.currentTimeMillis() - start; //120000
                    sec = sec + Math.floor(elapsedTime/1000); // 120 detik = 2 menit
                    //getGaji();
                    sim.getKesejahteraan().setMood(-40);
                    sim.getKesejahteraan().setHunger(-40);
                } catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }
                });
                t.start();
                try{
                    t.join();
                }catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }

                if (sec == 240.0){
                    setGaji(profesi);
                }
            }
            else if (waktuKerja == 240){ // kerja 4 menit (langsung gajian)
                //auto gajian
                //-80 mood
                //-80 kekenyangan

                System.out.println("Sim sedang bekerja ...");
                Thread t = new Thread (()->{
                try{
                    Thread.sleep(240000); // 240 detik (1 siklus kerja)
                    setGaji(profesi);
                    sim.getKesejahteraan().setMood(-80);
                    sim.getKesejahteraan().setHunger(-80);
                } catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }
                });
                t.start();
                try{
                    t.join();
                }catch(InterruptedException e){
                    System.out.println("Proses bekerja terganggu");
                }
            }
            else if(waktuKerja > 240){ //360
                //sim auto mati 
            }
        }
    }

    public void gantiPekerjaan(String pekerjaanBaru) {
       //Cek sim bekerja 3 hari (12 menit)
       

       //Cek sim bayar 1/2 gaji harian pekerjaan baru

       //Cek pekerjaan baru dikerjakan 1 hari setelah diubah
    }
}



