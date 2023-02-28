import java.util.Random;
import java.util.Scanner;
/**
* This program tells you if the users input is
* the same as the system random number.
*
* @author  Jedidiah Alfred
* @version 1.0
* @since   2023/02/08
*/

public final class DiceGame {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private DiceGame() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    */

    public static void main(String[] args) {
        // Creating the random generator
        final Random rand = new Random();

        // Creating the scanner.
        final Scanner scanner = new Scanner(System.in);

        // Constants and vars that are used throughout the program.
        int guesses = 0;
        int guess = 0;
        final int max = 6;
        final int randomNum = rand.nextInt(6) + 1;
        boolean guessIncorrect = true;
        // Do while loop allows for at least one run through of the game
        do {
            // Getting the guesses
            System.out.print("Put in your guess a number: ");
            final String userNum = scanner.nextLine();

            try {
                guess = Integer.parseInt(userNum);
                // Making sure the number is in range
                if (guess >= 1 && guess <= max) {
                    // Checking to see if number is too high, low or correct
                    if (guess > randomNum) {
                        System.out.println(
                                "Your guess is too high. Try again!"
                        );
                        guesses++;
                    } else if (guess < randomNum) {
                        System.out.println(
                                "Your guess is too low. Try again!");
                        guesses++;
                    } else {
                        guesses++;
                        // different amounts of guesses
                        // with different reply for how many tries
                        if (guesses == 1) {
                            System.out.println(
                                    "You guessed the "
                                    + "correct number on your first try!");
                        } else {
                            System.out.println(
                                "You guessed the correct number!"
                                            + " It took you " + guesses
                                    + " tries!");
                        }
                        guessIncorrect = false;
                    }
                } else {
                    System.out.println("Your guess must be between 1-6");
                }
            } catch (NumberFormatException error) {
                System.out.println("Please enter a valid input");
            }
        } while (guess != randomNum);
    }
}
