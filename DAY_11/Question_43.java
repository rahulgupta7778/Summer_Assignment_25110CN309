// Write a program to Write function to check prime.

import java.util.Scanner;

public class Question_43 {
    static void prime(int a) {
        if (a <= 1) {
            System.out.println("Neither prime nor composite");
        } else if (a == 2 || a == 3) {
            System.out.println("Prime number");
        } else {
            int isprime = 0;
            for (long i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    isprime = 1;
                    break;
                }
            }
            if (isprime == 1) {
                System.out.println("Composite number");
            } else {
                System.out.println("Prime number");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        System.out.print("Enter the number : ");
        num1 = sc.nextInt();
        prime(num1);
        sc.close();
    }
    
}
