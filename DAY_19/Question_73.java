// Write a program to Add matrices.

import java.util.Scanner;

public class Question_73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[][], arr2[][];
        int row1, col1, row2, col2;
        System.out.print("Enter the number of rows of first matrix : ");
        row1 = sc.nextInt();
        System.out.print("Enter the number of columns of first matrix: ");
        col1 = sc.nextInt();
        System.out.print("Enter the number of rows of second matrix : ");
        row2 = sc.nextInt();
        System.out.print("Enter the number of columns of second matrix: ");
        col2 = sc.nextInt();
        if (row1 == row2 && col1 == col2) {
            arr1 = new int[row1][col1];
            arr2 = new int[row2][col2];
            System.out.println("Enter elements of first matrix.");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print("Enter element at " + i + "," + j + " : ");
                    arr1[i][j] = sc.nextInt();
                }
            }
            System.out.println("Enter elements of second matrix.");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print("Enter element at " + i + "," + j + " : ");
                    arr2[i][j] = sc.nextInt();
                }
            }
            System.out.println("The first matrix created is : ");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print(arr1[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("The second matrix created is : ");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print(arr2[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("The addition matrix created is : ");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print((arr1[i][j] + arr2[i][j]) + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Addition not possible ! Rows of columns of both matrices should be same");
        }
        sc.close();
    }
}
