import java.util.*; 

public class Kertas extends NonMakanan {
    public Kertas(){
        super(1, 1, 1);
    }
    public void menulis(){
        //implementation code goes here
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukkan kata atau kalimat yang ingin ditulis:");
        // String input
        String tulisan = scan.nextLine();
        // Output input by user
        System.out.println(tulisan);

        scan.close();
    }
}
