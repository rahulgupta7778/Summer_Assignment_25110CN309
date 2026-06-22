// Write a program to Remove spaces from string.

import java.util.Scanner;

public class Question_88 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any sentence : ");
        str = sc.nextLine();

        char[] chars = str.toCharArray();
        int currentLength = chars.length;

        for (int i = 0; i < currentLength; i++) {
            if (chars[i] == ' ') {
                for (int j = i; j < currentLength - 1; j++) {
                    chars[j] = chars[j + 1];
                }
                currentLength--;
                i--;
            }
        }

        String str2 = new String(chars, 0, currentLength);
        System.out.println("The sentence after removing spaces : " + str2);
        sc.close();
    }
}
