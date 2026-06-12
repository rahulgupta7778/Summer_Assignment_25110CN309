// Write a program to Write function for Armstrong.

import java.util.Scanner;

public class Question_46 {
    static void armstrong(int num) {
        int digit_count = 0;
        long temp1 = num;
        int sum = 0;
        while (temp1 > 0) {
            temp1 = temp1 / 10;
            digit_count++;
        }
        temp1 = num;
        while (temp1 > 0) {
            sum += Math.pow(temp1 % 10, digit_count);
            temp1 = temp1 / 10;
        }

        if (sum == num) {
            System.out.println("It's an armstrong number");
        } else {
            System.out.println(("Not an armstrong number"));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        System.out.print("Enter the number : ");
        num1 = sc.nextInt();
        armstrong(num1);
        sc.close();
    }
}
