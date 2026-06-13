// Write a program to Find largest and smallest element.

import java.util.Scanner;

public class Question_51 {
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
        int greatest = arr[0], smallest = arr[0];

        System.out.print("The array created is : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
            if (greatest < arr[i]) {
                greatest = arr[i];
            }
        }
        System.out.println();
        System.out.println("The greatest element : " + greatest);
        System.out.println("The smallest element : " + smallest);
        sc.close();
    }
}
