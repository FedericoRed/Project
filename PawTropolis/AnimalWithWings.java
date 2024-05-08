package ese.zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalWithWings extends GenericAnimal {
    private double wingOpening;

    private static List<AnimalWithWings> listAnimalWithWings = new ArrayList<>();

    public AnimalWithWings (String name, String favoriteFood,int age, LocalDate entryDate, double weight, double height, double wingOpening) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingOpening = wingOpening;

    }
    public double getWingOpening() {
        return wingOpening;
    }
    public void setWingOpening(double wingOpening) {
        this.wingOpening = wingOpening;
    }

    public String toString() {
        return super.toString();
    }

    public static List<AnimalWithWings> findLargerWingspan(){
        double wingspan = 0;
        List<AnimalWithWings> wingspanAnimals = new ArrayList<>();
        for (AnimalWithWings animalWithWings : listAnimalWithWings) {
            if (animalWithWings.getWingOpening() > wingspan){
                wingspanAnimals.clear();
                wingspanAnimals.add(animalWithWings);
                wingspan = animalWithWings.getWingOpening();
            }
            else if (animalWithWings.getWingOpening() == wingspan){
                wingspanAnimals.add(animalWithWings);
            }
        }
        return wingspanAnimals;
    }


}
