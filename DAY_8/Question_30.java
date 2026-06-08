// Write a program to Print number triangle.
// 1
// 12
// 123
// 1234
// 12345

public class Question_30 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+ " ");
            }
            System.err.println();
        }
    }
}
