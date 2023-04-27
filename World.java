import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class World{
    private int panjang;
    private int lebar;

    public World(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }
    public void Map(int panjang, int lebar) {
        for (int i = 0; i < lebar * 2 + 1; i++) {
            for (int j = 0; j < panjang * 2 + 1; j++) {
                if (j % 2 == 0) {
                    System.out.print("+ ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
            if (i == lebar) break;
            for (int j = 0; j < panjang * 2+1; j++) {
                if (j % 2 == 0) {
                    System.out.print("| ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }    

    Timer timer = new Timer();
    int i = 0;
    TimerTask task = new TimerTask(){
        public void run(){
            String time = getTime(i);
            System.out.println("Waktu berjalan!");
            System.out.println("Jumlah hari di Simplicity: "+time);
            i++;
        }
    };

    public void runTimer(){
        timer.schedule(task, 0, 720000 ); //1 detik = 1000, 720 detik = 720000
    }

    static String getTime(int sec)
    {
        //if we have hours minutes and seconds
        int day = 0;
        int remainderOfDay = 0;
        int minutes = 0;
        int seconds = 0;

        if (sec >= 720) // if we have an hour or more     
        {
            day = sec / 720;               
            remainderOfDay = sec % 720;        // could be more or less than a min

            if (remainderOfDay >= 60)   //check if remainder is more or equal to a min
            {
                minutes = remainderOfDay / 60;
                seconds = remainderOfDay % 60;
            }
            else
            {                       // if it's less than a min
                seconds = remainderOfDay;
            }
        }
        // if we have a min or more
        else if (sec >= 60)                
        {
            day = 0;               
            minutes = sec / 60;
            seconds = sec % 60;
        }
        //if we have just seconds
        else if (sec < 60)
        {
            day = 0;
            minutes = 0;
            seconds = sec;
        }

        //i get integer hour minuite second. i want to transform them to strings:
        String strDays;
        String strMins; 
        String strSecs; 

        if(seconds < 10)
            strSecs = "0" + Integer.toString(seconds);
        else
            strSecs = Integer.toString(seconds);
    
        if(minutes < 10)
            strMins = "0" + Integer.toString(minutes);
        else
            strMins = Integer.toString(minutes);
        
        if(day < 10)
            strDays = Integer.toString(day);
        else
            strDays = Integer.toString(day);
            
        //String time = strDays + ":" + strMins + ":" + strSecs;
        String time = strDays;
        return time;
        }
}
