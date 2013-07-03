package ua.kpi_java_training5.alekseenko.src.module3;

/**
 * Author: Aleksey Alekseenko
 * Date: 14.06.13
 */
public class GodsWill {
    public static void main(String[] args) {
        Initialization initialization = new Initialization();
        initialization.setUp();
        Statistic statistic = new Statistic(initialization);
        statistic.begin();
        Desert desert = new Desert(initialization.getLengthDesert(), initialization.getHeightDesert());
        desert.lifeCycle(initialization.getLengthLifeInAquarium());
        Statistic.end();
    }
}

