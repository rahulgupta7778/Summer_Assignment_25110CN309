// Write a program to Count digits in a number.

import java.util.Scanner;

public class Question_4 {

    public static void main(String[] args) {
        long a;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        a = sc.nextLong();

        long temp = a;
        while (temp > 0) {
            temp = temp / 10;
            count++;
        }

        System.out.println("There are " + count + " digits in " + a);

        sc.close();
    }
}