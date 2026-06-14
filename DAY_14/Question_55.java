// Write a program to Second largest element.

import java.util.Scanner;

public class Question_55 {
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
        int greatest = arr[0], second_largest = Integer.MIN_VALUE;

        System.out.print("The array created is : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if (greatest < arr[i]) {
                greatest = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (second_largest < arr[i] && arr[i] != greatest) {
                second_largest = arr[i];
            }
        }
        System.out.println();
        if (second_largest == Integer.MIN_VALUE) {
            System.out.println("Second largest element does not exist.");
        } else {
            System.out.println("The second largest element is : " + second_largest);
        }
        sc.close();
    }
}
