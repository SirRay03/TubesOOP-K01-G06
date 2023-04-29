package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        if(this.nama =="Kamar Utama"){
            Kasur kasur = new Kasur(Kasur.tipeKasur.Single);
            Kompor kompor = new Kompor(Kompor.tipeKompor.Gas);
            MejaKursi mejaKursi = new MejaKursi();
            Toilet toilet = new Toilet();
            Jam jam =new Jam();
            memasangBarangAwal(kasur, 3, 1);
            memasangBarangAwal(kompor, 1, 1);
            memasangBarangAwal(mejaKursi, 1, 3);
            memasangBarangAwal(toilet, 1, 6);
            memasangBarangAwal(jam, 6, 6);    
        }
    }

    private void memasangBarangAwal(NonMakanan barang, int x, int y){
        if(barang.getPanjang() + x-1 <= 6 && barang.getPanjang() + x-1 >=0 && barang.getLebar()+y-1 <= 6 && barang.getLebar() + y-1 >=0){
            boolean cekMatriks;
            cekMatriks = true;
            for (int i = x-1; i < barang.getPanjang() + x-1; i++){
                for(int j = y-1; j <barang.getLebar() + y-1 ; j++){
                    if( matriksPemetaan[i][j] != null) {
                        cekMatriks = false;
                    }
                }
            }
            if(cekMatriks){
                for (int i = x-1; i < barang.getPanjang() + x-1; i++){
                    for(int j = y-1; j <barang.getLebar() + y-1 ; j++){
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
                }
                else if(barang instanceof Kaca){
                    Kaca kaca = (Kaca) barang;
                    listBarang.add(kaca);
                }
                else if(barang instanceof Kasur){
                    Kasur kasur = (Kasur) barang;
                    listBarang.add(kasur);
                }
                else if(barang instanceof Kertas){
                    Kertas kertas = (Kertas) barang;
                    listBarang.add(kertas);
                }
                else if(barang instanceof MejaKursi){
                    MejaKursi mejaKursi = (MejaKursi) barang;
                    listBarang.add(mejaKursi);
                }
                else if(barang instanceof Toilet){
                    Toilet toilet = (Toilet) barang;
                    listBarang.add(toilet);
                }
                else if(barang instanceof Kompor){
                    Kompor kompor = (Kompor) barang;
                    listBarang.add(kompor);
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

    public void printListObjek (){
        int i =1;
        for (NonMakanan a : listBarang){
            System.out.print(i + ". ");
            System.out.println(a.getClass().getSimpleName());
            i++;
        }
    }

    public List<NonMakanan> getListObjek(){
        return listBarang;
    }

    public String getNamaRuangan(){
        return nama;
    }

    public void setNamaRuangan(String nama){
        this.nama = nama;
    }

    public boolean memasangBarang (NonMakanan barang,int x,int y,Sim sim){
        //Cek apakah melewati ruangan atau tidak
        boolean isPlaced = false;
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
                }
                else if(barang instanceof Kaca){
                    Kaca kaca = (Kaca) barang;
                    listBarang.add(kaca);
                }
                else if(barang instanceof Kasur){
                    Kasur kasur = (Kasur) barang;
                    listBarang.add(kasur);
                }
                else if(barang instanceof Kertas){
                    Kertas kertas = (Kertas) barang;
                    listBarang.add(kertas);
                }
                else if(barang instanceof MejaKursi){
                    MejaKursi mejaKursi = (MejaKursi) barang;
                    listBarang.add(mejaKursi);
                }
                else if(barang instanceof Toilet){
                    Toilet toilet = (Toilet) barang;
                    listBarang.add(toilet);
                }
                else if(barang instanceof Kompor){
                    Kompor kompor = (Kompor) barang;
                    listBarang.add(kompor);
                }

                while(barang.getPanjang()<0 || barang.getLebar()<0){
                    rotateRight(barang);
                }
                isPlaced= true;
            }
            else{
                System.out.println("Ada objek lain");
            }
        }
        else{
            System.out.println("Objek melewati ruangan");
        }
        return isPlaced;
    }
    public boolean pindahBarang(NonMakanan barang,int x,int y,Sim sim){
        boolean cekMatriks;
        boolean isPlaced;

        cekMatriks = true;
        isPlaced = false;
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
                isPlaced = true;
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
        return isPlaced;
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

    public String[] getObjekNames(){
        String[] objekNames = new String[listBarang.size()];
        for(int i = 0; i < listBarang.size(); i++){
            objekNames[i] = listBarang.get(i).getClass().getSimpleName();
        }
        return objekNames;
    }

    public NonMakanan searchObjek(String namaObjek){
        NonMakanan objek = null;
        for(int i = 0; i < listBarang.size(); i++){
            if(listBarang.get(i).getClass().getSimpleName().equals(namaObjek)){
                objek = listBarang.get(i);
            }
        }
        return objek;
    }
    public static void main(String[] args){
        Sim sim = new Sim("Ayam", "Goreng");
        Kasur kasurTes = new Kasur(Kasur.tipeKasur.Single);
        Scanner scan =new  Scanner(System.in);  
        Ruangan ruangan = new Ruangan("Kamar");
        String input ="";
        sim.getInventory().addItem(kasurTes, 1); 
        //Memasang barang
        NonMakanan barang = ((NonMakanan)sim.getInventory().getItemBahanMakanan("Kasur", 1));
        boolean sukses = ruangan.memasangBarang(barang, 1, 1, sim);//rentang kordinatnya 1-6;
        while(!sukses && !input.equals("Gak Jadi") ){
            input = scan.nextLine();
            if(input.equals("Gak Jadi")){
                while(barang.getPanjang()<0 || barang.getLebar()<0){
                    ruangan.rotateRight(barang);
                }
                if(barang instanceof Jam){
                    Jam jam = (Jam) barang;
                    sim.getInventory().addItem(jam, 1);
                }
                else if(barang instanceof Kaca){
                    Kaca kaca = (Kaca) barang;
                    sim.getInventory().addItem(kaca, 1);
                }
                else if(barang instanceof Kasur){
                    Kasur kasur = (Kasur) barang;
                    sim.getInventory().addItem(kasur, 1);
                }
                else if(barang instanceof Kertas){
                    Kertas kertas = (Kertas) barang;
                    sim.getInventory().addItem(kertas, 1);
                }
                else if(barang instanceof MejaKursi){
                    MejaKursi mejaKursi = (MejaKursi) barang;
                    sim.getInventory().addItem(mejaKursi, 1);
                }
                else if(barang instanceof Toilet){
                    Toilet toilet = (Toilet) barang;
                    sim.getInventory().addItem(toilet, 1);
                }
                else if(barang instanceof Kompor){
                    Kompor kompor = (Kompor) barang;
                    sim.getInventory().addItem(kompor, 1);
                }
            }
            else if(input.equals("rotate kanan")){
                ruangan.rotateRight(barang);
                sukses = ruangan.memasangBarang(barang, 1, 1, sim);
            }
            else if(input.equals("rotate kiri")){
                ruangan.rotateLeft(barang);
                sukses = ruangan.memasangBarang(barang, 1, 1, sim);
            }
        }
        //Pindah barang
        sukses = ruangan.pindahBarang(barang, 2,2 , sim);
        
        scan.close();
        
    }  
}

       