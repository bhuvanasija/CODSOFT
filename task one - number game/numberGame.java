import java.util.Scanner;
import java.util.Random;

public class numberGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rand = new Random();

        int win = 0;
        int loss = 0; 

        boolean playAgain = true;

        System.out.println("Welcome to Number Game");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it right.");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int guess;

                if (!scn.hasNextInt()) {
                    System.out.println("Please enter a valid number");
                    scn.next();
                    continue;
                }

                guess = scn.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    guessed = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (guessed) {
                System.out.println("\nCongratulations! You guessed the number in " + attempts + " attempts.");
                win++;
            } else {
                System.out.println("\n You've used all your attempts.");
                System.out.println("The number was: " + numberToGuess);
                loss++;
            }

            System.out.println("\nScore: Wins = " + win + ", Losses = " + loss);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = scn.next().toLowerCase();

            if (!choice.equals("yes") && !choice.equals("y")) {
                playAgain = false;
                System.out.println("\nThanks for playing! Final Score: Wins = " + win + ", Losses = " + loss);
            }
        }

        scn.close();
    }
}
