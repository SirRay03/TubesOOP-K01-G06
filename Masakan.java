import java.util.ArrayList;
import java.util.List;
public class Masakan extends Makanan{
    List<BahanMakanan> daftarBahan = new ArrayList<>();
    public Masakan(String nama, int kekenyangan){
        super(nama, kekenyangan);
    }
    
}