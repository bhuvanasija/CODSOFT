import java.util.Scanner;
import java.util.Random;

public class numberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;   // 🏆 Total games won
        int losses = 0; // ❌ Total games lost

        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number 1-100
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it. Good luck!");

            // 🎮 Game loop
            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int guess;

                if (!scanner.hasNextInt()) {
                    System.out.println("⚠ Please enter a valid number!");
                    scanner.next(); // Skip wrong input
                    continue;
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    guessed = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // 📊 Game result
            if (guessed) {
                System.out.println("\n🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                wins++;
            } else {
                System.out.println("\n❌ Sorry! You've used all your attempts.");
                System.out.println("The number was: " + numberToGuess);
                losses++;
            }

            // 📌 Show score
            System.out.println("\n📊 Score: Wins = " + wins + ", Losses = " + losses);

            // 🔄 Ask if player wants to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = scanner.next().toLowerCase();

            if (!choice.equals("yes") && !choice.equals("y")) {
                playAgain = false;
                System.out.println("\n👋 Thanks for playing! Final Score: Wins = " + wins + ", Losses = " + losses);
            }
        }

        scanner.close();
    }
}
