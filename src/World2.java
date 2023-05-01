package src;
import java.util.ArrayList;


public class World2{
    private int panjang;
    private int lebar;
    private ArrayList<Point> listofRumah;
    private char[][] map; // declare a 2D char array to store the map
    private long time;
    private ArrayList<Sim> listofSims;

    public World2(int panjang, int lebar){
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

    public void addRumah(int x, int y){//i kebawah (kordinat y) j kesamping (kordinat x)
        //Validasi rumah melewati batas
        if (x >= 0 && x <= getLebarWorld() && y >= 0 && y <= getPanjangWorld()){
            //Validasi apakah sudah ada rumah yang dibangun sebelumnya
            //Jika belum ada rumah yang dibangun
            if (map[y][x] != '0'){
                //Mengubah petak yang ada menjadi rumah
                map[y][x] = '0';
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