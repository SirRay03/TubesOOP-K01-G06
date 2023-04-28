public class BahanMakanan extends Makanan{
    private int harga;
    public BahanMakanan(String nama, int kekenyangan, int harga){
        super(nama, kekenyangan);
        this.harga = harga;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public int getHarga(){
        return harga;
    }
    public String getNama(){
        return nama;
    }
    
}
