package ese.zoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Player {
    private String playerName;
    private int lifePoint = 5;

    public  Player(String playerName, int lifePoint) {
        this.playerName = playerName;
        this.lifePoint = lifePoint;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    public int getLifePoint() {
        return lifePoint;
    }
    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public String toString() {
        return "player: " + playerName + " life point: " + lifePoint;
    }

    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (Exception e) {
            System.err.println("Error while reading user input");
            return "";
        }
    }




}
