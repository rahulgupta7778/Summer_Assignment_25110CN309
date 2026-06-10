// Write a program to Print character pyramid.
//     A
//    ABA
//   ABCBA
//  ABCDCBA
// ABCDEDCBA

public class Question_40 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            char a = 'A';

            for (int k = 1; k <= (2 * i - 1); k++) {
                if (k <= i) {
                    System.out.print(a);
                    a++;
                } else {
                    a--;
                    a--;
                    System.out.print(a);
                    a++;
                }
            }

            System.out.println();
        }

    }
}
