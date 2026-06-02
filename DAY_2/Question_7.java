// Write a program to Find product of digits.

import java.util.Scanner;

public class Question_7 {
    public static void main(String[] args) {
        long a;
        long product = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        a = sc.nextLong();
        long temp = a;
        if (a == 0) {
            product = 0;
        } else {
            while (temp > 0) {
                product *= temp % 10;
                temp = temp / 10;
            }
        }

        System.out.println("The product of digits of " + a + " is " + product);

        sc.close();
    }
}