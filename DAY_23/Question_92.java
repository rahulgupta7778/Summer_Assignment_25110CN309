// Write a program to Find maximum occurring character.

import java.util.Scanner;

public class Question_92 {
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
        int max = 0;
        int maxAscii = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxAscii = i;
            }
        }
        System.out.println("The maximum occuring character in this string is : " + (char) maxAscii);
        sc.close();
    }
}
