// Write a program to Rotate array right.

import java.util.Scanner;

public class Question_59 {
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
        int temp = arr[n - 1];
        int k;
        for (k = n - 1; k > 0; k--) {
            arr[k] = arr[k - 1];
        }
        arr[k] = temp;
        System.out.print("The right rotated array is : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
