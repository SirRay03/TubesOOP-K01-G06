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
}
