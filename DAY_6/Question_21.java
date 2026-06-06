// Write a program to Convert decimal to binary

import java.util.Scanner;

public class Question_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a;
        long binary_num = 0, rem = 0, reversed_num = 0;
        System.out.print("Enter the number : ");
        a = sc.nextLong();
        if (a == 0) {
            System.out.println("The binary conversion of 0 will be : 0");
        } else {
            System.out.print("The binary conversion of " + a + " will be : ");
            do {
                rem = a % 2;
                a = a / 2;
                reversed_num = (reversed_num * 10) + rem;
            } while (a > 0);
            while (reversed_num > 0) {
                rem = reversed_num % 10;
                binary_num = (binary_num * 10) + rem;
                reversed_num = reversed_num / 10;
            }
            System.out.println(binary_num);
        }
        sc.close();
    }

}
