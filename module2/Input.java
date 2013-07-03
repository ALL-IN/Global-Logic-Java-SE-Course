package ua.kpi_java_training5.alekseenko.src.module3;

import java.util.Scanner;

/**
 * Author: Aleksey Alekseenko
 * Date: 10.06.13
 */
public class Input {
    public static int getPositiveNumber(Scanner scanner, String message) {
        int number = 0;
        number = getNumber(scanner, message);
        while (number <= 0) {
            System.out.println("Error: incorrect number.");
            number = getNumber(scanner, message);
        }
        return number;
    }

    public static int getNumber(Scanner scanner, String message) {
        int number = 0;
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: incorrect data.\n" + message);
            scanner.next();
        }
        number = scanner.nextInt();
        return number;
    }
}
