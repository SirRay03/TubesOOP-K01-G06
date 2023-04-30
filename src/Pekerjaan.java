package src;
import java.util.*;

 public class Pekerjaan {
    private int gaji;
    private String profesi;

    public Pekerjaan(){
        Random rand = new Random();
        int randomProfesi = rand.nextInt(5)+1; //1-5
        if(randomProfesi == 1){
            this.profesi = "Badut Sulap";
            this.gaji = 15;
        }
        else if(randomProfesi == 2){
            this.profesi = "Koki";
            this.gaji = 30;
        }
        else if(randomProfesi == 3){
            this.profesi = "Polisi";
            this.gaji = 35;
        }
        else if(randomProfesi == 4){
            this.profesi = "Programmer";
            this.gaji = 45;
        }
        else if(randomProfesi == 5){
            this.profesi = "Dokter";
            this.gaji = 50;
        }
    }

    public String getProfesi(){
        return this.profesi;
    }
    public int getGaji(){
        return this.gaji;
    }
    public void setPekerjaan(String profesi){

        


        this.profesi = profesi;
        if(this.profesi == "Badut Sulap"){
            this.gaji = 15;
        }
        else if(this.profesi == "Koki"){
            this.gaji = 30;
        }
        else if(this.profesi == "Polisi"){
            this.gaji = 35;
        }
        else if(this.profesi == "Programmer"){
            this.gaji = 45;
        }
        else if(this.profesi == "Dokter"){
            this.gaji = 50;
        }
    }
 }