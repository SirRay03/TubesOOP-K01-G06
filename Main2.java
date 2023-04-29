import java.util.Scanner;

import src.Pekerjaan;
import src.Sim;

public class Main2{
    public static void main(String[] args){

        //Driver Pekerjaan
        /* Pekerjaan p = new Pekerjaan();
		System.out.println("Profesi: " + p.getProfesi());
		System.out.println("Gaji: " + p.getGaji());  */

        //Driver         
        Sim s = new Sim("awal", "last");
        //System.out.println("Nama: " + s.getFirstName());

        System.out.println("Pekerjaan:"+ s.getPekerjaan().getProfesi());
        System.out.println("Gaji:"+ s.getPekerjaan().getGaji());
        s.kerja(new Pekerjaan());
        //s.kerja(new Pekerjaan());


        
    }
}