// Write a program to Binary search.

import java.util.Scanner;

public class Question_71 {
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
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int median = (first + last) / 2;
            if (search == arr[median]) {
                found = true;
                System.out.println("Searched element found at : " + median);
                break;
            } else if (search < arr[median]) {
                last = median - 1;
            } else {
                first = median + 1;
            }
        }
        if (found == false) {
            System.out.println("Invalid search ! Element not found.");
        }
        sc.close();
    }
}
