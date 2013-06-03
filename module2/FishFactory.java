package ua.kpi_java_training5.alekseenko.src.module2;

/**
 * Created with IntelliJ IDEA.
 * User: Lesha
 * Date: 03.06.13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class FishFactory {
    public static void main(String[] args) {

        String fishList[] = { "Circle", "Square", "Square", "Circle", "Circle",
                "Square" };
        Fish []  fishes = new Fish[fishList.length];

        for(int index=0; index<fishList.length; index++) {
            fishes[index] = Fish.factory(fishList[index]);
            fishes[index].birth();
        }
    }

}
