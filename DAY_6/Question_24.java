// Write a program to Find x^n without pow().

import java.util.Scanner;

public class Question_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num, power, answer = 1;
        double neg_answer = 1;
        System.out.print("Enter the number : ");
        num = sc.nextLong();
        System.out.print("Enter the power : ");
        power = sc.nextLong();
        System.out.print("Answer for " + num + "^" + power + " will be : ");
        if (power > 0) {
            for (long i = 1; i <= power; i++) {
                answer *= num;
            }
            System.out.println(answer);
        } else if (power == 0) {
            System.out.println("1");
        } else {
            power = -power;
            for (long i = 1; i <= power; i++) {
                answer *= num;
            }
            neg_answer = 1.0 / answer;
            System.out.println(neg_answer);
        }
        sc.close();
    }

}
