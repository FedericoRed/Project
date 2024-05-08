package ese.zoo;
import java.util.Scanner;




public class GameController {

    private Map map;
    private Bag bag;
    Scanner scanner = new Scanner(System.in);
    String oggetto;
    String action;


    public void startGame() {

        Player p = new Player(" ", 5);
        map = new Map();
        bag = new Bag("borsello da galera ", "piccolo e stretto", 5);
        map.createMap();

        System.out.println("\n\033[31mWELCOME TO THE PAWTROPOLIS!\033[0m");
        System.out.println("Please enter your name: ");
        String playerName = p.readString();
        p.setPlayerName(playerName);

        map.printMap();

        printCommandList();

        do {
            System.out.println("\n\033[31m" + playerName + "\033[0m, What do you want to do?");

            action = p.readString();

            if (action.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for playing!");
                break;

            } else if (action.equalsIgnoreCase("go " + Direction.EAST)) {
                if (map.checkOpenDoor(bag, Direction.EAST)){
                    map.changeRoom(Direction.EAST);
                }

            } else if (action.equalsIgnoreCase("go " + Direction.NORTH)) {
                if (map.checkOpenDoor(bag, Direction.NORTH)){
                    map.changeRoom(Direction.NORTH);
                }

            } else if (action.equalsIgnoreCase("go " + Direction.WEST)) {
                if (map.checkOpenDoor(bag, Direction.WEST)){
                    map.changeRoom(Direction.WEST);
                }
                else {
                    System.out.println("You can't go that way!");
                }

            } else if (action.equalsIgnoreCase("go " + Direction.SOUTH)) {
                if (map.checkOpenDoor(bag, Direction.SOUTH)){
                    map.changeRoom(Direction.SOUTH);
                }



            } else if (action.toLowerCase().startsWith("get ") ) {
                Room room = map.getCurrent();
                oggetto = action.substring(4);
                bag.getItemBag(oggetto, room);

            }else if (action.toLowerCase().startsWith("drop ") ) {
                Room room = map.getCurrent();
                oggetto = action.substring(5);
                bag.dropItemBag(oggetto, room);

            }else if(action.equalsIgnoreCase("look")){
                    System.out.println(map.getCurrent());

            }else if(action.equalsIgnoreCase("view map")){
                Room room = map.getCurrent();
                map.printMap();

            }else if(action.equalsIgnoreCase("bag")){
                System.out.println(bag);

            }else {
                System.out.println("wrong command");
            }

        } while (!action.equals("exit"));

    }


    public void printCommandList () {
        System.out.println("command list:");
        System.out.println("go + direction ---> you will go to another room");
        System.out.println("get + item ---> take the item in the room");
        System.out.println("drop + item ---> drop the item in room");
        System.out.println("look ---> look where you are now");
        System.out.println("view map ---> view map and position");
        System.out.println("bag ---> look inside your backpack");
        System.out.println("exit ---> exit the game :(");
    }


}
