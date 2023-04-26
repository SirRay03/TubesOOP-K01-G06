public class Kasur extends NonMakanan {
    public enum tipeKasur{
        Single(50, 4, 1),
        Queen(100, 4, 2),
        King(150, 5, 2);

        private int panjang; //buat select kata barengan pake ctrl+d
        private int lebar; 
        private int harga;

        tipeKasur(int harga, int panjang, int lebar){
            this.harga = harga;
            this.lebar = lebar;
            this.panjang = panjang;
        }
    }

    public Kasur(tipeKasur tipe){
        super(tipe.harga, tipe.panjang, tipe.lebar);
    }
    public void doAction(Object... args){
        //implementation code goes here
        //Object... args artinya dia bisa nerima banyak argumen
        //akses argumen nya satu2, baru cast jadi yg sesuai
        //misal: doAction(Sim sima, String contoh)
        //brarti cara akses parameter pertama nya : Sim sima = (Sim) args[0]
        //brarti cara akses parameter kedua nya : String contoh = (String) args[1]
    }
}


/**

 * CARA RUN DI MAIN*
 public class Main{
    public static void main(String[] args){
        Kasur largeBed = new Kasur(Kasur.tipeKasur.Queen);
        int largeBedPrice = largeBed.getHarga();
        int largeBedLength = largeBed.getPanjang();
        int largeBedWidth = largeBed.getLebar();
        System.out.println("Large Bed Price: " + largeBedPrice);
        System.out.println("Large Bed Length: " + largeBedLength);
        System.out.println("Large Bed Width: " + largeBedWidth);
}
}
 */
