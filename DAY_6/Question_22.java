// Write a program to Convert binary to decimal.

import java.util.Scanner;

public class Question_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a, rem = 0;
        int count = 0;
        long decimal_num = 0;
        System.out.print("Enter the binary number : ");
        a = sc.nextLong();
        if (a == 0) {
            System.out.println("The decimal conversion of 0 will be : 0");
        } else {
            System.out.print("The decimal conversion of " + a + " will be : ");
            while (a > 0) {
                rem = a % 10;
                a = a / 10;
                decimal_num += Math.pow(2, count) * rem;
                count++;
            }

            System.out.println(decimal_num);
        }
        sc.close();
    }
}
