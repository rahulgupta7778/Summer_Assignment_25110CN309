// Write a program to Merge two sorted arrays.

import java.util.Scanner;

public class Question_97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[], arr2[];
        int n1, n2;
        System.out.print("Enter the number of elements in first array : ");
        n1 = sc.nextInt();
        System.out.print("Enter the number of elements in second array : ");
        n2 = sc.nextInt();
        arr1 = new int[n1];
        arr2 = new int[n2];
        System.out.println("Note : Please enter sorted arrays.");
        System.out.println("Enter elements of first array.");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter element " + (i + 1) + " here : ");
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter elements of second array.");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Enter element " + (i + 1) + " here : ");
            arr2[i] = sc.nextInt();
        }
        System.out.print("The array first created is : ");
        for (int i = 0; i < n1; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.print("The array second created is : ");
        for (int i = 0; i < n2; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        int[] arr3 = merge(arr1, arr2);
        System.out.print("The merged sorted arrays wii be : ");
        for (int i : arr3) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }
}
