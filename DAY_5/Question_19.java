// Write a program to Print factors of a number.

import java.util.Scanner;

public class Question_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num;
        System.out.print("Enter the number : ");
        num = sc.nextLong();
        System.out.print("Factors of " + num + " are : ");
        long i = 1;
        do {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
            i++;
        } while (i <= num);
        sc.close();
    }
}
