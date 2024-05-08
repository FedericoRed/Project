package ese.zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalWithTail extends GenericAnimal {

    private double tailLength;
    private static List<AnimalWithTail> listAnimalWithTail = new ArrayList<>();

    public AnimalWithTail(String name, String favoriteFood,int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public String toString() {
        return super.toString();
    }

    public static List<AnimalWithTail> findLongertail() {
        double longTail = 0;
        List<AnimalWithTail> longTailAnimals = new ArrayList<>();

        for (AnimalWithTail animalWithTail : listAnimalWithTail) {
            if (animalWithTail.getTailLength() > longTail){
                longTailAnimals.clear();
                longTailAnimals.add(animalWithTail);
                longTail = animalWithTail.getTailLength();
            }
            else if (animalWithTail.getTailLength() == longTail) {
                longTailAnimals.add(animalWithTail);
            }
        }
        return longTailAnimals;
    }

}
