package ua.kpi_java_training5.alekseenko.src.module3;

/**
 * Author: Aleksey Alekseenko
 * Date: 04.06.13
 */
public class DirectionMove {
    /**
     * Returns Direction to move
     *
     * @return
     */
    public static Direction selectDirection() {
        return Direction.values()[randomDirection()];
    }

    /**
     * Chooses random number of quantity of Directions
     *
     * @return
     */
    private static int randomDirection() {
        return (int) (Math.random() * Direction.values().length);
    }
}

