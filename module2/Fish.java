package ua.kpi_java_training5.alekseenko.src.module2;

/**
 * Created with IntelliJ IDEA.
 * User: Lesha
 * Date: 29.05.13
 * Time: 21:57
 * To change this template use File | Settings | File Templates.
 */
public abstract class Fish {
    Aquarium aquarium;
    Position p;
    public boolean eatable;
    public Fish(Aquarium aquarium) {
        this.aquarium = aquarium;
        p = new Position((int)(Math.random()*aquarium.getLength()), (int)(Math.random()*aquarium.getHeight()));
        System.out.println("eateable " + eatable + "\naquarium length " + this.aquarium.getLength() +
        		"\naquarium height " + this.aquarium.getHeight() + "\nposition " + p.getX() + " " + p.getY());
    }

    public abstract void birth();
    public abstract Position move();
    public abstract void death();

    public static Fish factory(String type) {
        if (type.equals("Predator")) {
            return (Fish) new Predator(Aquarium);
        }
        if (type.equals("Victim")) {
            return (Fish) new Victim();
        }
        throw new RuntimeException("Bad shape creation: " + type);
    }

}
