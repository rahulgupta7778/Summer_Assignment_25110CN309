// Write a program to Frequency of an element.

import java.util.Scanner;

public class Question_54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[];
        int n;
        int search = 0;
        int freq = 0;
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
        System.out.print("Enter the element for checking the frequency : ");
        search = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (search == arr[i]) {
                freq++;
            }
        }
        if (freq == 0) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Frequency of element " + search + " is : " + freq);
        }
        sc.close();
    }
}
