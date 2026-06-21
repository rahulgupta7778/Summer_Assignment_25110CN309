// Write a program to Reverse a string.

import java.util.Scanner;

public class Question_82 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any string : ");
        str = sc.nextLine();

        char[] chars = str.toCharArray();
        char temp;
        for (int i = 0; i < chars.length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        String str2 = new String(chars);
        System.out.println("The reversed string is : " + str2);
        sc.close();
    }
}
