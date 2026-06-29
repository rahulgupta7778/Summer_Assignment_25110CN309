// Write a program to Create menu-driven string operations system.

import java.util.Scanner;

public class Question_115 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======= Window for STRING operations =======");
        choiceTaker();
        System.out.println("-----------------------------------------------------");

    }

    public static void header(String title) {
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("                 " + title);
        System.out.println("=====================================================");
    }

    public static void choiceTaker() {
        while (true) {
            System.out.println("[1] Find Length of string");
            System.out.println("[2] Convert to Uppercase");
            System.out.println("[3] Convert to Lowercase");
            System.out.println("[4] Reverse the string");
            System.out.println("[5] Check palindrome");
            System.out.println("[6] Count Vowels and Consonants");
            System.out.println("[7] Count Words");
            System.out.println("[8] Get a character frequency");
            System.out.println("[9] Concatenate two strings");
            System.out.println("[10] Replace a character");
            System.out.println("[11] Remove Spaces");
            System.out.println("[12] Exit");
            System.out.println("----------------------------------------------------");
            System.out.print("Choose your operation now : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    lengthfinder();
                    break;
                case 2:
                    convertUppercase();
                    break;
                case 3:
                    convertLowercase();
                    break;
                case 4:
                    stringReverse();
                    break;
                case 5:
                    checkPalindrome();
                    break;
                case 6:
                    vowelConsonantCounter();
                    break;
                case 7:
                    wordCount();
                    break;
                case 8:
                    characterFrequency();
                    break;
                case 9:
                    concatenateStrings();
                    break;
                case 10:
                    characterReplacer();
                    break;
                case 11:
                    spaceRemove();
                    break;
                case 12:
                    System.out.println("~ Successfully Exited.");
                    System.exit(0);
                default:
                    System.out.println("INVALID Input! Please enter a valid choice.");
                    continue;
            }
        }
    }

    public static String stringInput() {
        sc.nextLine();
        System.out.print("Enter the string : ");
        return sc.nextLine();
    }

    public static void lengthfinder() {
        header("FIND STRING LENGTH");
        String str = stringInput();
        System.out.println("Length of this string is : " + str.length());
        System.out.println("-----------------------------------------------------");
        endChoice();
    }

    public static void convertUppercase() {
        header("UPPERCASE CONVERTER");

        String str = stringInput();
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
        }

        str = new String(chars);
        System.out.println("String will be : " + str);
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void convertLowercase() {
        header("LOWERCASE CONVERTER");

        String str = stringInput();
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }

        str = new String(chars);
        System.out.println("String will be : " + str);
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void stringReverse() {
        header("REVERSE YOUR STRING");
        String str = stringInput();
        char[] chars = str.toCharArray();
        char temp;
        for (int i = 0; i < chars.length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        str = new String(chars);
        System.out.println("The reversed string is : " + str);
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void checkPalindrome() {
        header("PALINDROME CHECKER");
        String str = stringInput();
        char[] chars = str.toCharArray();
        boolean found = true;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                found = false;
                break;
            }
        }
        if (found) {
            System.out.println("String is Palindrome.");
        } else {
            System.out.println("String is not Palindrome.");
        }

        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void vowelConsonantCounter() {
        header("COUNT VOWELS AND CONSONANTS");
        String str = stringInput();
        char[] chars = str.toCharArray();
        int consonant = 0, vowel = 0;
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
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void wordCount() {
        header("COUNT WORDS");
        String str = stringInput();
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
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void characterFrequency() {
        header("CHECK CHARACTER FREQUENCY");
        String str = stringInput();
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
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void concatenateStrings() {
        header("CONCATENATE TWO STRINGS");
        String str1 = stringInput();
        System.out.print("Enter another string : ");
        String str2 = sc.nextLine();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] last = new char[chars1.length + chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            last[i] = chars1[i];
        }
        for (int i = 0; i < chars2.length; i++) {
            last[chars1.length + i] = chars2[i];
        }
        String str3 = new String(last);
        System.out.println("String after concatenation : " + str3);
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void spaceRemove() {
        header("SPACE REMOVER");
        String str = stringInput();
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
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void characterReplacer() {
        header("CHARACTER REPLACER");
        String str = stringInput();
        System.out.print("Enter the replacable character : ");
        char replace = sc.next().charAt(0);
        System.out.print("Enter the replacing character: ");
        char ch = sc.next().charAt(0);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == replace) {
                chars[i] = ch;
            }
        }
        String last = new String(chars);
        System.out.println("New string is : " + last);
        System.out.println("----------------------------------------------------");
        endChoice();
    }

    public static void endChoice() {
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("What do you want next ? ");
        System.out.println("[1] Perform operation.");
        System.out.println("[2] Exit.");
        System.out.print("Enter your choice : ");
        while (true) {
            int choice = sc.nextInt();

            if (choice == 1) {
                return;
            } else if (choice == 2) {
                System.out.println("~ Successfully Exited.");
                System.exit(0);
            } else {
                System.out.println("Invalid Choice!");
            }
        }
    }
}