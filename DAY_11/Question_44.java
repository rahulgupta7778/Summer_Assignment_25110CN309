// Write a program to Write function to find factorial.

import java.util.Scanner;

public class Question_44 {
    static void factorial(int a) {
        long product = 1;
        if (a < 0) {
            System.out.println("Invalid number");
        } else {
            for (long i = 1; i <= a; i++) {
                product *= i;
            }

            System.out.println("The factorial of " + a + " is " + product);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        System.out.print("Enter the number : ");
        num1 = sc.nextInt();
        factorial(num1);
        sc.close();
    }
}
