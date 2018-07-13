package pl.coderslab;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {

        guessNumber();
    }

    static void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        while (true) {
            int number = getIntFromUser(scanner, "Podaj liczbę z zakresu 1-100: ", 100);
            if (number < randomNumber) {
                System.out.println("Za mało!");
            } else if (number > randomNumber) {
                System.out.println("Za dużo!");
            } else {
                break;
            }
        }
        System.out.println("Zgadłeś!");

    }

    static int getIntFromUser(Scanner scanner, String message, int max) {
        int number = 0;
        while (true) {
            System.out.println(message);
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("To nie jest liczba!");
            }
            number = scanner.nextInt();
            scanner.nextLine();
            if (number > 0 && number <= max) {
                break;
            }
            System.out.println("Podana liczba musi być w zakresie 0-" + max + ".");
        }
        return number;
    }
}
