package ua.kpi_java_training5.alekseenko.src.module3;

/**
 * Author: Aleksey Alekseenko
 * Date: 12.06.13
 */
public class Cheetah extends Animal {
    public Cheetah() {
        super.moveStep = 1;
    }

    /**
     * Not eatable animal
     *
     * @return
     */
    @Override
    public boolean isEatable() {
        return false;
    }

    /**
     * Moves set times for 1 step in random direction
     */
    @Override
    public void move() {
        for (int i = 0; i < Initialization.getStepToPredator(); i++) {
            super.move();
        }
    }
}
