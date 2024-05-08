package ese.zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lion extends AnimalWithTail {

    static List<Lion> lionList = new ArrayList<>();

    public Lion(String name, String favoriteFood,int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height , tailLength);
    }
}
