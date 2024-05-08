package ese.zoo;

import java.time.LocalDate;
import java.util.*;

import static ese.zoo.Item.itemAvailable;

public class Map {
    private Room currentRoom;
    private Room room1;


    public Map() {
        room1 = new Room ("Gardenie");
        this.currentRoom = room1;
    }

    public Room getCurrent() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void changeRoom(Direction direction) {
            try{
                if (direction == Direction.EAST) {
                    Room nextRoom = currentRoom.getAdjacentRoom(direction);
                    if (nextRoom != null) {
                        currentRoom = nextRoom;
                        System.out.println(currentRoom.toString());
                    } else {
                        System.out.println("Invalid direction.");
                    }
                }
                if (direction == Direction.NORTH) {
                    Room nextRoom = currentRoom.getAdjacentRoom(direction);
                    if (nextRoom != null) {
                        currentRoom = nextRoom;
                        System.out.println(currentRoom.toString());
                    } else {
                        System.out.println("Invalid direction.");
                    }
                }
                if (direction == Direction.WEST) {
                    Room nextRoom = currentRoom.getAdjacentRoom(direction);
                    if (nextRoom != null) {
                        currentRoom = nextRoom;
                        System.out.println(currentRoom.toString());
                    } else {
                        System.out.println("Invalid direction.");
                    }
                }
                if (direction == Direction.SOUTH) {
                    Room nextRoom = currentRoom.getAdjacentRoom(direction);
                    if (nextRoom != null) {
                        currentRoom = nextRoom;
                        System.out.println(currentRoom.toString());
                    } else {
                        System.out.println("Invalid direction.");
                    }
                }

            }catch(Exception e){
                System.out.println("Error while reading user input, you can only digit  NORTH, SOUTH, EAST, WEST");
            }
    }

    public void createMap () {

        Room room2 = new Room ("Pigneto");
        Room room3 = new Room ("Due Leoni");
        Room room4 = new Room ("Pantano");
        Room room5 = new Room ("Centocelle");
        Room room6 = new Room ("Finocchio");
        Room room7 = new Room ("Graniti");

        Item spada = new Item ("Spada", "Presa in plastica dal cinese sotto casa", 1);
        Item bastone = new Item ("Bastone da mago", "Un ramo trovato in giardino", 2);
        Item salsiccia = new Item ("Salsiccia", "Colpisci i tuoi vicini vegani", 1);
        Item bottiglia = new Item ("Bottiglia", "Inquina il pianeta", 2);
        Item accendino = new Item ("Accendino", "Dai fuoco ai tuoi vicini immigrati", 2);
        Item cappello = new Item ("Cappello", "Per nascondere la pelata", 1);
        Item banana = new Item ("Banana", "se ne hai 2 una te la puoi mangiare", 1);
        Item banana2 = new Item ("Banana2", "se ne hai 2 una te la puoi mangiare", 1);
        Item fazzoletti = new Item ("Fazzoletti", "per pulire il pesto uscito dal naso", 1);
        Item collana = new Item ("Collana", "per farti derubare dai maranza", 1);
        Item key = new Item ("Key","serve per aprire una porta", 1);




        Eagle mario = new Eagle ("Mario", "Sedie", 5, LocalDate.of(2024, 1,1) ,15, 10, 5);
        Eagle gianni = new Eagle("Gianni", "Scarpe", 65, LocalDate.of(2024, 1,1) ,15, 10, 5);
        Lion giuann = new Lion("Giuann"," Comunisti", 25, LocalDate.of(2024, 1,1) ,15, 10, 5);
        Tiger gianpergiacomo = new Tiger("Gianpiergiacomo"," Porte", 69, LocalDate.of(2024, 1,1) ,15, 10, 5);

        itemAvailable.add(spada);
        itemAvailable.add(bastone);
        itemAvailable.add(salsiccia);
        itemAvailable.add(bottiglia);
        itemAvailable.add(accendino);

        room1.addItemInRoom(spada);
        room1.addItemInRoom(bastone);
        room1.addAnimalInRoom(mario);

        room2.addItemInRoom(salsiccia);
        room2.addAnimalInRoom(giuann);

        room3.addItemInRoom(bottiglia);
        room3.addAnimalInRoom(gianpergiacomo);


        room4.addItemInRoom(accendino);
        room4.addAnimalInRoom(gianni);
        room4.setClosed(true);;

        room5.addItemInRoom(cappello);
        room5.addItemInRoom(collana);

        room6.addItemInRoom(banana);
        room6.addItemInRoom(fazzoletti);
        room6.addItemInRoom(key);

        room7.addItemInRoom(banana2);
        room7.addItemInRoom(key);

        collegamentoRooms(room1, room2, Direction.SOUTH);
        collegamentoRooms(room1, room3, Direction.EAST);
        collegamentoRooms(room1, room4, Direction.WEST);            // |---------------------------------|
        collegamentoRooms(room1, room5, Direction.NORTH);           // |     X       room5        X      |
                                                                    // |                                 |
        collegamentoRooms(room2, room6, Direction.EAST);            // |   room4     room1      room3    |
        collegamentoRooms(room2, room7, Direction.WEST);            // |                                 |
        collegamentoRooms(room2, room1, Direction.NORTH);           // |   room7     room2      room6    |
                                                                    // |_________________________________|
        collegamentoRooms(room3, room1, Direction.WEST);
        collegamentoRooms(room3, room6, Direction.SOUTH);

        collegamentoRooms(room4, room1, Direction.EAST);
        collegamentoRooms(room4, room7, Direction.SOUTH);

        collegamentoRooms(room5, room1, Direction.SOUTH);

        collegamentoRooms(room6, room2, Direction.WEST);
        collegamentoRooms(room6, room3, Direction.NORTH);

        collegamentoRooms(room7, room2, Direction.EAST);
        collegamentoRooms(room7, room4, Direction.NORTH);
    }

