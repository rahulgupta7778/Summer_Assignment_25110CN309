// Write a program to Find LCM of two numbers.

import java.util.Scanner;

public class Question_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num1, num2;
        System.out.print("Enter first number : ");
        num1 = sc.nextLong();
        System.out.print("Enter second number : ");
        num2 = sc.nextLong();
        long min = Math.min(num1, num2);
        System.out.print("lcm of " + num1 + " and " + num2 + " is: ");
        long isfactor = 1;
        for (long i = 2; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                isfactor = i;
            }
        }
        long lcm = (num1 * num2) / isfactor;
        System.out.println(lcm);
        sc.close();
    }
}
