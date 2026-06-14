// Write a program to Linear search.

import java.util.Scanner;

public class Question_53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[];
        int n;
        int search = 0;
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
        System.out.print("Enter the element to be searched : ");
        search = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (search == arr[i]) {
                System.out.println("Element found at position : " + (i + 1));
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Invalid search ! Element not found.");
        }
        sc.close();
    }

}
