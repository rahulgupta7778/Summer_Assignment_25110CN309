// Write a program to Print multiplication table of a given number.

import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {
        long a;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        a = sc.nextLong();

        for (long i = 1; i <= 10; i++) {
            System.out.println(a + " X " + i + " = " + a * i);
        }
        sc.close();
    }
}