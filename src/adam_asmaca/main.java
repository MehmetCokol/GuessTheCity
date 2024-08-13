package adam_asmaca;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Istanbul");
        cities.add("Paris");
        cities.add("Madrid");
        cities.add("London");
        cities.add("Lisboa");
        cities.add("Tokyo");
        cities.add("Rome");
        cities.add("Amsterdam");

        int index = random.nextInt(cities.size());
        String chosen_city = cities.get(index).toLowerCase();
        // System.out.println(chosen_city);

        System.out.println("Welcome to the 'Guess the City' game!".toUpperCase());
        System.out.println("\nWhich difficulty mode would you like to play on?");
        System.out.println("Press 1 for EASY MODE -- 12 guesses");
        System.out.println("Press 2 for NORMAL MODE -- 8 guesses");
        System.out.println("Press 3 for HARD MODE -- 5 guesses");
        System.out.print("Your Choice :");
        int remainingGuess = 1;
        boolean durum = true;

        while (durum) {
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("\nYou choose to play Easy Mode  ");
                        durum = false;
                        remainingGuess = 12;
                        break;
                    case 2:
                        System.out.println("\nYou choose to play Normal Mode  ");
                        remainingGuess = 8;
                        durum = false;
                        break;
                    case 3:
                        System.out.println("\nYou choose to play Hard Mode ");
                        durum = false;
                        remainingGuess = 5;
                        break;
                    default:
                        System.out.println("\nYou can't choose any other game mode");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input, please enter a valid number.");
                System.out.print("Your choice :");
                input.next();
            }
        }


        boolean[] guessed_letters = new boolean[chosen_city.length()];
        System.out.println("Enter a letter to find the hidden city!");

        while (remainingGuess > 0) {
            System.out.println();

            for (int i = 0; i < chosen_city.length(); i++) {
                if (guessed_letters[i]) {
                    System.out.print(chosen_city.charAt(i) + " ");
                } else {
                    System.out.print("_ ");
                }
            }

            System.out.println("\nYou have " + remainingGuess + " guesses left");
            System.out.print("Guess a letter :");
            char guess = Character.toLowerCase(input.next().charAt(0));
            boolean isFound = false;

            for (int i = 0; i < chosen_city.length(); i++) {
                if (chosen_city.charAt(i) == guess) {
                    guessed_letters[i] = true;
                    isFound = true;
                }
            }

            if (isFound) {
                System.out.println("(+) Letter guessed correctly");
            } else {
                System.out.println("(-) Letter guessed wrong");
                remainingGuess--;
            }

            boolean isComplete = true;
            for (boolean letter : guessed_letters) {
                if (!letter) {
                    isComplete = false;
                }
            }
            if (isComplete) {
                System.out.println("\nCongratulations! You guessed the city correctly.".toUpperCase());
                System.out.println("City :" + chosen_city.toUpperCase());
                break;
            }
        }
        if (remainingGuess == 0) {
            System.out.println("\n****************");
            System.out.println("GAME OVER !");
            System.out.println("City: " + chosen_city.toUpperCase());
        }
    }
}
