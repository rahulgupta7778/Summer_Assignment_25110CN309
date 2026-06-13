// Write a program to Find sum and average of array.

import java.util.Scanner;

public class Question_50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[];
        int n;
        int sum = 0;
        double avg = 0;
        System.out.print("Enter the number of elements of array : ");
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + " here : ");
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.print("The array created is : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("The sum of all the elements of array is : " + sum);
        avg = (double) sum / n;
        System.out.println("The average of all the elemnents of array is : " + avg);
        sc.close();
    }
}
