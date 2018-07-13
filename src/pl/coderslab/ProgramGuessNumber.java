package pl.coderslab;

import java.util.Scanner;

public class ProgramGuessNumber {

    public static void main(String[] args) {
        compGeussNumber();
    }

    static void compGeussNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadne w mniej niż 10 próbach.");
        int min = 0, max = 1000;

        while (true) {
            int guess = ((max - min) / 2) + min;
            System.out.println("Zgaduję " + guess);
            String answer = getAnswer(scanner);
            if(answer.equalsIgnoreCase("d")){
                max = guess;
            }else if(answer.equalsIgnoreCase("m")){
                min = guess;
            }else {
                System.out.println("Wygrałem!");
                break;
            }
        }
    }

    static String getAnswer(Scanner scanner) {
        System.out.println("Podaj odpowiedź:\nza [d]użo\nza [m]ało\n[z]gadłeś");
        String result;
        while (true) {
            String key = scanner.nextLine();
            if(key.equalsIgnoreCase("d") || key.equalsIgnoreCase("m") || key.equalsIgnoreCase("z")){
                result = key;
                break;
            }
        }
        return result;
    }
}
