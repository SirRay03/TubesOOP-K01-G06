public class Kompor extends NonMakanan {
    public enum tipeKompor{
        Gas(100, 2, 1),
        Listrik(200, 1, 1);

        private int panjang;
        private int lebar; 
        private int harga;

        tipeKompor(int harga, int panjang, int lebar){
            this.harga = harga;
            this.lebar = lebar;
            this.panjang = panjang;
        }
    }

    public Kompor(tipeKompor tipe){
        super(tipe.harga, tipe.panjang, tipe.lebar);
    }
    public void memasak(){
        //implementation code goes here
    }
}


/**

 * CARA RUN DI MAIN*
LIAT CARA DI KASUR.JAVA
 */
