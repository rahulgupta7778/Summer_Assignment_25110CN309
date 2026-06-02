// Write a program to Check whether a number is prime.

import java.util.Scanner;
import java.lang.Math;

public class Question_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a;
        System.out.print("Enter the number to check : ");
        a = sc.nextLong();

        if (a <= 1) {
            System.out.println("Neither prime nor composite");
        } else if (a == 2 || a == 3) {
            System.out.println("Prime number");
        } else {
            int isprime = 0;
            for (long i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    isprime = 1;
                    break;
                }
            }
            if (isprime == 1) {
                System.out.println("Composite number");
            } else {
                System.out.println("Prime number");
            }
        }
        sc.close();
    }
}
