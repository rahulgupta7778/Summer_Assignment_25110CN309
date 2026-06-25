// Write a program to Find common characters in strings.

import java.util.Scanner;

public class Question_98 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, str2;

        System.out.print("Enter a string : ");
        str = sc.nextLine();
        System.out.print("Enter another string : ");
        str2 = sc.nextLine();
        char[] chars = str.toCharArray();
        char[] chars2 = str2.toCharArray();
        int freq[] = new int[256];
        int freq2[] = new int[256];
        for (char i : chars) {
            int ascii = (int) i;
            freq[ascii]++;
        }
        for (char i : chars2) {
            int ascii2 = (int) i;
            freq2[ascii2]++;
        }
        System.out.println("The common characters in both strings are : ");
        for (int i = 0; i < 256; i++) {
            // Find the minimum frequency count between both strings
            int commonCount = Math.min(freq[i], freq2[i]);

            // Print the character as many times as it appears in both
            for (int j = 0; j < commonCount; j++) {
                System.out.print((char) i + " ");
            }
        }
        sc.close();
    }
}
