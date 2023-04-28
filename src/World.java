package src;
import java.lang.Math;

public class World{
    private static World instance = new World();

    private static int horizontal = 64;
    private static int vertical = 64;
    private static Sim[][] map = new Sim[horizontal-1][vertical-1];
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

    public Long getTime(){
        return time;
    }

    public static Sim[][] getMap(){
        return map;
    }

    // === SETTER ===

    public void setTime (Long time){
        this.time -= time;
        if(this.time >= 0){
            this.time += 720000;
        }
    }

    // === METHOD ===

    public static void addSim(Sim sim){
        int horizontalAddr = (int)((Math.random() * horizontal)-1);
        int verticalAddr = (int)((Math.random() * vertical)-1);

        if (map[horizontalAddr][verticalAddr] == null){
            map[horizontalAddr][verticalAddr] = sim;
        }
        else{
            while (map[horizontalAddr][verticalAddr] != null){
                horizontalAddr = (int)((Math.random() * horizontal)-1);
                verticalAddr = (int)((Math.random() * vertical)-1);
            }
            map[horizontalAddr][verticalAddr] = sim;
        }
    }

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
}