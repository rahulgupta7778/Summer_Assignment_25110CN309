// Write a program to Convert lowercase to uppercase.

import java.util.Scanner;

public class Question_84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        System.out.print("Enter a character : ");
        ch = sc.next().charAt(0);
        if (ch >= 'a' && ch <= 'z') {
            char ch1 = (char) (ch - 32);
            System.out.println("Uppercase : " + ch1);
        } else {
            System.out.println("Invalid input ! Please enter a lowercase character.");
        }
        sc.close();
    }
}
