package ese.zoo;

import java.util.ArrayList;
import java.util.List;

public class Item {
    String itemName;
    String description;
    int slotsRequired;
    static List<Item> itemAvailable = new ArrayList<>();

    public Item(String itemName, String description, int slotsRequired) {
        this.itemName = itemName;
        this.description = description;
        this.slotsRequired = slotsRequired;
    }
    public String getItemName() {
        return itemName;
    }

    public void getItem (String itemName) {
        boolean found = false;
        for (Item item : itemAvailable) {
            if (item.getItemName().equals(itemName)) {
                itemAvailable.add(item);
                System.out.println(getItemName() + " Added");
                found = true;
            }
        }
    }
    public String getDescription() {
        return description;
    }
    public int getSlotsRequired() {
        return slotsRequired;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setSlotsRequired(int slotsRequired) {
        this.slotsRequired = slotsRequired;
    }

    public String toString() {
        return "•" + itemName + " ----- " + description + " ----- slots required: " + slotsRequired;
    }

}
