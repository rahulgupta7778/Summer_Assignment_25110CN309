// Write a program to Write function for perfect number.

import java.util.Scanner;

public class Question_48 {
    static void perfect(int num) {
        int sum = 0;
        for (long i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            System.out.println("It's a perfect number");
        } else {
            System.out.println("Not a perfect number");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.print("Enter the number : ");
        a = sc.nextInt();
        perfect(a);
        sc.close();
    }
}
