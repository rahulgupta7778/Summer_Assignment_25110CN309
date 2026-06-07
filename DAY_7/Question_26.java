// Write a program to Recursive Fibonacci.

import java.util.Scanner;

public class Question_26 {

    static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter the number of terms : ");
        n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number");
        } else {

            System.out.println("Fibonacci series is : ");

            for (int i = 0; i < n; i++) {
                System.out.print(fibonacci(i) + " ");
            }
        }

        sc.close();
    }
}