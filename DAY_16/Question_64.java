// Write a program to Remove duplicates from array.

import java.util.Scanner;

public class Question_64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[];
        int n;
        System.out.print("Enter the number of elements of array : ");
        n = sc.nextInt();
        arr = new int[n];
        System.out.println("Note : Please enter the elements in increasing sorted form.");

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + " here : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("The array created is : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        if (n == 0 || n == 1) {
            System.out.println("The array after removing duplicates is the same.");
            sc.close();
            return;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[uniqueIndex]) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }

        System.out.print("The array after removing duplicates is : ");
        for (int i = 0; i <= uniqueIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}