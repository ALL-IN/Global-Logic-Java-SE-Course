package ua.kpi_java_training5.alekseenko.src.module2;

/**
 * Created with IntelliJ IDEA.
 * User: Lesha
 * Date: 31.05.13
 * Time: 19:40
 * To change this template use File | Settings | File Templates.
 */
public class Action {

    public static void main(String[] args) {
        fight();
    }
    private static void fight() {
        Aquarium aquarium = getNewAquarium();
        Fish [] allFishes = new Fish [100];
        allFishes[0] = getNewPredator(aquarium);
        allFishes[1] = getNewVictim(aquarium);
    }
    private static Aquarium getNewAquarium() {
        return new Aquarium(50, 50);
    }
    private static Predator getNewPredator(Aquarium aquarium) {
        return new Predator(aquarium);
    }
    private static Victim getNewVictim(Aquarium aquarium) {
        return new Victim(aquarium);
    }
}
