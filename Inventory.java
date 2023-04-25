import java.util.*;

public class Inventory {
    private Map<String, Integer> items;

    // konstruktor
    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(String itemName, int quantity) {
        if (this.items.containsKey(itemName)) {
            int currentQuantity = this.items.get(itemName);
            this.items.put(itemName, currentQuantity + quantity);
        } else {
            this.items.put(itemName, quantity);
        }
    }

    public void removeItem(String itemName, int quantity) {
        if (this.items.containsKey(itemName)) {
            int currentQuantity = this.items.get(itemName);
            if (currentQuantity > quantity) {
                this.items.put(itemName, currentQuantity - quantity);
            } else if (currentQuantity == quantity) {
                this.items.remove(itemName);
            } else {
                System.out.println("Jumlah item yang ingin dihapus melebihi jumlah item yang tersedia");
            }
        } else {
            System.out.println("Item tidak ditemukan dalam inventory");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (String itemName : this.items.keySet()) {
            int quantity = this.items.get(itemName);
            System.out.println("- " + itemName + ": " + quantity);
        }
    }

    // public static void main(String[] args) {
    //     Inventory inventory = new Inventory();
    //     Scanner scanner = new Scanner(System.in);

    //     while (true) {
    //         System.out.println("Masukkan perintah (add/remove/exit):");
    //         String command = scanner.next();

    //         if (command.equalsIgnoreCase("add")) {
    //             System.out.println("Masukkan nama item:");
    //             String itemName = scanner.next();

    //             System.out.println("Masukkan jumlah item:");
    //             int quantity = scanner.nextInt();

    //             inventory.addItem(itemName, quantity);
    //             System.out.println("Item berhasil ditambahkan ke inventory.");
    //         } else if (command.equalsIgnoreCase("remove")) {
    //             System.out.println("Masukkan nama item:");
    //             String itemName = scanner.next();

    //             System.out.println("Masukkan jumlah item:");
    //             int quantity = scanner.nextInt();

    //             inventory.removeItem(itemName, quantity);
    //             System.out.println("Item berhasil dihapus dari inventory.");
    //         } else if (command.equalsIgnoreCase("exit")) {
    //             break;
    //         } else {
    //             System.out.println("Perintah tidak dikenali.");
    //         }
            
    //         System.out.println("Isi Inventory:");
    //         inventory.displayInventory();
    //         System.out.println();
    //     }
    //     scanner.close();
    // }
}
