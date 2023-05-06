package src;
import javax.swing.*;

public class Rumah{
    private Ruangan[][] denahRumah;
    private int roomCount;
    private Sim owner;
    private int waktuUpgrade;
    private int waktuMulai;
    private int hariMulai;
    private int hAddress;
    private int vAddress;
    
    public Rumah(){
        denahRumah = new Ruangan[21][21];
        denahRumah[11][11] = new Ruangan("Kamar Utama");
        roomCount = 1;
        owner = null;
        waktuMulai = 0;
        waktuUpgrade = 5;
        hAddress = 0;
        vAddress = 0;
        hariMulai = 0;
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

    public Ruangan searchRuangan(String nama){
        for (int i = 0; i < 21; i++){
            for (int j = 0; j < 21; j++){
                if (denahRumah[i][j] != null){
                    if (denahRumah[i][j].getNamaRuangan().equals(nama)){
                        return denahRumah[i][j];
                    }
                }
            }
        }
        return null;
    }

    public Ruangan[][] getDenahRumah(){
        return denahRumah;
    }

    public int getWaktuMulai(){
        return waktuMulai;
    }

    public int getHariMulai(){
        return hariMulai;   
    }

    public int getWaktuUpgrade(){
        return waktuUpgrade;
    }

    public void setOwner(Sim owner){
        this.owner = owner;
    }

    public int getHAddress(){
        return hAddress;
    }

    public int getVAddress(){
        return vAddress;
    }

    public void setHAddress(int hAddress){
        this.hAddress = hAddress;
    }

    public void setVAddress(int vAddress){
        this.vAddress = vAddress;
    }

    public Sim getOwner(){
        return owner;
    }

    public void upgradeRumah(Sim sim){
        World world = World.getInstance();
        if (sim.getUang() >= 1500 && sim == owner){
            int horizontal = 11;
            int vertical = 11;
            if (roomCount > 1){
                String[] roomNames = getRoomNames();
                String selectedRoom = (String) JOptionPane.showInputDialog(null, "Pilih ruangan acuan:", "Upgrade Ruangan", JOptionPane.QUESTION_MESSAGE, null, roomNames, roomNames[0]);
                for (int i = 0; i < 21; i++){
                    for (int j = 0; j < 21; j++){
                        if (selectedRoom.equals("Under Construction")){
                            JOptionPane.showMessageDialog(null, "Ruangan masih dalam konstruksi!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        else if (selectedRoom.equals("null")){
                            return;
                        }
                        else if (denahRumah[i][j] != null && selectedRoom.equals(denahRumah[i][j].getNamaRuangan())){
                            horizontal = i;
                            vertical = j;
                        }
                    }
                }
            }
            boolean isValid = true;
            String[] opsiArah = {"Atas","Bawah","Kanan","Kiri"};
            String arah = (String) JOptionPane.showInputDialog(null, "Choose room", "Move Room", JOptionPane.QUESTION_MESSAGE, null, opsiArah, opsiArah[0]);
            if (arah == null) return;
            if (arah.equals("Atas")){
                if (denahRumah[horizontal][vertical-1] == null){
                    vertical--;
                    sim.setUang(-1* 1500);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ruangan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                    isValid = false;
                }
            }
            else if (arah.equals("Bawah")){
                if (denahRumah[horizontal][vertical+1] == null){
                    vertical++;
                    sim.setUang(-1* 1500);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ruangan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                    isValid = false;
                }
            }
            else if (arah.equals("Kanan")){
                if (denahRumah[horizontal+1][vertical] == null){
                    horizontal++;
                    sim.setUang(-1* 1500);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ruangan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                    isValid = false;
                }
            }
            else if (arah.equals("Kiri")){
                if (denahRumah[horizontal-1][vertical] == null){
                    horizontal--;
                    sim.setUang(-1* 1500);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ruangan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                    isValid = false;
                }
            }
            else{
                System.out.println("Pilihan tidak valid!");
                isValid = false;
            }
            
            if (isValid){
                String namaRuangan = JOptionPane.showInputDialog("Nama ruangan?: ");
                while (searchRuangan(namaRuangan) != null && !namaRuangan.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nama ruangan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                    namaRuangan = JOptionPane.showInputDialog("Nama ruangan?: ");
                }
                int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menambah ruangan " + namaRuangan + "? Proses ini akan memakan waktu 18 menit.", "Upgrade rumah?", JOptionPane.YES_NO_OPTION);         
                if (pilihan == JOptionPane.YES_OPTION){
                    final int h = horizontal;
                    final int v = vertical;
                    final String nama = namaRuangan;
                    int finalTime = World.getInstance().getTime() + 1080000;
                    Runnable r = () -> {
                        owner.addToListUpgrade(this); 
                        waktuMulai = world.getTime();
                        hariMulai = world.getDay();
                        denahRumah[h][v] = new Ruangan("Under Construction");
                        roomCount++;
                        while (World.getInstance().getTime() <  finalTime){
                                try {
                                    //System.out.format("Barang berhasil dibeli. Silakan tunggu selama %d detik.\n", waktuPengantaran); 
                                    Thread.sleep(1000);
                                    //Thread.sleep(waktuPengantaran*1000);
                                } catch (InterruptedException e) {
                                    System.out.println("Aksi terganggu!");
                                }
                        }
                            denahRumah[h][v] = null; 
                            owner.deleteFromListUpgrade(this);
                            denahRumah[h][v] = new Ruangan(nama);
                            //JANGAN LUPA NGURANGI DUIT
                            JOptionPane.showMessageDialog(null, "Ruangan " + nama + " berhasil ditambahkan!");
                        };
                    Thread thread = new Thread(r);
                    thread.start();
                    // new Thread(() -> {
                    //     try {
                    //         owner.addToListUpgrade(this); 
                    //         waktuMulai = System.currentTimeMillis();
                    //         owner.deleteFromListUpgrade(this);
                    //         Thread.sleep(10000);
                    //         waktuMulai = 0;
                    //         denahRumah[h][v] = new Ruangan(nama);
                    //         roomCount++;
                    //         JOptionPane.showMessageDialog(null, "Ruangan " + nama + " berhasil ditambahkan!");
                    //     } catch (InterruptedException e) {
                    //         System.out.println("Aksi terganggu!");
                    //     }
                    // }).start();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ruangan tidak jadi ditambahkan!", "Upgrade rumah batal!", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Uang anda tidak cukup!", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }
}