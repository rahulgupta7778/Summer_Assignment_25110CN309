// Write a program to Recursive factorial.

import java.util.Scanner;

public class Question_25 {

    static long factorial(int n) {

        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a;

        System.out.print("Enter the number : ");
        a = sc.nextInt();

        if (a < 0) {
            System.out.println("Invalid number");
        } else {
            System.out.println("The factorial of " + a + " is : " + factorial(a));
        }

        sc.close();
    }
}