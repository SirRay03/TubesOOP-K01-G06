import java.util.*;

public class Rumah{
    private Ruangan[][] denahRumah;
    private int roomCount;
    
    public Rumah(){
        denahRumah = new Ruangan[21][21];
        denahRumah[11][11] = new Ruangan("Kamar Utama");
        roomCount = 1;
    }

    public void upgradeRumah(Sim s){
        if (s.getUang() >= 1500){
            int posX = 11;
            int posY = 11;
            if (roomCount > 1){
                System.out.println("Pilih ruangan acuan:");
                for (int i = 0; i < 21; i++){
                    for (int j = 0; j < 21; j++){
                        if (denahRumah[i][j] != null){
                            System.out.println("Ruangan " + denahRumah[i][j].getNamaRuangan() + " di posisi (" + i + "," + j + ")");
                        }
                    }
                }
                Scanner input = new Scanner(System.in);
                String namaRuangan = input.nextLine();
                for (int i = 0; i < 21; i++){
                    for (int j = 0; j < 21; j++){
                        if (denahRumah[i][j] != null){
                            if (denahRumah[i][j].getNamaRuangan().equals(namaRuangan)){
                                posX = i;
                                posY = j;
                            }
                        }
                    }
                }
                input.close();
            }
            System.out.println("Pilih arah ruangan yang ingin ditambahkan:");
            System.out.println("1. Atas");
            System.out.println("2. Bawah");
            System.out.println("3. Kiri");
            System.out.println("4. Kanan");
            Scanner input = new Scanner(System.in);
            int arah = input.nextInt();
            System.out.println("Masukkan nama ruangan yang ingin ditambahkan:");
            input = new Scanner(System.in);
            String namaRuangan = input.nextLine();
            if (arah == 1){
                if (denahRumah[posX][posY+1] == null){
                    posY++;
                    s.setUang(s.getUang() - 1500);
                }
                else{
                    System.out.println("Ruangan sudah ada!");
                }
            }
            else if (arah == 2){
                if (denahRumah[posX][posY-1] == null){
                    posY--;
                    s.setUang(s.getUang() - 1500);
                }
                else{
                    System.out.println("Ruangan sudah ada!");
                }
            }
            else if (arah == 3){
                if (denahRumah[posX-1][posY] == null){
                    posX--;
                    s.setUang(s.getUang() - 1500);
                }
                else{
                    System.out.println("Ruangan sudah ada!");
                }
            }
            else if (arah == 4){
                if (denahRumah[posX+1][posY] == null){
                    posX++;
                    s.setUang(s.getUang() - 1500);
                }
                else{
                    System.out.println("Ruangan sudah ada!");
                }
            }
            else{
                System.out.println("Input salah!");
            }
            System.out.println("Apakah anda yakin ingin menambah ruangan " + namaRuangan + "? Proses ini akan memakan waktu 18 menit.");
            System.out.println("1. Ya");
            System.out.println("2. Tidak");
            input = new Scanner(System.in);
            int pilihan = input.nextInt();
            
            if (pilihan == 1){
                denahRumah[posX][posY] = new Ruangan(namaRuangan);
                roomCount++;
                System.out.println("Ruangan " + namaRuangan + " berhasil ditambahkan!");
            }
            else if (pilihan == 2){
                System.out.println("Ruangan " + namaRuangan + " dibatalkan!");
            }
            else{
                System.out.println("Input salah!");
            }
        }
        else {
            System.out.println("Uang tidak cukup!");
        }
    }

    public void pindahRuangan(Sim s){
        System.out.println("Pilih ruangan yang ingin dipilih:");
        for (int i = 0; i < 21; i++){
            for (int j = 0; j < 21; j++){
                if (denahRumah[i][j] != null){
                    System.out.println("Ruangan " + denahRumah[i][j].getNamaRuangan() + " di posisi (" + i + "," + j + ")");
                }
            }
        }
        Scanner input = new Scanner(System.in);
        String namaRuangan = input.nextLine();
        for (int i = 0; i < 21; i++){
            for (int j = 0; j < 21; j++){
                if (denahRumah[i][j] != null){
                    if (denahRumah[i][j].getNamaRuangan().equals(namaRuangan)){
                        s.setPosisiX(i);
                        s.setPosisiY(j);
                    }
                }
            }
        }
        input.close();
    }

    public void currentLoc(Sim s){
        System.out.println("Anda saat ini berada di ruangan " + denahRumah[s.getPosisiX()][s.getPosisiY()].getNamaRuangan());
    }
}