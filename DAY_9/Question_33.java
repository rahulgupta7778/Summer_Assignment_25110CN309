// Write a program to Print reverse star pattern.
// *****
// ****
// ***
// **
// *

public class Question_33 {
    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.err.println();
        }
    }
}
