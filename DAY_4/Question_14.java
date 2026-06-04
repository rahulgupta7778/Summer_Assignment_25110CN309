// Write a program to Find nth Fibonacci term.

import java.util.Scanner;

public class Question_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num1, num2, num3 = 0 , nth_term;
        System.out.print("Enter the nth term : ");
        nth_term = sc.nextLong();
        num1 = 0;
        num2 = 1;
        System.out.print("The " + nth_term + " term of Fibonacci series is : ");
        if (nth_term <= 0) {
            System.out.println("An Invalid number");
        } else if (nth_term == 1) {
            System.out.println(num1);
        } else if (nth_term == 2) {
            System.out.println(num2);
        } else {
            for (long i = 1; i <= nth_term - 2; i++) {
                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;
            }
            System.out.print(num3);
        }

        sc.close();
    }
}
