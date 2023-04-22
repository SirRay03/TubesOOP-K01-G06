import java.util.ArrayList;

public class Inventory {
    private static ArrayList<String> objects;

    //Konstruktor 

    public Inventory () {
        objects = new ArrayList<String>();
    }

    public String melihatInventory () {
        String output = "";
        for (String objek : objects) {
            output += objek + "\n";
        }
        return output;
    }

    public void addObjek (String objek) {
        objects.add(objek);
    }

    public void buangObjek (String objek) {
        objects.remove(objek);
    }

    public void kurangiJumlahObjek (String objek) {
        int index = objects.indexOf(objek);
        if (index >= 0) {
            int jumlah = Integer.parseInt(objects.get(index+1));
            jumlah--;
            if (jumlah <= 0) {
                objects.remove(index);
                objects.remove(index);
            } else {
                objects.set(index+1, Integer.toString(jumlah));
            }
        }
    }

    public void tambahJumlahObjek (String objek, int jumlah) {
        int index = objects.indexOf(objek);
        if (index >= 0) {
            int jumlahLama = Integer.parseInt(objects.get(index+1));
            int jumlahBaru = jumlahLama + jumlah;
            objects.set(index+1, Integer.toString(jumlahBaru));
        } else {
            objects.add(objek);
            objects.add(Integer.toString(jumlah));
        }
    }
}
