package ua.kpi_java_training5.alekseenko.src.module2;

/**
 * Created with IntelliJ IDEA.
 * User: Lesha
 * Date: 29.05.13
 * Time: 21:57
 * To change this template use File | Settings | File Templates.
 */
public class Aquarium {
    private int length;
    private int height;
    public Aquarium( int length, int height) {
        this.height = height;
        this.length = length;
        System.out.println(String.format("length %s\nheight %s", this.length, this.height));
    }
    public String toString() {
        return String.format("length %s\nheight %s", this.length, this.height);
    }
    public  static void main(String[] args) {
        System.out.println(new Aquarium(12, 14).toString());
    }

    public int getLength() {
        return this.length;
    }

    public  int getHeight() {
        return this.height;
    }
}
