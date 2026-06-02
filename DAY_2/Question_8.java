// Write a program to Check whether a number is palindrome.

import java.util.Scanner;

public class Question_8 {
    public static void main(String[] args) {
        long a;
        long reversed_number = 0;
        Scanner sc = new Scanner(System.in);

        long temp = 0;
        System.out.print("Enter the number: ");
        a = sc.nextLong();

        long temp2 = a;

        while (a > 0) {
            temp = a % 10;
            reversed_number = (reversed_number * 10) + temp;
            a = a / 10;
        }

        if (reversed_number == temp2) {
            System.out.println("Yes, this number is Palindrome.");
        } else {
            System.out.println("No, this number is not palindrome.");
        }

        sc.close();
    }
}