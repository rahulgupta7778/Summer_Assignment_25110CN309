// Write a program to Find sum of digits of a number.

import java.util.Scanner;

public class Question_5 {
    public static void main(String[] args) {
        long a;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        a = sc.nextLong();

        long temp = a;
        while (temp > 0) {
            sum += temp % 10;
            temp = temp / 10;
        }

        System.out.println("The sum of digits of " + a + " is " + sum);

        sc.close();
    }
}
