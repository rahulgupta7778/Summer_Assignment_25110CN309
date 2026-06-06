// Write a program to Count set bits in a number.

import java.util.Scanner;

public class Question_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a;
        int count = 0;
        System.out.print("Enter the number : ");
        a = sc.nextLong();
        if (a == 0) {
            System.out.println("The number of set bits in 0 is : 0");
        } else {
            System.out.print("The number of set bits in " + a + " will be : ");
            do {
                if (a % 2 == 1) {
                    count++;
                }
                a = a / 2;
            } while (a > 0);
            System.out.println(count);
        }
        sc.close();
    }
}
