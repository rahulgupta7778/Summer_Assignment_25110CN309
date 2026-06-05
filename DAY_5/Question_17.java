// Write a program to Check perfect number.

import java.util.Scanner;

public class Question_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num, sum = 0;
        System.out.print("Enter the number : ");
        num = sc.nextLong();
        for (long i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            System.out.println("It's a perfect number");
        } else {
            System.out.println("Not a perfect number");
        }

        sc.close();
    }
}
