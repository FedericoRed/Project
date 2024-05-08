package ese.zoo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tiger extends AnimalWithTail {
    static ArrayList<Tiger> tigerList = new ArrayList<>();

    public Tiger(String name, String favoriteFood,int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height , tailLength);

    }
}
