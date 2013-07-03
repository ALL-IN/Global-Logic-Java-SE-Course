package ua.kpi_java_training5.alekseenko.src.module3;

import java.util.ArrayList;

/**
 * Author: Aleksey Alekseenko
 * Date: 12.06.13
 */
public class Desert extends Area {
    public AnimalFactory animalFactory;
    HurdleFactory hurdleFactory;

    public Desert(int length, int height) {
        this.length = length;
        this.height = height;
        hurdleFactory = new HurdleFactory();
        for (int i = 0; i < hurdleFactory.getQuantityOfHurdles(); i++) {
            hurdleFactory.getHurdle(i).position = new Position((int) (Math.random() * length), (int) (Math.random() * height));
        }
        animalFactory = new AnimalFactory("Ostrich", "Cheetah");
        for (int i = 0; i < animalFactory.getQuantityOfVictims(); i++) {
            animalFactory.getVictim(i).desert = Desert.this;
            animalFactory.getVictim(i).hurdleFactory = this.hurdleFactory;
            animalFactory.getVictim(i).position =
                    new Position((int) (Math.random() * length), (int) (Math.random() * height));
        }
        for (int i = 0; i < animalFactory.getQuantityOfPredator(); i++) {
            animalFactory.getPredator(i).desert = Desert.this;
            animalFactory.getPredator(i).hurdleFactory = this.hurdleFactory;
            animalFactory.getPredator(i).position =
                    new Position((int) (Math.random() * length), (int) (Math.random() * height));
        }

    }

    /**
     * Life cycle set times
     *
     * @param counts
     */
    public void lifeCycle(int counts) {
        for (int i = 1; i <= counts; i++) {
            moveAllAnimals();
            birthNewVictim(i);
            death();
        }
    }

    /**
     * Moves animal one by one
     */
    private void moveAllAnimals() {
        for (int i = 0; i < animalFactory.getQuantityOfVictims(); i++) {
            animalFactory.getVictim(i).move();
        }

        for (int i = 0; i < animalFactory.getQuantityOfPredator(); i++) {
            animalFactory.getPredator(i).move();
        }
    }

    /**
     * Births victim every 5 moves
     *
     * @param i
     */
    public void birthNewVictim(int i) {
        if (i % 5 == 0) {
            ArrayList <Ostrich> arrayList = new ArrayList<Ostrich>();
            for (int index = 0; index < animalFactory.getQuantityOfVictims(); index++) {
                Ostrich ostrich = (Ostrich) animalFactory.createNewVictim();
                ostrich.position = new Position((int) (Math.random() * this.length), (int) (Math.random() * this.height));
                ostrich.hurdleFactory = this.hurdleFactory;
                ostrich.desert = Desert.this;
                arrayList.add(ostrich);
                Initialization.numberVictims = animalFactory.getQuantityOfVictims();
                Statistic.spawnedVictims++;
            }
            for (int index = 0; index < arrayList.size(); index++) {
                animalFactory.addVictim(arrayList.get(index));
            }
        }
    }

    /**
     * Checks is same position of predator and victim
     */
    public void death() {
        do {
            removeIsDead();
            for (int index = 0; index < animalFactory.getQuantityOfPredator(); index++) {
                for (int i = 0; i < animalFactory.getQuantityOfVictims(); i++) {
                    if (animalFactory.getVictim(i).position.getX() == animalFactory.getPredator(index).position.getX()
                            && animalFactory.getVictim(i).position.getY() == animalFactory.getPredator(index).position.getY()) {
                        animalFactory.getVictim(i).isDead = true;
                        Statistic.killedVictims++;
                        Initialization.numberVictims = animalFactory.getQuantityOfVictims();
                    }
                }
            }
        } while (hasIsDead());
    }

    /**
     * Checks has Victims List dead fishes
     *
     * @return
     */
    public boolean hasIsDead() {
        boolean b = false;
        for (int index = 0; index < animalFactory.getQuantityOfVictims(); index++) {
            if (animalFactory.getVictim(index).isDead) {
                b = true;
            }
        }
        return b;
    }

    /**
     * Removes dead Victims
     */
    public void removeIsDead() {
        for (int index = 0; index < animalFactory.getQuantityOfVictims(); index++) {
            if (animalFactory.getVictim(index).isDead) {
                animalFactory.removeVictim(index);
                if (animalFactory.getQuantityOfVictims() == 0) {
                    Statistic.end();
                    System.exit(0);
                }
            }
        }
    }
}
