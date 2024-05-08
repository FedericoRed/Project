package ese.zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Eagle extends AnimalWithWings{

    private static List<Eagle> eagleList = new ArrayList<>();

    public Eagle (String name, String favoriteFood,int age, LocalDate entryDate, double weight, double height, double wingOpening) {
        super(name, favoriteFood, age, entryDate, weight, height, wingOpening);

    }

    public String toString() {
        return super.toString();
    }

}
