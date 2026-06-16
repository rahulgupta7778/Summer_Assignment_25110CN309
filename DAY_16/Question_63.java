// Write a program to Find pair with given sum.

import java.util.Scanner;

public class Question_63 {
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
        System.out.print("Enter the target sum : ");
        int target = sc.nextInt();

        int first = 0, last = n - 1;

        while (first < last) {
            if ((arr[first] + arr[last]) == target) {
                break;
            } else if ((arr[first] + arr[last]) < target) {
                first++;
            } else {
                last--;
            }
        }

        if (first < last && (arr[first] + arr[last] == target)) {
            System.out.println("The two numbers are : " + arr[first] + " and " + arr[last]);
        } else {
            System.out.println("No pair found with the given sum.");
        }

        sc.close();
    }
}