// Write a program to Check anagram strings.

import java.util.Scanner;

public class Question_91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, str2;

        System.out.print("Enter a string : ");
        str = sc.nextLine();
        System.out.print("Enter another string : ");
        str2 = sc.nextLine();

        if (str.length() != str2.length()) {
            System.out.println("Strings are not anagrams.");
        } else {
            char[] chars = str.toCharArray();
            char[] chars2 = str2.toCharArray();
            int freq[] = new int[256];
            for (int i = 0; i < chars.length; i++) {
                freq[(int) chars[i]]++;
                freq[(int) chars2[i]]--;
            }
            int found = 1;
            for (int i = 0; i < 256; i++) {
                if (freq[i] != 0) {
                    found = 0;
                    break;
                }
            }
            if (found == 1) {
                System.out.println("Both strings are anagrams.");
            } else {

                System.out.println("Strings are not anagrams.");
            }
        }
        sc.close();
    }
}
