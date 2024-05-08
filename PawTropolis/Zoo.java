package ese.zoo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Zoo {
    public ArrayList<GenericAnimal> genericAnimalList = new ArrayList<>();

    public Zoo() {

    }

    public void addAnimal(GenericAnimal animal) {
        genericAnimalList.add(animal);
    }

    public void removeAnimal(int index) {
        genericAnimalList.remove(index);
    }


    //cerca l'animale piu leggero di una certa specie'
    public List<GenericAnimal> findLight (String species) {
        double lighterWeight = Double.MAX_VALUE;
        List<GenericAnimal> lighterAnimals = new ArrayList<>();
        for (GenericAnimal animal : genericAnimalList) {

            if (animal.getClass().getSimpleName().equals(species) && animal.getWeight() < lighterWeight) {
                lighterAnimals.clear();
                lighterAnimals.add(animal);
                lighterWeight = animal.getWeight();
            }
            else if (animal.getClass().getSimpleName().equals(species) && animal.getWeight() == lighterWeight) {
                lighterAnimals.add(animal);
            }

        }
        return lighterAnimals;
    }

    //cerca l'animale piu alto di una certa specie'
    public List<GenericAnimal> findHigher(String species) {
        List<GenericAnimal> higherAnimals = new ArrayList<>();
        double higher = 0;
        for (GenericAnimal animal : genericAnimalList) {

            if (animal.getClass().getSimpleName().equals(species) && animal.getHeight() > higher) {
               higherAnimals.clear();
               higherAnimals.add(animal);
               higher = animal.getHeight();
            }
            else if (animal.getClass().getSimpleName().equals(species) && animal.getHeight() == higher) {
                higherAnimals.add(animal);
            }

        }
        return higherAnimals;
    }
    //cerca l'animale piu basso di una certa specie
    public List<GenericAnimal> findLower (String species) {
        List<GenericAnimal> lowerAnimals = new ArrayList<>();
        double lower = Double.MAX_VALUE;
        for (GenericAnimal animal : genericAnimalList) {

            if (animal.getClass().getSimpleName().equals(species) && animal.getHeight() < lower) {
                lowerAnimals.clear();
                lowerAnimals.add(animal);
                lower = animal.getHeight();
            }
            else if (animal.getClass().getSimpleName().equals(species) && animal.getHeight() == lower) {
                lowerAnimals.add(animal);
            }

        }
        return lowerAnimals;
    }

    //cerca l'animale piu pesante di una certa specie'
    public List<GenericAnimal> findHeavier (String species) {
        double heavierWeight = 0;
        List<GenericAnimal> lighterAnimals = new ArrayList<>();
        for (GenericAnimal animal : genericAnimalList) {

            if (animal.getClass().getSimpleName().equals(species) && animal.getWeight() > heavierWeight) {
                lighterAnimals.clear();
                lighterAnimals.add(animal);
                heavierWeight = animal.getWeight();
            }
            else if (animal.getClass().getSimpleName().equals(species) && animal.getWeight() == heavierWeight) {
                lighterAnimals.add(animal);
            }

        }
        return lighterAnimals;
    }



}
