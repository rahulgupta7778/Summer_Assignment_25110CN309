// Write a program to Write function for palindrome.

import java.util.Scanner;

public class Question_45 {
    static void palindrome(int a) {
        int temp = 0, reversed_number = 0;
        int temp2 = a;

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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        System.out.print("Enter the number : ");
        num1 = sc.nextInt();
        palindrome(num1);
        sc.close();
    }
}
