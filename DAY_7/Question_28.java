// Write a program to Recursive reverse number.

import java.util.Scanner;

public class Question_28 {

    static int reverse = 0;

    static int reverseOfDigits(int n) {

        if (n == 0) {
            return reverse;
        }

        reverse = (reverse * 10) + (n % 10);

        return reverseOfDigits(n / 10);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;

        System.out.print("Enter the number : ");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("Invalid number");
        } 
        else {
            System.out.println("The reverse of " + num + " is : " + reverseOfDigits(num));
        }

        sc.close();
    }
}