// Write a program to Move zeroes to end.

import java.util.Scanner;

public class Question_60 {
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
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }
        while (index < n) {
            arr[index] = 0;
            index++;
        }
        System.out.print("The array after moving zeroes at end : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
