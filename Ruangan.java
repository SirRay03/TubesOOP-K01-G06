import java.util.ArrayList;
import java.util.List;

public class Ruangan {
    private int panjang;
    private int lebar;
    private List<NonMakanan> listBarang;
    private NonMakanan[][] matriksPemetaan;
    
    public Ruangan (){
        this.panjang = 6;
        this.lebar = 6;
        this.listBarang = new ArrayList<>(); 
        this.matriksPemetaan = new NonMakanan[panjang][lebar];
        for(int i = 0; i < panjang; i++){
            for(int j = 0; j < lebar; j++){
                matriksPemetaan[i][j] = null;
            }
        }
    }
    
    public void memasangBarang (NonMakanan barang,int x,int y){
        //Cek apakah melewati ruangan atau tidak
        if(barang.getPanjang() + x <= 6 && barang.getPanjang() + x >=0 && barang.getLebar() <= 6 && barang.getLebar() + x >=0){
            boolean cekMatriks;
            cekMatriks = true;
            for (int i = x-1; i < barang.getPanjang() + x; i++){
                for(int j = y-1; j <barang.getLebar() + y ; j++){
                    if( matriksPemetaan[i][j] != null) {
                        cekMatriks = false;
                    }
                }
            }
            if(cekMatriks){
                for (int i = x-1; i < barang.getPanjang() + x; i++){
                    for(int j = y-1; j <barang.getLebar() + y ; j++){
                        matriksPemetaan[i][j] = barang;
                    }
                }
                listBarang.add(barang);
            }
            else{
                System.out.println("Ada objek lain");
            }
        }
        else{
            System.out.println("Objek melewati ruangan");
        }
    }
    
    public void listObjek (List<NonMakanan> listBarang){
        int i =1;
        for (NonMakanan a : listBarang){
            System.out.print(i + ". ");
            System.out.println(a);
            i++;
        }
    }      
}
