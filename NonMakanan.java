public abstract class NonMakanan implements Objek{
    protected int panjang; 
    protected int lebar; 
    protected int harga;
    public NonMakanan(int harga,int panjang, int lebar){
        this.harga = harga;
        this.lebar = lebar;
        this.panjang = panjang;
    }
    public int getPanjang(){
        return panjang;
    }
    public int getLebar(){
        return lebar;
    }
    public int getHarga(){
        return harga;
    }
    public void setPanjang(int panjang){
        this.panjang = panjang;
    }
    public void setLebar(int lebar){
        this.lebar = lebar;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public void beliBarang(){
        /**
         * ide nya jadi siapa yg manggil (cari nama kelas yg manggil)
         * masukin waktu pengirimannya Waktu pengiriman=random(1,5)*30 detik
         * itung waktunya
         * abis, add list di inventory: biar nambah barang nya disana (nama barang = nama kelas yang manggil beli barang ini)
         */
    }
}
