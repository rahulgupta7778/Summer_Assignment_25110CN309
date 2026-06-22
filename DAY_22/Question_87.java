// Write a program to Character frequency

import java.util.Scanner;

public class Question_87 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any string : ");
        str = sc.nextLine();

        char[] chars = str.toCharArray();
        int[] frequency = new int[256];
        for (int i = 0; i < chars.length; i++) {
            int ascii = chars[i];
            frequency[ascii]++;
        }
        System.out.println("Character frequencies are : ");
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (frequency[ch] > 0) {
                System.out.println("'" + ch + "' appears " + frequency[ch] + " time(s)");

                frequency[ch] = 0;
            }
        }
        
        sc.close();
    }
}
