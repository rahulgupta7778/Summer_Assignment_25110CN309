// Write a program to Create voting eligibility system.

import java.util.Scanner;

public class Question_102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Welcome to the Voting Eligibility System ! ---");

        ageInput(sc);

        sc.close();
    }

    public static void ageInput(Scanner sc) {
        int age;

        while (true) {
            System.out.print("Please enter your age here : ");
            age = sc.nextInt();

            if (age <= 0) {
                System.out.println("Invalid Age ! Please enter a valid age.");
            } else {
                break;
            }
        }

        eligibilityCheck(age);
    }

    public static void eligibilityCheck(int age) {
        if (age >= 18) {
            System.out.println("Congratulations ! You can vote.");
        } else {
            System.out.println("Sorry ! You can't vote . ");
        }
    }
}
