// Write a program to Recursive sum of digits.

import java.util.Scanner;

public class Question_27 {

    static int sumOfDigits(int n) {

        if (n == 0) {
            return 0;
        }

        return (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;

        System.out.print("Enter the number : ");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("Invalid number");
        } else {
            System.out.println("The sum of digits of " + num + " is : " + sumOfDigits(num));
        }

        sc.close();
    }
}