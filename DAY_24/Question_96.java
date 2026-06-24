// Write a program to Remove duplicate characters.

import java.util.Scanner;

public class Question_96 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any string : ");
        str = sc.nextLine();
        char[] chars = str.toCharArray();
        int[] freq = new int[256];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            int ascii = (int) chars[i];
            if (freq[ascii] == 0) {
                freq[ascii]++;
                ans.append(chars[i]);
            }
        }
        System.out.println("The string created after removing duplicate characters : " + ans);
        sc.close();
    }
}