    public void collegamentoRooms(Room room1, Room room2, Direction direction){
            room1.collegamentoRoom(room2, direction);
    }
    public void printMap () {
        Room current = getCurrent();
        if (current.getRoomName().equalsIgnoreCase("gardenie")) {
            System.out.println("\nMAP:");
            System.out.println("|---------------------------------|");
            System.out.println("|   X       centocelle        X   |");
            System.out.println("|                                 |");
            System.out.println("| pantano    \033[31mgerdenie\033[0m   due leoni |");
            System.out.println("|                                 |");
            System.out.println("| graniti    pigneto    finocchio |");
            System.out.println("|_________________________________|");
            System.out.println("");
        }
        if (current.getRoomName().equalsIgnoreCase("centocelle")) {
            System.out.println("\nMAP:");
            System.out.println("|---------------------------------|");
            System.out.println("|   X       \033[31mcentocelle\033[0m        X   |");
            System.out.println("|                                 |");
            System.out.println("| pantano    gerdenie   due leoni |");
            System.out.println("|                                 |");
            System.out.println("| graniti    pigneto    finocchio |");
            System.out.println("|_________________________________|");
            System.out.println("");
        }
        if (current.getRoomName().equalsIgnoreCase("pigneto")) {
            System.out.println("\nMAP:");
            System.out.println("|---------------------------------|");
            System.out.println("|   X       centocelle        X   |");
            System.out.println("|                                 |");
            System.out.println("| pantano    gerdenie   due leoni |");
            System.out.println("|                                 |");
            System.out.println("| graniti    \033[31mpigneto\033[0m    finocchio |");
            System.out.println("|_________________________________|");
            System.out.println("");
        }
        if (current.getRoomName().equalsIgnoreCase("due leoni")) {
            System.out.println("\nMAP:");
            System.out.println("|---------------------------------|");
            System.out.println("|   X       centocelle        X   |");
            System.out.println("|                                 |");
            System.out.println("| pantano    gerdenie   \033[31mdue leoni\033[0m |");
            System.out.println("|                                 |");
            System.out.println("| graniti    pigneto    finocchio |");
            System.out.println("|_________________________________|");
            System.out.println("");
        }
        if (current.getRoomName().equalsIgnoreCase("pantano")) {
            System.out.println("\nMAP:");
            System.out.println("|---------------------------------|");
            System.out.println("|   X       centocelle        X   |");
            System.out.println("|                                 |");
            System.out.println("| \033[31mpantano\033[0m    gerdenie   due leoni |");
            System.out.println("|                                 |");
            System.out.println("| graniti    pigneto    finocchio |");
            System.out.println("|_________________________________|");
            System.out.println("");

        }if (current.getRoomName().equalsIgnoreCase("finocchio")) {
            System.out.println("\nMAP:");
            System.out.println("|---------------------------------|");
            System.out.println("|   X       centocelle        X   |");
            System.out.println("|                                 |");
            System.out.println("| pantano    gerdenie   due leoni |");
            System.out.println("|                                 |");
            System.out.println("| graniti    pigneto    \033[31mfinocchio\033[0m |");
            System.out.println("|_________________________________|");
            System.out.println("");

        }if (current.getRoomName().equalsIgnoreCase("graniti")) {
            System.out.println("\nMAP:");
            System.out.println("|---------------------------------|");
            System.out.println("|   X       centocelle        X   |");
            System.out.println("|                                 |");
            System.out.println("| pantano    gerdenie   due leoni |");
            System.out.println("|                                 |");
            System.out.println("| \033[31mgraniti\033[0m    pigneto    finocchio |");
            System.out.println("|_________________________________|");
            System.out.println("");
        }
    }
    public boolean checkOpenDoor (Bag bag, Direction direction) {

        Room nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom == null) {
            System.out.println("Invalid direction.");
            return false;
        }

        boolean isClosed = nextRoom.getIsClosed();



        if (!isClosed) {
            return true;
        }

        System.out.println("The door is locked: would you like to use an item to unlock it? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!input.equalsIgnoreCase("Y")) {
            System.out.println("non hai aperto la porta");
            return false;
        }

        System.out.println("Type the name of the chosen item");
        String itemChose = scanner.nextLine();
        if (!itemChose.equalsIgnoreCase("key")) {
            System.out.println("This item can't open the door");
            return false;
        }

        if (!bag.dropKey(itemChose)) {
            return false;
        }
        nextRoom.setClosed(false);
        return true;

/*
        if (isClosed){
            System.out.println("The door is locked: would you like to use an item to unlock it? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Y")){
                System.out.println ("Type the name of the chosen item");
                String itemChose = scanner.nextLine();
                if (itemChose.equalsIgnoreCase("key")){
                    if (bag.dropKey(itemChose)){
                        nextRoom.setClosed(false);
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    System.out.println("This item can't open the door");
                    return false;
                }
            }
            else {
                System.out.println("non hai aperto la porta");
                return false;
            }
        }
        else {
            return true;
        }
        */

    }
}
