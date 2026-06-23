// Write a program to Find first repeating character.

import java.util.Scanner;

public class Question_90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any string : ");
        str = sc.nextLine();
        char repeat = '\0';

        char[] chars = str.toCharArray();
        int freq[] = new int[256];
        for (int i = 0; i < chars.length; i++) {
            int ascii = (int) chars[i];
            if (freq[ascii] > 0) {
                repeat = chars[i];
                break;
            }
            freq[ascii]++;
        }
        if (repeat == '\0') {
            System.out.println("No repeating character in this string.");
        } else {
            System.out.println("The first repeating character in this string is : " + repeat);
        }
        sc.close();
    }
}
