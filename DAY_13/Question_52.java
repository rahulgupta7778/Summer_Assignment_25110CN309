// Write a program to Count even and odd elements.

import java.util.Scanner;

public class Question_52 {
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
        int even = 0, odd = 0;

        System.out.print("The array created is : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] % 2 == 1) {
                odd++;
            } else {
                even++;
            }
        }
        System.out.println();
        System.out.println("The number of even elements are : " + even);
        System.out.println("The number of odd elements are : " + odd);
        sc.close();
    }
}
