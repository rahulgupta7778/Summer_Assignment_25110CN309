// Write a program to Find duplicates in array.

import java.util.Scanner;

public class Question_56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[];
        int n;
        System.out.print("Enter the number of elements of array : ");
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + " here : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("The array created is : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int freq = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    freq++;
                    found = true;
                }
            }
            if (freq == 2) {
                System.out.print(arr[i] + " ");
            }
        }
        if (found == false) {
            System.out.println("No duplicate element found.");
        } else {
            System.out.println(" are the duplicate elements.");
        }
        sc.close();
    }
}
