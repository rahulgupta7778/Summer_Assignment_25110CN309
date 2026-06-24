// Write a program to Find longest word.

import java.util.Scanner;

public class Question_95 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter any sentence : ");
        str = sc.nextLine();

        String[] words = str.split("\\s+");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("The longest word in this sentence is: " + longestWord);
        sc.close();
    }
}
