// Write a program to Transpose matrix.

import java.util.Scanner;

public class Question_75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[][], arr2[][];
        int row1, col1;
        System.out.print("Enter the number of rows of matrix : ");
        row1 = sc.nextInt();
        System.out.print("Enter the number of columns of matrix: ");
        col1 = sc.nextInt();
        arr1 = new int[row1][col1];
        System.out.println("Enter elements of matrix.");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print("Enter element at " + i + "," + j + " : ");
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("The first matrix created is : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        arr2 = new int[col1][row1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                arr2[j][i] = arr1[i][j];
            }
        }
        System.out.println("The transpose of this matrix is : ");
        for (int i = 0; i < col1; i++) {
            for (int j = 0; j < row1; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

}
