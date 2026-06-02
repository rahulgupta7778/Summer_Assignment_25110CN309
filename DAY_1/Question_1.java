// Write a program to Calculate sum of first N natural numbers.

import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) {
        long a;
        long sum = 0;

        System.out.println("Enter the termination number: ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();

        for (long i = 1; i <= a; i++) {
            sum += i;
        }

        System.out.println("The sum of all the numbers upto " + a + " is " + sum);
        sc.close();
    }
}