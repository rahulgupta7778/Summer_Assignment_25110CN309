// Write a program to Find factorial of a number.

import java.util.Scanner;

public class Question_3 {
    public static void main(String[] args) {
        long a;
        long product = 1;
        System.out.print("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();

        if (a < 0) {
            System.out.println("Invalid number");
        } else {
            for (long i = 1; i <= a; i++) {
                product *= i;
            }

            System.out.println("The factorial of " + a + " is " + product);
        }
        sc.close();
    }
}
