package src;
import java.lang.Math;

public class World{
    private static World instance = new World();

    private static int horizontal = 64;
    private static int vertical = 64;
    private static Rumah[][] map = new Rumah[horizontal][vertical];
    private static Sim[] simList = new Sim[4096];
    private long time;
    
    // === CONSTRUCTOR ===

    private World(){
        this.time = 720000;
    }

    // === GETTER ===

    public static World getInstance(){
        return instance;
    }
    
    public int getHorizontal(){
        return horizontal;
    }

    public int getVertical(){
        return vertical;
    }
    public static Sim[][] getMap(){
        return map;
    }

    public Long getTime(){
        return time;
    }

    public static Rumah[][] getMap(){
        return map;
    }

    public static Sim[] getSimList(){
        return simList;
    }

    // public <Map> float getDistance (Sim[][] rumah1, Sim[][] rumah2) {
    //     int x1 = 0;
    //     int y1 = 0;
    //     for (int i = 0; i < horizontal; i++) {
    //         for (int j = 0; j < vertical; j++) {
    //             if (getMap() == rumah1) {
    //                 x1 = i;
    //                 y1 = j;
    //             }
    //         }
    //     }
    //     int x2 = 0;
    //     int y2 = 0;
    //     for (int i = 0; i < horizontal; i++) {
    //         for (int j = 0; j < vertical; j++) {
    //             if (getMap() == rumah2) {
    //                 x2 = i;
    //                 y2 = j;
    //             }
    //         }
    //     }
    //     return (float) Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1,2));
    // }

    // === SETTER ===
    public <Map> float getDistance (Sim[][] rumah1, Sim[][] rumah2) {
        int x1 = 0;
        int y1 = 0;
        for (int i = 0; i < horizontal; i++) {
            for (int j = 0; j < vertical; j++) {
                if (getMap() == rumah1) {
                    x1 = i;
                    y1 = j;
                }
            }
        }
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < horizontal; i++) {
            for (int j = 0; j < vertical; j++) {
                if (getMap() == rumah2) {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        return (float) Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1,2));
    }

    public Long getTime(){
        return time;
    }

    public void setTime (Long time){
        this.time -= time;
        if(this.time >= 0){
            this.time += 720000;
        }
    }

    // === METHOD ===

    public static void addSim(Sim sim, Rumah rumah){
        int horizontalAddr = (int)((Math.random() * horizontal)-1);
        int verticalAddr = (int)((Math.random() * vertical)-1);

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
        sim.setRuangan(rumah.searchRuangan("Kamar Utama"));
    }

    // public <Map> float getDistance (Sim[][] rumah1, Sim[][] rumah2) {
    //     int x1 = 0;
    //     int y1 = 0;
    //     for (int i = 0; i < horizontal; i++) {
    //         for (int j = 0; j < vertical; j++) {
    //             if (getMap() == rumah1) {
    //                 x1 = i;
    //                 y1 = j;
    //             }
    //         }
    //     }
    //     int x2 = 0;
    //     int y2 = 0;
    //     for (int i = 0; i < horizontal; i++) {
    //         for (int j = 0; j < vertical; j++) {
    //             if (getMap() == rumah2) {
    //                 x2 = i;
    //                 y2 = j;
    //             }
    //         }
    //     }
    //     return (float) Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1,2));
    // }
}