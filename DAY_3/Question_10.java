// Write a program to Print prime numbers in a range.

import java.util.Scanner;
import java.lang.Math;

public class Question_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num1, num2;
        System.out.print("Enter first number : ");
        num1 = sc.nextLong();
        System.out.print("Enter second number : ");
        num2 = sc.nextLong();
        System.out.println(("Prime numbers between " + num1 + " & " + num2 + " are : "));
        for (long i = num1; i <= num2; i++) {
            if (i <= 1) {
                continue;
            } else if (i == 2 || i == 3) {
                System.out.print(i + " ");
            } else {
                int isprime = 0;
                for (long j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isprime = 1;
                        break;
                    }
                }
                if (isprime != 1) {
                    System.out.print(i + " ");
                }
            }
        }
        sc.close();
    }
}
