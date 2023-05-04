package src;
import java.util.*;
import Items.*;

public class Inventory<T> {

    private Map<T, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public T getItem(String itemName, int quantity) { //pastiin aja kalo itemnya ada di inventory ||  input stringname nya harus sama persis sama nama barangnya beserta juga case sensitive
        for (T item : items.keySet()) {
            if (item instanceof Makanan){
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
            else if (item instanceof NonMakanan){
                if (((NonMakanan) item).getNama().equals(itemName)) {
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
            // if (((Makanan) item).getNama().equals(itemName)) {
            //     int currentQuantity = items.get(item);
            //     if (currentQuantity - quantity == 0) {
            //         items.remove(item);
            //     } else {
            //         items.put(item, currentQuantity - quantity);
            //     }
            //     System.out.println("Item berhasil dihapus dari inventory");
            // return item;
            // }
        }
        System.out.println("Item berhasil tidak dihapus dari inventory");
        return null;
    }

    // public T getItemNonMakanan(String itemName, int quantity){
    //     for (T item : items.keySet()) {
    //         if (((NonMakanan) item).getClass().getSimpleName().equals(itemName)) {
    //             int currentQuantity = items.get(item);
    //             if (currentQuantity - quantity == 0) {
    //                 items.remove(item);
    //             } else {
    //                 items.put(item, currentQuantity - quantity);
    //             }
    //         System.out.println("Item berhasil dihapus dari inventory");
    //         return item;
    //         }
    //     }
    //     System.out.println("Item berhasil tidak dihapus dari inventory");
    //     return null;
    // }

    public boolean checkerItemBahanMakanan(String itemName, int quantity) { //pastiin aja kalo itemnya ada di inventory ||  input stringname nya harus sama persis sama nama barangnya beserta juga case sensitive
        for (T item : items.keySet()) {
            if (((Item) item).getNama().equals(itemName)) {
                System.out.println("Item ada");
            return false;
            }
        }
        System.out.println("Item tidak ada");
        return true;
    }

    public void addItem(T item, int quantity) {
        boolean unique = true;
        for (T xT : items.keySet()) {
            if (item instanceof Makanan && xT instanceof Makanan) {
                if (((Makanan) item).getNama().equals(((Makanan) xT).getNama())) {
                    int currentQuantity = items.get(xT);
                    items.remove(xT);
                    items.put(xT, currentQuantity + quantity);
                    return;
                }
            }
            else if (item instanceof NonMakanan && xT instanceof NonMakanan) {
                if (((NonMakanan) item).getClass().getSimpleName().equals(((NonMakanan) xT).getClass().getSimpleName())) {
                    if (item instanceof Kasur){
                        if (((Kasur) item).getNama().equals(((Kasur) xT).getNama())){
                            int currentQuantity = items.get(xT);
                            items.remove(xT);
                            items.put(xT, currentQuantity + quantity);
                            return;
                        }
                    }
                    else if (item instanceof Kompor){
                        if (((Kompor) item).getNama().equals(((Kompor) xT).getNama())){
                            int currentQuantity = items.get(xT);
                            items.remove(xT);
                            items.put(xT, currentQuantity + quantity);
                            return;
                        }
                    }
                    
                    else{
                        int currentQuantity = items.get(xT);
                        items.remove(xT);
                        items.put(xT, currentQuantity + quantity);
                        return;
                    }
                }
            }
        }
        if (unique) {
            items.put(item, quantity);
        }
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

    public void removeItemNonMakanan(String itemName, int quantity){
        boolean ketemu = false;
        for (T item : items.keySet()) {
            if (((NonMakanan) item).getClass().getSimpleName().equals(itemName)) {
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