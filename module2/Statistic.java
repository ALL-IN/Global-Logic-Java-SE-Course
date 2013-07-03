package ua.kpi_java_training5.alekseenko.src.module3;


/**
 * Author: Aleksey Alekseenko
 * Date: 10.06.13
 */
public class Statistic {
    static Initialization initialization;
    static int killedVictims;
    static int spawnedVictims;

    protected Statistic(Initialization initialization) {
        this.initialization = initialization;
    }

    /**
     * Prints default data
     */
    public void begin() {
        Printer.printToConsole("Begin");
        Printer.printToConsole(String.format("Victims in pool %d", initialization.getNumberVictims()));
        Printer.printToConsole(String.format("Predators in pool %d", initialization.getNumberPredators()));
    }

    /**
     * Prints data after action in aquarium
     */
    public static void end() {
        Printer.printToConsole("End");
        Printer.printToConsole(String.format("%d Victims killed", killedVictims));
        Printer.printToConsole(String.format("%d Victims spawned", spawnedVictims));
        Printer.printToConsole(String.format("Victims in pool %d", Initialization.numberVictims));
        Printer.printToConsole(String.format("Predators in pool %d", Initialization.numberPredators));
    }
}
