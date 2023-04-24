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
    public void tidur(){
        //implementation code goes here
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
