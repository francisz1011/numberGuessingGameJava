import java.util.Scanner;
import java.util.Random;

public class Main {

  public static final int MAX_NUMBER = 10;

  public static void main(String[] args) {

    System.out.println("Welcome to the Random number Guessing Game!");
    System.out.println("Enter your Name:");

    Scanner scanner = new Scanner(System.in);
    String name = scanner.next();
    System.out.println("Hello " + name);

    System.out.println("Start the Game?");
    String game = scanner.next();

    if (game.equals("y")) {
      Random random = new Random();
      int randomNumber = random.nextInt(MAX_NUMBER);
      int numGuesses = 0;
      boolean gameWon = false;

      while (numGuesses < 5 && !gameWon) {
        System.out.println("Guess the number between 0 and " + (MAX_NUMBER-1) + ":");
        int guessedNumber = 0;

        try {
          guessedNumber = scanner.nextInt();
        } catch (Exception e) {
          System.out.println("Invalid input, please enter a number.");
          scanner.next(); // discard invalid input
          continue;
        }

        if (guessedNumber == randomNumber) {
          System.out.println("Congratulations, you've guessed the number right!");
          gameWon = true;
        } else {
          numGuesses++;
          System.out.println("Try again.");

          if (guessedNumber < randomNumber) {
            System.out.println("The number is greater than " + guessedNumber);
          } else {
            System.out.println("The number is lower than " + guessedNumber);
          }
        }
      }

      if (!gameWon) {
        System.out.println("Game over! The number was " + randomNumber + ".");
      }
    }
  }
}
