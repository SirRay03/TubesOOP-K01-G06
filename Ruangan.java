import java.util.ArrayList;
import java.util.List;

public class Ruangan {
    private int panjang;
    private int lebar;
    private List<String> listBarang;
    private String[][] matriksPemetaan;
    
    public Ruangan (){
        this.panjang = 6;
        this.lebar = 6;
        this.listBarang = new ArrayList<>(); 
        this.matriksPemetaan = new String [panjang][lebar];
        for(int i = 0; i < panjang; i++){
            for(int j = 0; j < lebar; j++){
                matriksPemetaan[i][j] = null;
            }
        }
    }
    
    public void memasangBarang (NonMakanan barang,int x,int y,Sim sim){
        //Cek apakah melewati ruangan atau tidak
        if(barang.getPanjang() + x <= 6 && barang.getPanjang() + x >=0 && barang.getLebar() <= 6 && barang.getLebar() + x >=0){
            boolean cekMatriks;
            cekMatriks = true;
            for (int i = x; i < barang.getPanjang() + x; i++){
                for(int j = y; j <barang.getLebar() + y ; j++){
                    if( matriksPemetaan[i][j] != null) {
                        cekMatriks = false;
                    }
                }
            }
            if(cekMatriks){
                for (int i = x; i < barang.getPanjang() + x; i++){
                    for(int j = y; j <barang.getLebar() + y ; j++){
                        if(barang instanceof Jam){
                            Jam jam = (Jam) barang;
                            matriksPemetaan[i][j] = jam.getClass().getSimpleName();
                        }
                        else if(barang instanceof Kaca){
                            Kaca kaca = (Kaca) barang;
                            matriksPemetaan[i][j] = kaca.getClass().getSimpleName();
                        }
                        else if(barang instanceof Kasur){
                            Kasur kasur = (Kasur) barang;
                            matriksPemetaan[i][j] = kasur.getClass().getSimpleName();
                        }
                        else if(barang instanceof Kertas){
                            Kertas kertas = (Kertas) barang;
                            matriksPemetaan[i][j] = kertas.getClass().getSimpleName();
                        }
                        else if(barang instanceof MejaKursi){
                            MejaKursi mejaKursi = (MejaKursi) barang;
                            matriksPemetaan[i][j] = mejaKursi.getClass().getSimpleName();
                        }
                        else if(barang instanceof Toilet){
                            Toilet toilet = (Toilet) barang;
                            matriksPemetaan[i][j] = toilet.getClass().getSimpleName();
                        }
                        else if(barang instanceof Kompor){
                            Kompor kompor = (Kompor) barang;
                            matriksPemetaan[i][j] = kompor.getClass().getSimpleName();
                        }
                    }
                }
                if(barang instanceof Jam){
                    Jam jam = (Jam) barang;
                    listBarang.add(jam.getClass().getSimpleName());
                    sim.getinventory().removeItem(jam.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kaca){
                    Kaca kaca = (Kaca) barang;
                    listBarang.add(kaca.getClass().getSimpleName());
                    sim.getinventory().removeItem(kaca.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kasur){
                    Kasur kasur = (Kasur) barang;
                    listBarang.add(kasur.getClass().getSimpleName());
                    sim.getinventory().removeItem(kasur.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kertas){
                    Kertas kertas = (Kertas) barang;
                    listBarang.add(kertas.getClass().getSimpleName());
                    sim.getinventory().removeItem(kertas.getClass().getSimpleName(),1);
                }
                else if(barang instanceof MejaKursi){
                    MejaKursi mejaKursi = (MejaKursi) barang;
                    listBarang.add(mejaKursi.getClass().getSimpleName());
                    sim.getinventory().removeItem(mejaKursi.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Toilet){
                    Toilet toilet = (Toilet) barang;
                    listBarang.add(toilet.getClass().getSimpleName());
                    sim.getinventory().removeItem(toilet.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kompor){
                    Kompor kompor = (Kompor) barang;
                    listBarang.add(kompor.getClass().getSimpleName());
                    sim.getinventory().removeItem(kompor.getClass().getSimpleName(),1);
                }

                while(barang.getPanjang()<0 || barang.getLebar()<0){
                    rotateRight(barang);
                }
            }
            else{
                System.out.println("Ada objek lain");
            }
        }
        else{
            System.out.println("Objek melewati ruangan");
        }
    }
    
    public void listObjek (){
        int i =1;
        for (String a : listBarang){
            System.out.print(i + ". ");
            System.out.println(a);
            i++;
        }
    }
    public void rotateRight(NonMakanan barang){
        int temp;
        temp = barang.getLebar();
        barang.setLebar(barang.getPanjang());
        barang.setPanjang(temp*-1);
    }   
    public void rotateLeft(NonMakanan barang){
        int temp;
        temp = barang.getPanjang();
        barang.setPanjang(barang.getLebar());
        barang.setLebar(temp*-1);
    }    
}
