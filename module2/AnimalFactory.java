package ua.kpi_java_training5.alekseenko.src.module3;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Aleksey Alekseenko
 * Date: 12.06.13
 * Creates and consists set quantity of victims and predators
 */
public class AnimalFactory {
    private List<Animal> victims;
    private List<Animal> predators;

    public AnimalFactory(String victim, String predator) {
        victims = new ArrayList<Animal>();
        predators = new ArrayList<Animal>();

        if (victim.equals("Ostrich")) {
            for (int index = 0; index < Initialization.numberVictims; index++) {
                victims.add(new Ostrich());
            }
        }
        if (predator.equals("Cheetah")) {
            for (int index = 0; index < Initialization.numberPredators; index++) {
                predators.add(new Cheetah());
            }
        }
    }

    public Animal createNewVictim() {
        return new Ostrich();
    }

    public void addVictim(Animal animal) {
        victims.add(animal);
    }

    public void addPredator(Animal animal) {
        predators.add(animal);
    }

    public Animal getVictim(int index) {
        return victims.get(index);
    }

    public Animal getPredator(int index) {
        return predators.get(index);
    }

    public int getQuantityOfVictims() {
        return victims.size();
    }

    public int getQuantityOfPredator() {
        return predators.size();
    }

    public void removeVictim(int index) {
        victims.remove(index);
    }
}
