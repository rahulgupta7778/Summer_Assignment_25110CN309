// Write a program to Write function to find maximum.

import java.util.Scanner;

public class Question_42 {
    static int maximum(int a, int b , int c) {
        int result;
        if (a > b) {
           if( a > c)
             result = a;
            else 
                result = c;
        }
        else{
            if(b > c)
                result = b;
            else 
                result = c;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2 , num3;
        System.out.print("Enter the first number : ");
        num1 = sc.nextInt();
        System.out.print("Enter the second number : ");
        num2 = sc.nextInt();
        System.out.print("Enter the third number : ");
        num3 = sc.nextInt();
        System.out.println(maximum(num1, num2 , num3) + " is greatest");
        sc.close();
    }
}
