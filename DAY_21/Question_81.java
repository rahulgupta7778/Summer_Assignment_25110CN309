// Write a program to Find string length without strlen().

import java.util.Scanner;

public class Question_81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any string : ");
        str = sc.nextLine();

        int count = 0;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count++;
        }

        System.out.println("The length of string is : " + count);
        sc.close();
    }
}
