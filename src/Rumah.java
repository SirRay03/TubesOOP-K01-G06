package src;
import java.util.*;

import javax.swing.JOptionPane;

public class Rumah{
    private Ruangan[][] denahRumah;
    private int roomCount;
    private int currX;
    private int currY;
    
    public Rumah(){
        denahRumah = new Ruangan[21][21];
        denahRumah[11][11] = new Ruangan("Kamar Utama");
        roomCount = 1;
        currX = 11;
        currY = 11;
    }

    public String[] getRoomNames(){
        String[] roomNames = new String[roomCount];
        int i = 0;
        for (int j = 0; j < 21; j++){
            for (int k = 0; k < 21; k++){
                if (denahRumah[j][k] != null){
                    roomNames[i] = denahRumah[j][k].getNamaRuangan();
                    i++;
                }
            }
        }
        return roomNames;
    }

    public int upgradeRumah(int uang){
        Scanner input = new Scanner(System.in);
        if (uang >= 1500){
            int posX = 11;
            int posY = 11;
            if (roomCount > 1){
                System.out.println("Pilih ruangan acuan:");
                for (String kamar : getRoomNames()){
                    System.out.println(kamar);
                }
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
            }
            String[] opsiArah = {"Atas","Bawah","Kanan","Kiri"};
            String arah = (String) JOptionPane.showInputDialog(null, "Choose room", "Move Room", JOptionPane.QUESTION_MESSAGE, null, opsiArah, opsiArah[0]);
            
            String namaRuangan = JOptionPane.showInputDialog("Nama ruangan?: ");
            
            if (arah.equals("Atas")){
                if (denahRumah[posX][posY-1] == null){
                    posY++;
                    uang -= 1500;
                }
                else{
                    System.out.println("Ruangan sudah ada!");
                }
            }
            else if (arah.equals("Bawah")){
                if (denahRumah[posX][posY+1] == null){
                    posY--;
                    uang -= 1500;
                }
                else{
                    System.out.println("Ruangan sudah ada!");
                }
            }
            else if (arah.equals("Kanan")){
                if (denahRumah[posX+1][posY] == null){
                    posX--;
                    uang -= 1500;
                }
                else{
                    System.out.println("Ruangan sudah ada!");
                }
            }
            else if (arah.equals("Kiri")){
                if (denahRumah[posX-1][posY] == null){
                    posX++;
                    uang -= 1500;
                }
                else{
                    System.out.println("Ruangan sudah ada!");
                }
            }
            else{
                System.out.println("Input salah!");
            }

            int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menambah ruangan " + namaRuangan + "? Proses ini akan memakan waktu 18 menit.", "This is my title", JOptionPane.YES_NO_OPTION);         
            if (pilihan == 0){
                denahRumah[posX][posY] = new Ruangan(namaRuangan);
                roomCount++;
                System.out.println("Ruangan " + namaRuangan + " berhasil ditambahkan!");
            }
            else if (pilihan == 1){
                System.out.println("Ruangan " + namaRuangan + " dibatalkan!");
            }
        }
        else {
            System.out.println("Uang tidak cukup!");
        }
        input.close();
        return uang;
    }

    public void moveRoom(String room){
        for (int i = 0; i < 21; i++){
            for (int j = 0; j < 21; j++){
                if (denahRumah[i][j] != null && denahRumah[i][j].getNamaRuangan().equals(room)){
                    currX = i;
                    currY = j;
                }
            }
        }
    }

    public String currentLoc(){
        return ("Anda saat ini berada di ruangan " + denahRumah[currX][currY].getNamaRuangan());
    }
}
    
    // public void pindahRuangan(Sim s){
    //     System.out.println("Pilih ruangan yang ingin dipilih:");
    //     for (int i = 0; i < 21; i++){
    //         for (int j = 0; j < 21; j++){
    //             if (denahRumah[i][j] != null){
    //                 System.out.println("Ruangan " + denahRumah[i][j].getNamaRuangan() + " di posisi (" + i + "," + j + ")");
    //             }
    //         }
    //     }
    //     Scanner input = new Scanner(System.in);
    //     String namaRuangan = input.nextLine();
    //     for (int i = 0; i < 21; i++){
    //         for (int j = 0; j < 21; j++){
    //             if (denahRumah[i][j] != null){
    //                 if (denahRumah[i][j].getNamaRuangan().equals(namaRuangan)){
    //                     s.setPosisiX(i);
    //                     s.setPosisiY(j);
    //                 }
    //             }
    //         }
    //     }
    //     input.close();
    // }

    
//     //DRIVER
//     public static void main(String[] args){
//         Rumah r = new Rumah();
//         Sim s = new Sim("Budi", "Gunawarman");
//         int pilihan = 0;

//         Scanner inputDriver = new Scanner(System.in);
//         boolean exit = false;
//         while (!exit) {
//             System.out.println("1. Upgrade rumah");
//             System.out.println("2. Pindah ruangan");
//             System.out.println("3. Lokasi sekarang");
//             System.out.println("4. Keluar");
//             inputDriver.hasNextInt();
//             pilihan = inputDriver.nextInt();
//             inputDriver.nextLine();
//             if (pilihan == 1){
//                 r.upgradeRumah(s);
//             }
//             else if (pilihan == 2){
//                 r.pindahRuangan(s);
//             }
//             else if (pilihan == 3){
//                 r.currentLoc(s);
//             }
//             else if (pilihan == 4){
//                 System.out.println("Terima kasih!");
//             }
//             else{
//                 System.out.println("inputDriver salah!");
//             }
//             inputDriver.close();
//         }
//     }


        
// }