// Write a program to Find row-wise sum.

import java.util.Scanner;

public class Question_79 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[][];
        int row1 , col1;
        System.out.print("Enter the number of rows of matrix : ");
        row1 = sc.nextInt();
        System.out.print("Enter the number of columns of matrix: ");
        col1 = sc.nextInt();
        arr1 = new int[row1][col1];
        System.out.println("Enter elements of matrix : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print("Enter element at " + i + "," + j + " : ");
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("The matrix created is : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < row1; i++) {
            int sum = 0;
            for (int j = 0; j < col1; j++) {
                sum += arr1[i][j];
            }
            System.out.println("The sum of elements of row " + (i+1) + " : " + sum);
        }

        sc.close();
    }    
}
