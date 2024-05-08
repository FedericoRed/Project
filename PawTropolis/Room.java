package ese.zoo;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class Room {
    String roomName;
    public List<Item> itemPresent = new ArrayList<>();
    public List<GenericAnimal> animalsPresent = new ArrayList<>();
    public EnumMap<Direction, Room> adjacentRoom = new EnumMap<>(Direction.class);
    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;
    private boolean isClosed;
    Scanner scanner = new Scanner(System.in);

    public Room (String roomName) {
        this.roomName = roomName;
        this.northRoom = null ;
        this.eastRoom = null;
        this.southRoom = null;
        this.westRoom = null;
        this.isClosed = false;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setClosed (boolean isClosed) {
        this.isClosed = isClosed;
    }

    public boolean getIsClosed() {
        return this.isClosed;
    }

    public void addItemInRoom(Item item) {
        itemPresent.add(item);
    }

    public void addAnimalInRoom(GenericAnimal animals){
        animalsPresent.add(animals);
    }

    public void removeItemRoom(Item item) {
        itemPresent.remove(item);
    }


    public List<Item> getItemInRoom (String itemName, Room room) {
        List<Item> items = new ArrayList<>();
        for (Item item : room.itemPresent) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                items.add(item);
            }
        }
        return items;
    }


    public String toString () {
        String s = "\033[31mroom " + getRoomName() + ":\033[0m\nITEM: \n";
        for (Item i : itemPresent) {
            s += i.toString() + "\n";
        }
        for (GenericAnimal i : animalsPresent) {
            s += i.toString() + "\n";
        }
        return s;
    }

    public Room collegamentoRoom(Room room, Direction direction) {
        if (this.adjacentRoom.containsKey(direction)) {
            System.out.println("La stanza " + this.roomName + " ha già una stanza in questa direzione");
            return this.adjacentRoom.get(direction);
        } else {
            this.adjacentRoom.put(direction, room);
            if (direction == Direction.NORTH) {
                this.northRoom = room;
            } else if (direction == Direction.SOUTH) {
                this.southRoom = room;
            } else if (direction == Direction.EAST) {
                this.eastRoom = room;
            } else if (direction == Direction.WEST) {
                this.westRoom = room;
            }
            return this.adjacentRoom.get(direction);
        }
    }


    public Room getAdjacentRoom(Direction direction) {
        switch (direction) {
            case NORTH:
                return northRoom;
            case SOUTH:
                return southRoom;
            case EAST:
                return eastRoom;
            case WEST:
                return westRoom;
            default:
                return null;
        }
    }

    public boolean isClosed() {
            boolean closed = true;
            return closed;

    }

}
