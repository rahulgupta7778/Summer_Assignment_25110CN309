// Write a program to Check palindrome string.

import java.util.Scanner;

public class Question_85 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any string : ");
        str = sc.nextLine();

        char[] chars = str.toCharArray();
        boolean found = true;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                found = false;
                break;
            }
        }
        if (found == true) {
            System.out.println("String is Palindrome.");
        } else {
            System.out.println("String is not Palindrome.");
        }
        sc.close();
    }
}