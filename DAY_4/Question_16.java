// Write a program to Print Armstrong numbers in a range.

import java.util.Scanner;

public class Question_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num1, num2;
        int found = 0;
        System.out.print("Enter first number : ");
        num1 = sc.nextLong();
        System.out.print("Enter second number : ");
        num2 = sc.nextLong();
        System.out.print("Armstrong numbers between " + num1 + " and " + num2 + " : ");
        for (long i = num1; i <= num2; i++) {
            long temp1 = i;
            long sum = 0;
            int digit_count = 0;
            while (temp1 > 0) {
                temp1 = temp1 / 10;
                digit_count++;
            }
            temp1 = i;
            while (temp1 > 0) {
                sum += Math.pow(temp1 % 10, digit_count);
                temp1 = temp1 / 10;
            }

            if (sum == i) {
                found++;
                System.out.print(i + " ");
            }
        }
        if (found == 0) {
            System.out.print("No armstrong numnber exists");
        }
        sc.close();
    }
}
