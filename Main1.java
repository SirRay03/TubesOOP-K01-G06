import java.util.*;

public class Main1 {
    public static void main(String[] args) {

        System.out.println("Welcome to Sim-Plicity!");
        System.out.println("Pilih Menu yang anda inginkan");
        System.out.println("==============================");
        System.out.println("1. START GAME");
        System.out.println("2. HELP");
        System.out.println("3. EXIT");
        System.out.println("==============================");
        System.out.println("Masukkan angka: ");
        Scanner aplikasi = new Scanner(System.in);
        int menu = aplikasi.nextInt();
        boolean gameOn = false;
        while (menu != 3){
            if (menu == 1){
                //START GAME
                gameOn = true;
                boolean endgame = false;
                
                System.out.println("GAME START");
                //generate world
                World world = new World();
                world.start();
                //generate sim
                //generate rumah dan ruangan
            }
        }
    }
}
