// Write a program to Generate Fibonacci series.

import java.util.Scanner;

public class Question_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num1, num2, num3, termination_num;
        System.out.print("Enter the termination number : ");
        termination_num = sc.nextLong();
        num1 = 0;
        num2 = 1;
        if (termination_num <= 0) {
            System.out.println("Invalid number");
        } else if (termination_num == 1) {
            System.out.println(num1);
        } else if (termination_num == 2) {
            System.out.println(num1 + " " + num2);
        } else {
            System.out.print(num1 + " " + num2 + " ");
            for (long i = 1; i <= termination_num - 2; i++) {
                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;
                System.out.print(num3 + " ");
            }
        }
        sc.close();
    }
}
