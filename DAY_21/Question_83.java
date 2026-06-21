// Write a program to Count vowels and consonants.

import java.util.Scanner;

public class Question_83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int consonant = 0, vowel = 0;
        System.out.print("Enter any string : ");
        str = sc.nextLine();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'a':
                    vowel++;
                    break;
                case 'e':
                    vowel++;
                    break;
                case 'i':
                    vowel++;
                    break;
                case 'o':
                    vowel++;
                    break;
                case 'u':
                    vowel++;
                    break;
                case 'A':
                    vowel++;
                    break;
                case 'E':
                    vowel++;
                    break;
                case 'I':
                    vowel++;
                    break;
                case 'O':
                    vowel++;
                    break;
                case 'U':
                    vowel++;
                    break;
                default:
                    if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                        consonant++;
                    }
                    break;
            }
        }
        System.out.println("Total number of vowels : " + vowel);
        System.out.println("Total number of consonants : " + consonant);
        sc.close();
    }
}
