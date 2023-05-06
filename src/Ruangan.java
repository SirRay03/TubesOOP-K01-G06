package src;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
            Kasur kasur = new Kasur(Kasur.tipeKasur.Kecil);
            Kompor kompor = new Kompor(Kompor.tipeKompor.Sedang);
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
    
    public void setMatriksPemetaan(NonMakanan[][] matriksPemetaan){
        this.matriksPemetaan = matriksPemetaan;
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
                /*
                while(barang.getPanjang() < barang.getLebar()){
                    rotate(barang);
                }*/
            }
            else{
                System.out.println("Ada objek lain");
            }
        }
        else{
            System.out.println("Objek melewati ruangan");
        }
    }

    public NonMakanan[] toPropArray(){
        NonMakanan[] prop = new NonMakanan[36];
        int k = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                prop[k] = matriksPemetaan[i][j];
                k++;
            }
        }
        return prop;
    }

    public List<NonMakanan> getListObjek(){
        return listBarang;
    }

    public NonMakanan[][] getMatriksPemetaan(){
        return matriksPemetaan;
    }

    public String getNamaRuangan(){
        return nama;
    }

    public void setNamaRuangan(String nama){
        this.nama = nama;
    }

    public void mengambilBarang(String barang,Sim sim){
        NonMakanan barangDiambil = null;
        for(NonMakanan item : listBarang){
            if(item.getClass().getSimpleName().equals(barang)){
                barangDiambil = item;
            }
        }
        if(barangDiambil != null){
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 6; j++){
                    if(matriksPemetaan[i][j] == barangDiambil){
                        matriksPemetaan[i][j] = null;
                    }
                }
            }
        }
        listBarang.remove(barangDiambil);
        sim.getInventory().addItem(barangDiambil, 1);
    }

    public boolean memasangBarang (NonMakanan barang,int x,int y,Sim sim){
        //Cek apakah melewati ruangan atau tidak
        boolean isPlaced = false;
        boolean cek = false;

        for (NonMakanan[] a : matriksPemetaan) {
            for (NonMakanan b : a) {
                if (b != null) {
                    if (b.getClass().getSimpleName().equals(barang.getClass().getSimpleName())) {
                        cek = true;
                    }
                }
            }
        }

        if(cek){
            JOptionPane.showMessageDialog(null,"Sudah ada furniture yang sama di ruangan ini", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Sudah ada furniture yang sama di ruangan ini");
        }
        else if(barang.getPanjang() + x <= 6 && barang.getPanjang() + x >=0 && barang.getLebar() +y <= 6 && barang.getLebar() + y >=0){
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
                    sim.getInventory().removeItemNonMakanan(jam.getClass().getSimpleName(),1); 
                }
                else if(barang instanceof Kaca){
                    Kaca kaca = (Kaca) barang;
                    listBarang.add(kaca);
                    sim.getInventory().removeItemNonMakanan(kaca.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kasur){
                    Kasur kasur = (Kasur) barang;
                    listBarang.add(kasur);
                    sim.getInventory().removeItemNonMakanan(kasur.getNama(),1);
                }
                else if(barang instanceof Kertas){
                    Kertas kertas = (Kertas) barang;
                    listBarang.add(kertas);
                    sim.getInventory().removeItemNonMakanan(kertas.getClass().getSimpleName(),1);
                }
                else if(barang instanceof MejaKursi){
                    MejaKursi mejaKursi = (MejaKursi) barang;
                    listBarang.add(mejaKursi);
                    sim.getInventory().removeItemNonMakanan(mejaKursi.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Toilet){
                    Toilet toilet = (Toilet) barang;
                    listBarang.add(toilet);
                    sim.getInventory().removeItemNonMakanan(toilet.getClass().getSimpleName(),1);
                }
                else if(barang instanceof Kompor){
                    Kompor kompor = (Kompor) barang;
                    listBarang.add(kompor);
                    sim.getInventory().removeItemNonMakanan(kompor.getNama(),1);
                }
                /*
                while(barang.getPanjang() < barang.getLebar()){
                    rotate(barang);
                }*/
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
    
/*
    public void rotate(NonMakanan barang){
        int temp;
        temp = barang.getLebar();
        barang.setLebar(barang.getPanjang());
        barang.setPanjang(temp);
    }   
*/
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
    
}     