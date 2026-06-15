// Write a program to Rotate array left.

import java.util.Scanner;

public class Question_58 {
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
        int temp = arr[0];
        int k = 0;
        for (k = 0; k < n - 1; k++) {
            arr[k] = arr[k + 1];
        }
        arr[k] = temp;
        System.out.print("The left rotated array is : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
