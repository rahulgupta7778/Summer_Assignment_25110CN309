// Write a program to Check symmetric matrix.

import java.util.Scanner;

public class Question_78 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[][];
        int n;
        System.out.print("Enter order of  matrix : ");
        n = sc.nextInt();
        arr1 = new int[n][n];
        System.out.println("Enter elements of matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter element at " + i + "," + j + " : ");
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("The matrix created is : ");
        boolean found = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i][j] != arr1[j][i]) {
                    found = false;
                    break;
                }
            }
        }
        if (found == false) {
            System.out.println("Matrix is not symmetric");
        } else {
            System.out.println("Matrix is symmetric");
        }
        sc.close();
    }
}
