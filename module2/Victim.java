package ua.kpi_java_training5.alekseenko.src.module2;

/**
 * Created with IntelliJ IDEA.
 * User: Lesha
 * Date: 29.05.13
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */
public class Victim extends Fish {
    public Victim(Aquarium aq) {
    	this.eatable = true;
        System.out.println(eatable);
    }
}
