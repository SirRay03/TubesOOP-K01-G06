package objects;
public class Masakan extends Makanan{
    private final BahanMakanan nasi;
    private final BahanMakanan kentang;
    private final BahanMakanan ayam;
    private final BahanMakanan sapi;
    private final BahanMakanan wortel;
    private final BahanMakanan bayam;
    private final BahanMakanan kacang;
    private final BahanMakanan susu;

    Masakan(String nama, int kekenyangan, BahanMakanan nasi, BahanMakanan kentang, BahanMakanan ayam, BahanMakanan sapi, BahanMakanan wortel, BahanMakanan bayam, BahanMakanan kacang, BahanMakanan susu){
        super(nama, kekenyangan);
        this.nasi = nasi;
        this.kentang = kentang;
        this.ayam = ayam;
        this.sapi = sapi;
        this.wortel = wortel;
        this.bayam = bayam;
        this.kacang = kacang;
        this.susu = susu;
    }
}
