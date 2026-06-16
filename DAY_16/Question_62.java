// Write a program to Find maximum frequency element.

import java.util.Scanner;

public class Question_62 {
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
        int freq_element = arr[0];
        int freq = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > freq) {
                freq = count;
                freq_element = arr[i];
            }
        }
        System.out.println("The element with maximum frequency is : " + freq_element);
        sc.close();
    }
}
