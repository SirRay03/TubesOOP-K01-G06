public class MasakanBuilder{
    private String nama;
    private int kekenyangan;
    private String nasi;
    private String kentang;
    private BahanMakanan ayam;
    private BahanMakanan sapi;
    private BahanMakanan wortel;
    private BahanMakanan bayam;
    private BahanMakanan kacang;
    private BahanMakanan susu;
    public MasakanBuilder setNama(String nama){
        this.nama = nama;
        return this;
    }
    public MasakanBuilder setKekenyangan(int kekenyangan){
        this.kekenyangan = kekenyangan;
        return this;
    }
    public MasakanBuilder setNasi(String nasi){
        this.nasi = nasi;
        return this;
    }
    public MasakanBuilder setKentang(String kentang){
        this.kentang = kentang;
        return this;
    }
    public MasakanBuilder setAyam(BahanMakanan ayam){
        this.ayam = ayam;
        return this;
    }
    public MasakanBuilder setSapi(BahanMakanan sapi){
        this.sapi = sapi;
        return this;
    }
    public MasakanBuilder setWortel(BahanMakanan wortel){
        this.wortel = wortel;
        return this;
    }
    public MasakanBuilder setBayam(BahanMakanan bayam){
        this.bayam = bayam;
        return this;
    }
    public MasakanBuilder setKacang(BahanMakanan kacang){
        this.kacang = kacang;
        return this;
    }
    public MasakanBuilder setSusu(BahanMakanan susu){
        this.susu = susu;
        return this;
    }
    public int getKekenyangan(){
        return kekenyangan;
    }
    public Masakan build(){
        return new Masakan(nama, kekenyangan, nasi, kentang, ayam, sapi, wortel, bayam, kacang, susu);
    }
}