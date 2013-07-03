package ua.kpi_java_training5.alekseenko.src.module3;

/**
 * Author: Aleksey Alekseenko
 * Date: 12.06.13
 */
public class Ostrich extends Animal {

    public Ostrich() {
        super.moveStep = 1;
        //       super.isDead = true;
    }

    /**
     * Eatable animal
     *
     * @return
     */
    @Override
    public boolean isEatable() {
        return true;
    }

    /**
     * Moves victim and increases age
     */
    @Override
    public void move() {
        super.move();
        this.age += 1;
    }

}
