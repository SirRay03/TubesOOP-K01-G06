package essentials;
import java.util.ArrayList;


public class World{
    private int panjang;
    private int lebar;
    private ArrayList<Point> listofRumah;
    private char[][] map; // declare a 2D char array to store the map
    private long time;
    private ArrayList<Sim> listofSims;

    public World(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
        this.map = new char[lebar * 2 + 1][panjang * 2 + 1]; // initialize the map with the appropriate size
        this.time = 720000;
    }

    public void createMap() {
        for (int i = 0; i < lebar ; i++) {
            for (int j = 0; j < panjang; j++) {
                map[i][j] = '*';
            }
        }
    }
    
    public int getPanjangWorld(){
        return panjang;
    }

    public int getLebarWorld(){
        return lebar;
    }

    public void addRumah(int x, int y){
        //Validasi rumah melewati batas
        if (x >= 0 && x <= getLebarWorld() && y >= 0 && y <= getPanjangWorld()){
            boolean cekRumah = true;
            //Validasi apakah sudah ada rumah yang dibangun sebelumnya
            for(int i = 0; i < lebar; i++ ){
                for (int j = 0; j < panjang; j++){
                    if (map[i][j] == '0'){
                        cekRumah = false;
                    }
                }
            }
            //Jika belum ada rumah yang dibangun
            if (cekRumah){
                //Mengubah petak yang ada menjadi rumah
                map[x][y] = '0';
                //Menambahkan rumah ke listofRumah
                listofRumah.add(new Point(x,y));
            }
            else{
                System.out.println("Rumah sudah ada");
            }   
        }
        else{
            System.out.println("Rumah melewati batas");
        }
    }

    public void addSim(Sim newSim){
        listofSims.add(newSim);
    }

    public ArrayList<Sim> getlistofSim(){
        return listofSims;
    }
    public ArrayList<Point> getlistofRumah(){
        return listofRumah;
    }

    public void printMap() {
         for (int i = 0; i < lebar * 2 + 1; i++) {
            for (int j = 0; j < panjang * 2 + 1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
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

}
