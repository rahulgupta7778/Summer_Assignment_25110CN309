// Write a program to Check strong number.

import java.util.Scanner;

public class Question_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num, sum = 0;
        System.out.print("Enter the number : ");
        num = sc.nextLong();
        long temp = num;
        while (temp > 0) {
            long digit = temp % 10;
            long product = 1;
            for (int i = 1; i <= digit; i++) {
                product *= i;
            }
            sum += product;
            temp = temp / 10;
        }
        if (sum == num) {
            System.out.println("It's a strong number");
        } else {
            System.out.println("Not a strong number");
        }
        sc.close();
    }
}
