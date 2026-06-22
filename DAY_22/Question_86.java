// Write a program to Count words in a sentence.

import java.util.Scanner;

public class Question_86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any sentence : ");
        str = sc.nextLine();

        char[] chars = str.toCharArray();
        int count = 0;
        boolean isWord = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (!isWord) {
                    count++;
                    isWord = true;
                }
            } else {
                isWord = false;
            }
        }
        System.out.println("Number of words in this sentence are : " + (count));
        sc.close();
    }
}
