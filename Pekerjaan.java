import java.util.ArrayList;
import java.util.List;

 public class Pekerjaan {
    /* private String BadutSulap;
    private String Koki;
    private String Polisi;
    private String Programmer;
    private String Dokter; */

    private Sim sim;
    private int gajiBadutSulap = 15;
    private int gajiKoki = 30;
    private int gajiPolisi = 35;
    private int gajiProgrammer = 45;
    private int gajiDokter = 50;
    public int waktuKerja;

    public void getGaji(){
        if(sim.getPekerjaan().equals("Badut Sulap")){
            setGajiBadut();
        }
        else if (sim.getPekerjaan().equals("Koki")){
            setGajiKoki();
        }
        else if (sim.getPekerjaan().equals("Polisi")){
            setGajiPolisi();
        }
        else if (sim.getPekerjaan().equals("Programmer")){
            setGajiProgrammer();
        }
        else if (sim.getPekerjaan().equals("Dokter")){
            setGajiDokter();
        } 
    }

    public void setGajiBadut(){
        sim.setMoney(gajiBadutSulap);
    }
    public void setGajiDokter(){
        sim.setMoney(gajiDokter);
    }
    public void setGajiKoki(){
        sim.setMoney(gajiKoki);
    }
    public void setGajiPolisi(){
        sim.setMoney(gajiPolisi);
    }
    public void setGajiProgrammer(){
        sim.setMoney(gajiProgrammer);
    }

    public void kerja(String profesi){

        System.out.println("Sim sedang bekerja ...");
        Thread t = new Thread (()->{
        try{
            Thread.sleep(240000);
            getGaji();
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

    //ganti pekerjaan kalo sim udah bekerja 12 mnit (3 hari) dengan bayar 1/2  gaji harian pekerjaan baru
    public void gantiPekerjaan(String pekerjaanBaru) {
       //Cek sim bekerja 3 hari (12 menit)

       //Cek sim bayar 1/2 gaji harian pekerjaan baru

       //Cek pekerjaan baru dikerjakan 1 hari setelah diubah
    }
}



