package src;
import java.util.ArrayList;


public class World2{
    private int panjang;
    private int lebar;
    private ArrayList<Point> listofRumah;
    private char[][] map; // declare a 2D char array to store the map
    private static int waktu;
    private static int day;
    private ArrayList<Sim> listofSims;

    public World2(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
        this.map = new char[lebar * 2 + 1][panjang * 2 + 1]; // initialize the map with the appropriate size
        waktu = 0; //milisekon
        day = 1; //hari ke-... 
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

    public static int getWaktu(){
        return waktu;
    }
    public static int getDay() {
        return day;
    }

    public static void addDay() {
        day++;
    }

    public static void addWaktu(int time) {
        if (waktu + time >= 720000) 
        {
            addDay();
            waktu = waktu + time - 720000;
        }
        else 
        {
            waktu += time;
        }
    }
}
// /**
//  package src;
// import java.util.ArrayList;


// public class World2{
//    private static World2 instance = new World2();
//    private World2(){}
//    public static World2 getInstance(){
//     return instance;
//    }
// }

//  */
