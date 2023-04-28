package essentials;
import java.util.*;

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
    public long elapsedProfesi;
    public double secProfesi;
    public int biaya;

    public Pekerjaan(){
        this.profesi = sim.getPekerjaan();
    }

    public int getGajiPekerjaanBaru(String newProfesi){
        if(newProfesi.equals("Badut Sulap")){
            return 15;
        } 
        else if(newProfesi.equals("Koki")){
            return 30;
        }
        else if(newProfesi.equals("Polisi")){
            return 35;
        }
        else if(newProfesi.equals("Dokter")){
            return 50;
        }
        else if(newProfesi.equals("Programmer")){
            return 45;
        }
        else{
            return 0;
        }
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

    public void kerja(String profesi){

        //Validasi input waktu kelipatan 120
        sim.setStatus("Sim sedang bekerja");
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int waktuKerja = 0;
        while(!valid){
            try{
                System.out.print("Masukkan durasi kerja: ");
                waktuKerja = scan.nextInt();
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println("Input tidak valid. Masukkan input berupa angka!");
                scan.nextLine();
            }
        }
        while(waktuKerja % 120 != 0){
            System.out.println("Input harus berupa kelipatan 120!");
            valid = false;
            while (!valid)
            {
                try 
                {
                    System.out.print("Masukkan durasi kerja (dalem detik dan kelipatan 240):");
                    waktuKerja = scan.nextInt();
                    valid = true;
                }
                catch (Exception e) 
                {
                    System.out.println("Input tidak valid. Masukkan input berupa angka!");
                    scan.nextLine();
                }
            }
        }
        while(waktuKerja%120 == 0){
            if(waktuKerja == 120){ // kerja 2 menit (belom gajian)
                System.out.println("Sim sedang bekerja...");
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
                System.out.println("Sim sedang bekerja");
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
                System.out.println("Sim akan langsung mati");
            }
        }
        scan.close();
    }

    public void gantiPekerjaan(String pekerjaanBaru) {

       //Cek sim bekerja 1 hari (12 menit)
        elapsedProfesi = System.currentTimeMillis() - start;
        secProfesi = Math.floor(elapsedProfesi/1000);

        if (secProfesi < 720.0){
            System.out.println("Belum dapat mengganti pekerjaan");
        }
       //Cek sim bayar 1/2 gaji harian pekerjaan baru
        else{ // lolos cek kerja 12 menit

            //bayar 1/2 biaya kerjaan baru
            biaya = (-1)*(getGajiPekerjaanBaru(pekerjaanBaru))/2;
            sim.setUang(biaya);

            //dapat pekerjaan baru
            sim.setPekerjaan(pekerjaanBaru);

        }
    }
}