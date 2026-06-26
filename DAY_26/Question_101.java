// Write a program to Create number guessing game.

import java.util.Scanner;

public class Question_101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rand = 1 + (int) (Math.random() * 100);
        int guessed;
        int attempts = 0;

        System.out.println("--- Welcome to the Number Guessing Game! ---");
        System.out.println("I have chosen a number between 1 and 100. Start guessing!");

        do {
            System.out.print("Enter your guess: ");
            guessed = sc.nextInt();
            attempts++;

            if (guessed == rand) {
                System.out.println("Congratulations! You found the number in " + attempts + " attempts.");
                break;
            } else if (guessed > rand) {
                System.out.println("Wrong guess ! Guess a smaller number.");
            } else {
                System.out.println("Wrong guess ! Guess a larger number.");
            }
        } while (guessed != rand);

        sc.close();
    }
}
