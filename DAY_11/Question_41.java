// Write a program to Write function to find sum of two numbers.

import java.util.Scanner;

public class Question_41 {
    static int sum(int a, int b) {
        int result = a + b;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        System.out.print("Enter the first number : ");
        num1 = sc.nextInt();
        System.out.print("Enter the second number : ");
        num2 = sc.nextInt();
        System.out.println("The sum of " + num1 + " and " + num2 + " is : " + sum(num1, num2));
        sc.close();
    }
}
