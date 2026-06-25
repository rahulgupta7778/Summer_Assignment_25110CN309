// Write a program to Sort names alphabetically.

import java.util.Scanner;

public class Question_99 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("Enter the number of names you want to sort : ");
        n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];

        System.out.println("Enter the names:");
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + " here : ");
            names[i] = sc.nextLine();
        }

        System.out.print("The names entered are : ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        System.out.print("The names sorted alphabetically are : ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        sc.close();
    }
}
