package src;
import java.util.*;
import Items.*;

public class Inventory<T> {

    private Map<T, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public T getItemBahanMakanan(String itemName, int quantity) { //pastiin aja kalo itemnya ada di inventory ||  input stringname nya harus sama persis sama nama barangnya beserta juga case sensitive
        for (T item : items.keySet()) {
            if (((Makanan) item).getNama().equals(itemName)) {
                int currentQuantity = items.get(item);
                if (currentQuantity - quantity == 0) {
                    items.remove(item);
                } else {
                    items.put(item, currentQuantity - quantity);
                }
                System.out.println("Item berhasil dihapus dari inventory");
            return item;
            }
        }
        System.out.println("Item berhasil tidak dihapus dari inventory");
        return null;
    }

    public void addItem(T item, int quantity) {
        if (items.containsKey(item)) {
            quantity += items.get(item);
        }
        items.put(item, quantity);
    }

    public void removeItem(String itemName, int quantity) { //pastiin aja kalo itemnya ada di inventory ||  input stringname nya harus sama persis sama nama barangnya beserta juga case sensitive
        boolean ketemu = false;
        for (T item : items.keySet()) {
            if (((Makanan) item).getNama().equals(itemName)) {
                int currentQuantity = items.get(item);
                if (currentQuantity - quantity == 0) {
                    items.remove(item);
                } else {
                    items.put(item, currentQuantity - quantity);
                }
            System.out.println("Item berhasil dihapus dari inventory");
            ketemu = true;
            }
            }
            if (ketemu == false){
                System.out.println("Item tidak ditemukan di inventory");
            }
        }

    public void printInventory() {
        for (T item : items.keySet()) {
            System.out.println(item.toString() + ": " + items.get(item));
        }
    }

    public Map<T, Integer> getMap() {
        return items;
    }
}

    //  public static void main(String[] args) {
    //      Inventory<String> inventory = new Inventory<>();
    //      Scanner scanner = new Scanner(System.in);

    //      boolean exit = false;

    //      while (!exit) {
    //          System.out.println("1. Add Item");
    //          System.out.println("2. Get Item");
    //          System.out.println("3. Print Inventory");
    //          System.out.println("4. Exit");
    //          System.out.print("Choose option: ");
    //          int choice = scanner.nextInt();
    //          scanner.nextLine();  //consume the newline character

    //          switch (choice) {
    //              case 1:
    //                  System.out.print("Enter item name: ");
    //                  String item = scanner.nextLine();
    //                  System.out.print("Enter quantity: ");
    //                  int quantity = scanner.nextInt();
    //                  inventory.addItem(item, quantity);
    //                  break;
    //              case 2:
    //                  System.out.print("Enter item name: ");
    //                  item = scanner.nextLine();
    //                  System.out.print("Enter quantity: ");
    //                  quantity = scanner.nextInt();
    //                  inventory.getItem(item, quantity);
    //                  break;
    //              case 3:
    //                  inventory.printInventory();
    //                  break;
    //              case 4:
    //                  exit = true;
    //                  break;
    //              default:
    //                  System.out.println("Invalid choice!");
    //                  break;
    //          }
    //      }
    //  scanner.close();
    //  }
//}
