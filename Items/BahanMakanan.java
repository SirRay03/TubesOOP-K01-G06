package Items;
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
/**
 * print("Pilih mau beli barang apa")
 * if (button Nasi clicked){
 * BahanMakanan nasi = new BahanMakanan("nasi", 5, 5)
 * }
 */