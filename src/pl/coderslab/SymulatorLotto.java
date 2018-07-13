package pl.coderslab;

import java.util.*;

public class SymulatorLotto {

    public static void main(String[] args) {
        symLotto();

    }

    static void symLotto() {
        final int MIN = 1, MAX = 49, COUNTER = 6;
        Scanner scanner = new Scanner(System.in);
        Integer[] generatedNumbers = generateNumbers(MIN, MAX, COUNTER);
        Collections.sort(Arrays.asList(generatedNumbers));
        List<Integer> numberFromUser = new ArrayList<>();
        for (int i = 0; i < COUNTER; i++) {
            int num = 0;
            while (true) {
                num = getIntFromUser(scanner, MIN, MAX);
                if(!numberFromUser.contains(num)){
                    break;
                }
                System.out.println("Liczba już została podana!");
            }
            numberFromUser.add(num);
        }
        Collections.sort(numberFromUser);
        System.out.println("Wprowadzone zostały liczby: ");
        System.out.println(numberFromUser.toString());
        System.out.println("Wylosowane zostały liczby: ");
        System.out.println(Arrays.toString(generatedNumbers));
        int hits = checkHits(numberFromUser, Arrays.asList(generatedNumbers));
        if(hits >= 3){
            System.out.println("Brawo! Trafiłeś " + hits + " razy.");
        }else {
            System.out.println("Niestety... Nic nie wygrałeś.");
        }

    }

    private static int checkHits(List<Integer> numberFromUser, List<Integer> generatedNumbers) {
        int hits = 0;
        for(int i : numberFromUser){
            if(generatedNumbers.contains(i)){
                hits++;
            }
        }
        return hits;
    }

    private static Integer[] generateNumbers(int min, int max, int counter) {
        Integer[] num = new Integer[max - min];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + min;
        }
        Collections.shuffle(Arrays.asList(num));
        Integer[] result = Arrays.copyOf(num, counter);
        return result;

    }

    static int getIntFromUser(Scanner scanner, int min, int max) {
        int number = 0;
        while (true) {
            System.out.println("Podaj liczbę z zakresu " + min + "-" + max + ": ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("To nie jest liczba!");
            }
            number = scanner.nextInt();
            scanner.nextLine();
            if (number >= min && number <= max) {
                break;
            }
            System.out.println("Podana liczba musi być w zakresie " + min + "-" + max + ".");
        }
        return number;
    }
}
