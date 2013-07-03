package ua.kpi_java_training5.alekseenko.src.module3;


import java.util.Scanner;

/**
 * Author: Aleksey Alekseenko
 * Date: 10.06.13
 */
public class Initialization {
    public static int lengthDesert;
    public static int heightDesert;
    public static int numberPredators;
    public static int stepToPredator;
    public static int numberVictims;
    public static int numberHurdles;
    public static int stepToVictim;
    public int lengthLifeInAquarium;

    public void setUp() {
        Scanner scanner = new Scanner(System.in);
        setAquarium(scanner);
        setVictims(scanner);
        setStepToVictim(scanner);
        setPredators(scanner);
        setStepToPredator(scanner);
        setHurdles(scanner);
        setLengthLifeInAquarium(scanner);
    }

    private void setAquarium(Scanner scanner) {
        lengthDesert = Input.getPositiveNumber(scanner, "Enter length of desert:");
        heightDesert = Input.getPositiveNumber(scanner, "Enter height of desert:");
    }

    private void setPredators(Scanner scanner) {
        numberPredators = Input.getPositiveNumber(scanner,
                "Enter the number of predators:");
    }

    private void setVictims(Scanner scanner) {
        numberVictims = Input.getPositiveNumber(scanner,
                "Enter the number of victims:");
    }

    private void setHurdles(Scanner scanner) {
        numberHurdles = Input.getPositiveNumber(scanner,
                "Enter the number of hurdles:");
    }

    private void setLengthLifeInAquarium(Scanner scanner) {
        lengthLifeInAquarium = Input.getPositiveNumber(scanner,
                "Enter the number of cycles of life:");
    }

    public void setStepToVictim(Scanner scanner) {
        this.stepToVictim = Input.getPositiveNumber(scanner, "Enter step of Victim");
    }

    public void setStepToPredator(Scanner scanner) {
        this.stepToPredator = Input.getPositiveNumber(scanner, "Enter step of Predator");
    }

    public int getLengthLifeInAquarium() {
        return lengthLifeInAquarium;
    }

    public int getNumberPredators() {
        return numberPredators;
    }

    public int getNumberVictims() {
        return numberVictims;
    }

    public int getLengthDesert() {
        return lengthDesert;
    }

    public int getHeightDesert() {
        return heightDesert;
    }

    public static int getStepToVictim() {
        return stepToVictim;
    }

    public static int getStepToPredator() {
        return stepToPredator;
    }
}
