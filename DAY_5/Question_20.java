// Write a program to Find largest prime factor.

import java.util.Scanner;

public class Question_20 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long num, prev = 0;

        System.out.print("Enter the number : ");
        num = sc.nextLong();

        System.out.print("The largest Prime factor of " + num + " is : ");

        for (long i = 2; i <= num; i++) {

            if (num % i == 0) {

                int isPrime = 1;

                for (long j = 2; j <= Math.sqrt(i); j++) {

                    if (i % j == 0) {
                        isPrime = 0;
                        break;
                    }
                }

                if (isPrime == 1) {
                    prev = i;
                }
            }
        }

        System.out.println(prev);

        sc.close();
    }
}