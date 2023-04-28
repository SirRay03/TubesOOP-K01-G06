package Items;
import src.*;

public class Time {
    private static Time instance = new Time();
    private long time;
    private boolean start;
    private Time(){
        time = 720;
        start = false;
    }
    public static Time getInstance(){
        return instance;
    }
    public void stopTime(World world){
        

    }
    
    public void startStopTime(World2 world2){
        for(Sim a : world2.getlistofSim()){
            if( a.getStatus() != "idle"){
                start = true;
            }
        }
        Thread thread = new Thread(() -> {
            while (start) {
                try {
                    Thread.sleep(1000); // Menunggu 1 detik
                    time --;
                    if (time <=0){
                        time += 720;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    } 
}