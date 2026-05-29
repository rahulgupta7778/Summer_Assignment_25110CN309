// Write a program to Reverse a number.

import java.util.Scanner;

public class Question_6 {

    public static void main(String[] args) {
        long a;
        long sum = 0;
        Scanner sc = new Scanner(System.in);
        long temp = 0;
        System.out.print("Enter the number: ");
        a = sc.nextLong();

        while (a > 0) {
            temp = a % 10;
            sum = (sum * 10) + temp;
            a = a / 10;
        }

        System.out.println("The reversed number is " + sum);

        sc.close();
    }
}