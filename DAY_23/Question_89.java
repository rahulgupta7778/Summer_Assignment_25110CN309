// Write a program to Find first non-repeating character.

import java.util.Scanner;

public class Question_89 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any string : ");
        str = sc.nextLine();

        char[] chars = str.toCharArray();
        int freq[] = new int[256];
        for (int i = 0; i < chars.length; i++) {
            int ascii = (int) chars[i];
            freq[ascii]++;
        }
        char non_repeat = '\0';
        for (int i = 0; i < chars.length; i++) {
            int ascii = (int) chars[i];
            if (freq[ascii] == 1) {
                non_repeat = chars[i];
                break;
            }
        }
        if (non_repeat == '\0') {
            System.out.println("No non - repeating character in this string.");
        } else {
            System.out.println("The first non - repeating character in this string is : " + non_repeat);
        }
        sc.close();
    }
}
