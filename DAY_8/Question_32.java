// Write a program to Print repeated-number pattern.
// 1
// 22
// 333
// 4444
// 55555

public class Question_32 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+ " ");
            }
            System.err.println();
        }
    }
}
