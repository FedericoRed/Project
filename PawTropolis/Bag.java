package ese.zoo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ese.zoo.Item.itemAvailable;


public class Bag {
    private final int capacity = 5;
    List<Item> itemsBag = new ArrayList<>();

    private int occupiedSpace;
    Scanner scanner = new Scanner(System.in);

    public Bag(String name, String description, int slotsRequired) {

    }

    public void getItemBag(String itemName, Room room) {
        boolean found = false;
        for (Item item : room.getItemInRoom(itemName, room)) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemsBag.add(item);
                occupiedSpace = occupiedSpace + item.getSlotsRequired();
                if (occupiedSpace > capacity) {
                    System.out.println("The bag is full");
                    itemsBag.remove(item);
                    occupiedSpace = occupiedSpace - item.getSlotsRequired();
                } else {
                    System.out.println(item.getItemName()+" added");
                    room.removeItemRoom(item);
                    found = true;
                }
            }
        }
        if (found == false) {
            System.out.println("Item not found in room");
        }
    }


    public void  dropItemBag (String itemName, Room room) {
        for (Item item : itemAvailable) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemsBag.remove(item);
                occupiedSpace = occupiedSpace - item.getSlotsRequired();
                System.out.println(item.getItemName()+" removed");
                room.addItemInRoom(item);
            }
        }
    }

    public boolean dropKey (String itemChose){
        for (Item item : itemsBag) {
            if (item.getItemName().equalsIgnoreCase(itemChose)) {
                itemsBag.remove(item);
                occupiedSpace = occupiedSpace - item.getSlotsRequired();
                System.out.println(item.getItemName()+" removed and door is open");
                return true;
            }
        }
        System.out.println("you don't have this item");
        return false;
    }



    @Override
    public String toString() {
        if (itemsBag.size() == 0) {
            return "The bag is empty";
        } else {
            String s = "in bag: \n";
            for (Item i :itemsBag) {
                s += i.toString() + "\n";
            }
            s = s + "occupied space in the backpack: " + occupiedSpace;
            return s;
        }
    }

}

