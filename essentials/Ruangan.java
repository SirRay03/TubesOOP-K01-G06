package essentials;
import java.util.ArrayList;
import java.util.List;

import Items.*;

public class Ruangan {
    private int panjang;
    private int lebar;
    private String nama;
    private List<NonMakanan> listBarang;
    private NonMakanan[][] matriksPemetaan;
    
    public Ruangan (String nama){
        this.nama = nama;
        this.panjang = 6;
        this.lebar = 6;
        this.listBarang = new ArrayList<>(); 
        this.matriksPemetaan = new NonMakanan [panjang][lebar];
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
                            matriksPemetaan[i][j] = jam;
                        }
                        else if(barang instanceof Kaca){
                            Kaca kaca = (Kaca) barang;
                            matriksPemetaan[i][j] = kaca;
                        }
                        else if(barang instanceof Kasur){
                            Kasur kasur = (Kasur) barang;
                            matriksPemetaan[i][j] = kasur;
                        }
                        else if(barang instanceof Kertas){
                            Kertas kertas = (Kertas) barang;
                            matriksPemetaan[i][j] = kertas;
                        }
                        else if(barang instanceof MejaKursi){
                            MejaKursi mejaKursi = (MejaKursi) barang;
                            matriksPemetaan[i][j] = mejaKursi;
                        }
                        else if(barang instanceof Toilet){
                            Toilet toilet = (Toilet) barang;
                            matriksPemetaan[i][j] = toilet;
                        }
                        else if(barang instanceof Kompor){
                            Kompor kompor = (Kompor) barang;
                            matriksPemetaan[i][j] = kompor;
                        }
                    }
                }
                if(barang instanceof Jam){
                    Jam jam = (Jam) barang;
                    listBarang.add(jam);
                    sim.getInventory().removeItem(jam.getClass().getSimpleName(),1); //harus mastiin kalo barangnya emang ada di inventory sebelum dipanggil
                }
                else if(barang instanceof Kaca){
                    Kaca kaca = (Kaca) barang;
                    listBarang.add(kaca);
                    sim.getInventory().removeItem(kaca.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kasur){
                    Kasur kasur = (Kasur) barang;
                    listBarang.add(kasur);
                    sim.getInventory().removeItem(kasur.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kertas){
                    Kertas kertas = (Kertas) barang;
                    listBarang.add(kertas);
                    sim.getInventory().removeItem(kertas.getClass().getSimpleName(),1);
                }
                else if(barang instanceof MejaKursi){
                    MejaKursi mejaKursi = (MejaKursi) barang;
                    listBarang.add(mejaKursi);
                    sim.getInventory().removeItem(mejaKursi.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Toilet){
                    Toilet toilet = (Toilet) barang;
                    listBarang.add(toilet);
                    sim.getInventory().removeItem(toilet.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kompor){
                    Kompor kompor = (Kompor) barang;
                    listBarang.add(kompor);
                    sim.getInventory().removeItem(kompor.getClass().getSimpleName(),1);
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
    public void pindahBarang(NonMakanan barang,int x,int y,Sim sim){
        boolean cekMatriks;
        cekMatriks = true;
        if(barang.getPanjang() + x <= 6 && barang.getPanjang() + x >=0 && barang.getLebar() <= 6 && barang.getLebar() + x >=0){
            for (int i = x; i < barang.getPanjang() + x; i++){
                for(int j = y; j <barang.getLebar() + y ; j++){
                    if( matriksPemetaan[i][j] != null ) {
                        if(matriksPemetaan[i][j] != barang){
                            cekMatriks = false;
                        }
                    }
                }
            }
            if(cekMatriks){
                for (int i = x; i < barang.getPanjang() + x; i++){
                    for(int j = y; j <barang.getLebar() + y ; j++){
                        if( matriksPemetaan[i][j] == barang ) {
                            matriksPemetaan[i][j] = null;                
                        }
                    }
                }
                listBarang.remove(barang);
                sim.getInventory().addItem(barang,1);
                memasangBarang(barang, x, y,sim);
            }
            else{
                System.out.println("Ada objek lain");
            }
        }
        else{
            System.out.println("Objek gagal dipindahkan karena melewati batas ruangan");
        }
    }
    
    public void getListObjek (){
        int i =1;
        for (NonMakanan a : listBarang){
            System.out.print(i + ". ");
            System.out.println(a.getClass().getSimpleName());
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

    public String getNamaRuangan(){
        return nama;
    }

    public void setNamaRuangan(String nama){
        this.nama = nama;
    }
}