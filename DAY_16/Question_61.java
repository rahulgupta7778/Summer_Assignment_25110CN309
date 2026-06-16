// Write a program to Find missing number in array.

import java.util.Scanner;

public class Question_61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[];
        int n;
        int sum = 0;
        System.out.print("Enter the number of elements of array : ");
        n = sc.nextInt();
        arr = new int[n];
        System.out.println("Note : Please enter the elements in a consecutive manner.");
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
        int final_sum = ((n + 1) * (n + 2)) / 2;
        int missing = final_sum - sum;
        System.out.println("The missing element is : " + missing);

        sc.close();
    }
}
