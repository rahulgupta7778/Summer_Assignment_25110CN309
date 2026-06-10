// Write a program to Print number pyramid.
//     1
//    121
//   12321
//  1234321
// 123454321

public class Question_39 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            int a = 2;

            for (int k = 1; k <= (2 * i - 1); k++) {
                if (k <= i) {
                    System.out.print(k);
                } else {
                    System.out.print(k - a);
                    a += 2;
                }
            }

            System.out.println();
        }

    }
}
