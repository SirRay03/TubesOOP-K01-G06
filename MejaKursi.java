import java.lang.Math;
import java.sql.Time;

public class MejaKursi extends NonMakanan {
    public MejaKursi(){
        super(50, 3, 3); //harga, panjang, lebar sudah ditetapkan
    }
    public void duduk(){
        //implementation code goes here
    }
    public void makan(){
        //implementation code goes here
    }
    public void mainGame(Time time,Sim sim){
        //Parameter Sim sementara masih belum nemu cara akses atribut sim
        //implementation code goes here
        long timeLong = time.getTime()/ 1000; 
        long pengali = Math.floorDiv(timeLong, 20);
        int pengaliInt = ((int)pengali);
        sim.kesejahteraan.setHunger(pengaliInt *-5);
        sim.kesejahteraan.setHealth(pengaliInt * 5);
        sim.kesejahteraan.setMood(pengaliInt * 10);
        //majuin waktuny belum
    }
        
    public void chatting(){
        //implementation code goes here
    }
    public void minumKopi(){
        //implementation code goes here
    }
}
