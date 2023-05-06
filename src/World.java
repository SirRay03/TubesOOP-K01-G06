package src;
import java.lang.Math;
import javax.swing.JOptionPane;
import gui.*;

public class World{
    private static World instance = new World();

    private static int horizontal = 64;
    private static int vertical = 64;
    private static Rumah[][] map = new Rumah[horizontal][vertical];
    private static Sim[] simList = new Sim[4096];
    private static int simCount = 0;
    private static int time;
    private static int day;
    private static int daySinceNewSim = -1;
    
    // === CONSTRUCTOR ===

    private World(){
        time = 0;
    }

    // === GETTER ===

    public static World getInstance(){
        return instance;
    }

    public int getTime(){
        return time;
    }

    public Rumah[][] getMap(){
        return map;
    }

    public Sim[] getSimList(){
        return simList;
    }

    public int getSimCount(){
        return simCount;
    }

    // === METHOD ===

    public void removeSim(Sim sim){
        int index = 0;
        while (index < simCount && simList[index] != sim){
            index++;
        }
        for(int i = index; i < simCount;i++){
            simList[i] = simList[i+1];
        }
        simCount--;
    }

    public void addSim(Sim sim, Rumah rumah, int horizontalAddr, int verticalAddr){
        boolean onlyOne = false;
        if (simCount == 0){
            onlyOne = true;
        }
        if (daySinceNewSim == day && !onlyOne){
            JOptionPane.showMessageDialog(null, "You can only create one sim per day!");
            new MainMenu();
        }
        else{
            daySinceNewSim = day; 
            if (horizontalAddr == 0 && verticalAddr == 0){
                horizontalAddr = (int)((Math.random() * horizontal)-1);
                verticalAddr = (int)((Math.random() * vertical)-1);
            }
            
            if (map[horizontalAddr][verticalAddr] == null){
                map[horizontalAddr][verticalAddr] = rumah;
                rumah.setOwner(sim);
                rumah.setHAddress(horizontalAddr);
                rumah.setVAddress(verticalAddr);
            }
            else{
                while (map[horizontalAddr][verticalAddr] != null){
                    horizontalAddr = (int)((Math.random() * horizontal)-1);
                    verticalAddr = (int)((Math.random() * vertical)-1);
                }
                map[horizontalAddr][verticalAddr] = rumah;
                rumah.setOwner(sim);
                rumah.setHAddress(horizontalAddr);
                rumah.setVAddress(verticalAddr);
            }
            int i = 0;
            while (simList[i] != null){
                i++;
            }
            simList[i] = sim;
            sim.setRumah(rumah);
            sim.setCurrentRumah(rumah);
            rumah.setHAddress(horizontalAddr);
            rumah.setVAddress(verticalAddr);
            sim.setRuangan(rumah.searchRuangan("Kamar Utama"));
            simCount++;
            JOptionPane.showMessageDialog(null, "New sim created. Welcome to SimPlicity 5, " + sim.getFullName() + "!");
            new LandingPage(sim);
        }
    }

    public String displayTime() {
        return " day " + day + " : " + ((time%720000)/60000) + " minute " + (((time%720000) % 60000)/1000) + " second ";
    }

    public void addDay() {
        day++;
    }

    public int getDay () {
        return day;
    }
    public void addWaktu(int timeinput) {
        if (time + timeinput >= 720000) 
        {
            addDay();
        }
            time += timeinput;
    }

    public int getDistance (int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1,2));
        float distanceAkhir = (float) distance;
        int finalDistance = Math.round(distanceAkhir);
        return finalDistance;
    }
}