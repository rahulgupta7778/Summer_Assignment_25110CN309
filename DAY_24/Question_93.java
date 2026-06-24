// Write a program to Check string rotation.

import java.util.Scanner;

public class Question_93 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, str2;

        System.out.print("Enter a string : ");
        str = sc.nextLine();
        System.out.print("Enter another string : ");
        str2 = sc.nextLine();
        if (str.length() != str2.length()) {
            System.out.println("Strings are not rotations of each other.");
        } else {
            char[] chars = str.toCharArray();
            char[] chars2 = str2.toCharArray();
            char[] concat = new char[2 * chars.length];
            int a = 0;
            for (int i = 0; i < (2 * chars.length); i++) {
                if (i < chars.length) {
                    concat[a] = chars[i];
                    a++;
                } else {
                    concat[a] = chars[i - chars.length];
                    a++;
                }
            }
            int final_found = 0;
            for (int i = 0; i < str.length(); i++) {
                int found = 1;
                int k = 0;
                for (int j = i; j < (i + str.length()); j++) {
                    if (chars2[k] != concat[j]) {
                        found = 0;
                        break;
                    }
                    k++;
                }
                if (found == 1) {
                    final_found = 1;
                    break;
                }
            }
            if (final_found == 1) {
                System.out.println("Strings are rotations of each other.");
            } else {
                System.out.println("Strings are not rotations of each other.");
            }
        }
        sc.close();
    }
}
