// Write a program to Check Armstrong number.

import java.util.Scanner;

public class Question_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num, sum = 0;
        System.out.print("Enter the number : ");
        num = sc.nextLong();
        int digit_count = 0;
        long temp1 = num;
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
        sc.close();
    }
}
