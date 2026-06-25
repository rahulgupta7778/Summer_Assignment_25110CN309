// Write a program to Sort words by length.

import java.util.Scanner;

public class Question_100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any sentence : ");
        String str = sc.nextLine();

        if (str.trim().isEmpty()) {
            System.out.println("The sentence is empty.");
            sc.close();
            return;
        }

        String[] words = str.split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1 - i; j++) {
                if (words[j].length() > words[j + 1].length()) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        System.out.print("Words sorted by length : ");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        sc.close();
    }
}
