// Write a program to Find GCD of two numbers.

import java.util.Scanner;

public class Question_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num1, num2;
        System.out.print("Enter first number : ");
        num1 = sc.nextLong();
        System.out.print("Enter second number : ");
        num2 = sc.nextLong();
        long min = Math.min(num1, num2);
        System.out.print("GCD of " + num1 + " and " + num2 + " is: ");
        long isfactor = 1;
        for (long i = 2; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                isfactor = i;
            }
        }
        System.out.println(isfactor);

        sc.close();
    }
}
