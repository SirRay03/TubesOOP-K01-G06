import java.util.*;

public class Inventory<T> {

    private Map<T, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(T item, int quantity) {
        if (items.containsKey(item)) {
            quantity += items.get(item);
        }
        items.put(item, quantity);
    }

    public void getItem(T item, int quantity) {
        if (items.containsKey(item)) {
            int currentQuantity = items.get(item);
            if (currentQuantity - quantity <= 0) {
                items.remove(item);
            } else {
                items.put(item, currentQuantity - quantity);
            }
        }
        System.out.println(item);
    }

    public void printInventory() {
        for (T item : items.keySet()) {
            System.out.println(item.toString() + ": " + items.get(item));
        }
    }

    // public static void main(String[] args) {
    //     Inventory<String> inventory = new Inventory<>();
    //     Scanner scanner = new Scanner(System.in);

    //     boolean exit = false;

    //     while (!exit) {
    //         System.out.println("1. Add Item");
    //         System.out.println("2. Get Item");
    //         System.out.println("3. Print Inventory");
    //         System.out.println("4. Exit");
    //         System.out.print("Choose option: ");
    //         int choice = scanner.nextInt();
    //         scanner.nextLine(); // consume the newline character

    //         switch (choice) {
    //             case 1:
    //                 System.out.print("Enter item name: ");
    //                 String item = scanner.nextLine();
    //                 System.out.print("Enter quantity: ");
    //                 int quantity = scanner.nextInt();
    //                 inventory.addItem(item, quantity);
    //                 break;
    //             case 2:
    //                 System.out.print("Enter item name: ");
    //                 item = scanner.nextLine();
    //                 System.out.print("Enter quantity: ");
    //                 quantity = scanner.nextInt();
    //                 inventory.getItem(item, quantity);
    //                 break;
    //             case 3:
    //                 inventory.printInventory();
    //                 break;
    //             case 4:
    //                 exit = true;
    //                 break;
    //             default:
    //                 System.out.println("Invalid choice!");
    //                 break;
    //         }
    //     }
    // scanner.close();
    // }
}
