// Write a program to Compress a string.

import java.util.Scanner;

public class Question_94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any string : ");
        str = sc.nextLine();

        if (str.isEmpty()) {
            System.out.println("The compressed string is : ");
            sc.close();
            return;
        }

        String ans = "";
        char[] chars = str.toCharArray();
        int count = 1;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                ans = ans + chars[i] + count;
                count = 1;
            } else {
                count++;
            }
        }

        ans = ans + chars[chars.length - 1] + count;

        System.out.println("The compressed string is : " + ans);
        sc.close();
    }
}
